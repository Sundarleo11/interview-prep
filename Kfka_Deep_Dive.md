
# Apache Kafka Deep Dive (With Visual Diagrams)

This document provides detailed Kafka concepts **with visual ASCII diagrams** so you can easily understand brokers, partitions, replication, consumer groups, and failover.

---

# 1. Kafka High-Level Architecture Diagram

```
                    +----------------------------+
                    |        PRODUCERS           |
                    |  (send events/messages)    |
                    +-------------+--------------+
                                  |
                                  v
                      +----------------------+
                      |        TOPIC         |
                      |   (e.g., orders)     |
                      +----------------------+
                         /        |        \
                        v         v         v
                    +-------+ +-------+ +-------+
                    | P0    | | P1    | | P2    |
                    |(Part0)| |(Part1)| |(Part2)|
                    +---+---+ +---+---+ +---+---+
                        |         |         |
                        v         v         v
               +--------------------------------------+
               |          KAFKA BROKER CLUSTER        |
               | +--------+ +--------+ +--------+      |
               | |Broker1 | |Broker2 | |Broker3 |      |
               | +--------+ +--------+ +--------+      |
               +--------------------------------------+
                        |        |          |
                        v        v          v
                    +----------------------------+
                    |        CONSUMERS           |
                    |   (read messages)          |
                    +----------------------------+
```

---

# 2. Topic → Partition → Broker Mapping

```
Topic: orders
Partitions: 3 (P0, P1, P2)
Brokers: B1, B2, B3
```

```
       +-------------+    +-------------+    +-------------+
       |   Broker 1  |    |   Broker 2  |    |   Broker 3  |
       +-------------+    +-------------+    +-------------+
       |   P0        |    |   P1        |    |   P2        |
       +-------------+    +-------------+    +-------------+
```

---

# 3. Replication Diagram (Replication Factor = 3)

```
LEADER → Handles Read + Write
FOLLOWERS → Replicate data

            Broker1        Broker2        Broker3
         +-----------+  +-----------+  +-----------+
 P0 -->  | Leader    |  | Follower  |  | Follower  |
         +-----------+  +-----------+  +-----------+

 P1 -->  | Follower  |  | Leader    |  | Follower  |
         +-----------+  +-----------+  +-----------+

 P2 -->  | Follower  |  | Follower  |  | Leader    |
         +-----------+  +-----------+  +-----------+
```

---

# 4. Consumer Group Partition Assignment Diagram

```
Topic: orders (3 partitions)

Consumer Group: order-service-group
Consumers: C1, C2

          +------------------------------------+
          |        Consumer Group (CG1)        |
          |------------------------------------|
          |                                     |
          |   C1 → P0, P2                       |
          |   C2 → P1                           |
          |                                     |
          +-------------------------------------+
```

If one consumer dies:

```
C2 Down → Rebalancing occurs

New Assignment:
C1 → P0, P1, P2
```

---

# 5. Kafka Failover (Leader Failure)

```
Partition: P1
Leader: Broker 2
Followers: Broker 1, Broker 3
```

If **Broker 2 fails**:

```
           FAIL
       Broker 2 (Leader)
              X
              |
              v
   Kafka Automatically Elects New Leader

                Broker 1
            becomes new LEADER
```

Diagram:

```
 Before Failure:
    Broker 2 (Leader)
    Broker 1 (Follower)
    Broker 3 (Follower)

 After Failure:
    Broker 1 (Leader)
    Broker 3 (Follower)
    Broker 2 (Down)
```

---

# 6. End-to-End Data Flow Diagram (Deep)

```
Producer → Topic → Leader Partition → Replication → Consumer Group
```

```
Producer
   |
   v
+----------------+
|  Kafka Broker  | <-- Zookeeper/Kraft manages cluster metadata
+----------------+
       |
       v
   Topic: orders
       |
       +------------------------------+
       |         |                    |
       v         v                    v
  +--------+ +--------+         +--------+
  | P0     | | P1     |         | P2     |
  | Leader | | Leader |         | Leader |
  +---+----+ +---+----+         +---+----+
      |          |                  |
      v          v                  v
  Replicas   Replicas           Replicas
```

---

# 7. Java Code — Full Flow Example

## 7.1 Producer Example

```java
Properties props = new Properties();
props.put("bootstrap.servers", "localhost:9092");
props.put("acks", "all");
props.put("retries", 3);
props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

KafkaProducer<String, String> producer = new KafkaProducer<>(props);

for (int i = 0; i < 10; i++) {
    String key = "order-" + i;
    String value = "Order Created #" + i;
    ProducerRecord<String, String> record =
            new ProducerRecord<>("orders", key, value);
    producer.send(record);
}
producer.close();
```

---

## 7.2 Consumer Example (Handles Partition Rebalance)

```java
Properties props = new Properties();
props.put("bootstrap.servers", "localhost:9092");
props.put("group.id", "order-service-group");
props.put("enable.auto.commit", "false");
props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

consumer.subscribe(Arrays.asList("orders"), new ConsumerRebalanceListener() {
    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        System.out.println("Rebalancing... Partitions revoked: " + partitions);
    }
    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        System.out.println("Partitions assigned: " + partitions);
    }
});

while (true) {
    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
    for (ConsumerRecord<String, String> rec : records) {
        System.out.println("Consumed: " + rec.value() +
                           " | Partition: " + rec.partition());
    }
}
```

---

# 8. Partitioning Logic (How Kafka Decides Partition)

```
If key exists: Kafka uses hash(key) % number_of_partitions
If no key: Round-robin
```

Diagram:

```
Key = "Order123"

hash("Order123") % 3 → Partition 1
```

---

# 9. Summary

```
Kafka = Distributed, Scalable, Fault-Tolerant Event Streaming Platform

Partitions → Parallelism
Replication → Fault Tolerance
Consumer Groups → Load Balancing
Brokers → Cluster Storage
```

---

This document now includes:
✔ Deep explanation  
✔ Visual diagrams  
✔ Java snippets  
✔ Partition, replication, and failover flows  

