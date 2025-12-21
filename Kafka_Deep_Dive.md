
# Apache Kafka Overview

## What is Kafka?
Apache Kafka is a distributed event streaming platform used to build real-time data pipelines and streaming applications. It is designed to handle high throughput, fault tolerance, and scalability.

## Core Components
### 1. **Producer**
Sends messages to Kafka topics.

### 2. **Topic**
Logical channel where messages are stored.

### 3. **Partition**
Each topic is divided into partitions to allow parallelism.

### 4. **Broker**
A Kafka server that stores partitions.

### 5. **Consumer**
Reads messages from topics.

### 6. **Consumer Group**
Group of consumers for load balancing.

### 7. **Replication**
Partitions are replicated across brokers for fault tolerance.

---

## How Kafka Works (Flow Overview)

### **1. Producer → Topic → Partitions**
- Producer sends messages.
- Kafka distributes them into partitions (based on key or round‑robin).

### **2. Partition Distribution Across Brokers**
Example:
- Topic: `orders`
- Partitions: `P0, P1, P2`
- Brokers: `B1, B2, B3`

```
P0 → B1  
P1 → B2  
P2 → B3
```

### **3. Replication**
If replication factor = 3:
```
P0 Leader → B1, Followers → B2, B3  
P1 Leader → B2, Followers → B1, B3  
P2 Leader → B3, Followers → B1, B2  
```

### **4. Consumer Groups**
- Each partition is consumed by exactly *one* consumer in a group.

Example:

```
CG1 (Consumer Group):
  C1 → P0
  C2 → P1
  C3 → P2
```

### **5. Fault Tolerance**
- If a broker fails, follower replicas become leaders.
- If a consumer fails, partitions rebalance to others in the group.

---

## When to Use Kafka?

| Use Case | Why Kafka? |
|---------|------------|
| Real-time streaming | High throughput + low latency |
| Event-driven microservices | Decouples services |
| Logs & metrics | Durable and replicated |
| Big Data pipelines | Integrates well with Spark, Flink, etc. |

---

## Java Producer Example

```java
Properties props = new Properties();
props.put("bootstrap.servers", "localhost:9092");
props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

KafkaProducer<String, String> producer = new KafkaProducer<>(props);

ProducerRecord<String, String> record =
        new ProducerRecord<>("orders-topic", "order1", "Order Created");

producer.send(record);
producer.close();
```

---

## Java Consumer Example

```java
Properties props = new Properties();
props.put("bootstrap.servers", "localhost:9092");
props.put("group.id", "order-service");
props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
consumer.subscribe(Arrays.asList("orders-topic"));

while (true) {
    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
    for (ConsumerRecord<String, String> record : records) {
        System.out.println("Consumed: " + record.value());
    }
}
```

---

## Partition Assignment Logic
- Kafka uses **Range**, **Round Robin**, or **Sticky** assignment.
- Ensures each partition is handled by one consumer in the group.

---

## Fault Tolerance Summary
- Brokers replicate partitions.
- If a leader fails → follower becomes leader.
- Consumers rebalance when one dies.

---



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

Kafka provides:
- High throughput
- Scalability (via partitions)
- Fault tolerance (via replication)
- Load balancing (via consumer groups)

Perfect for microservices, streaming, and big data.

````


