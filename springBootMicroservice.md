# Spring Boot Microservices - Complete Interview Guide

## Table of Contents

1. [Fundamentals](#fundamentals)
2. [Design Patterns](#design-patterns)
3. [Communication Patterns](#communication-patterns)
4. [Resilience \& Fault Tolerance](#resilience--fault-tolerance)
5. [Configuration \& Security](#configuration--security)
6. [Data Management](#data-management)
7. [Monitoring \& Deployment](#monitoring--deployment)
8. [Advanced Topics](#advanced-topics)

***

## Fundamentals

### Q1. What is a Microservice?

**Answer:** A microservice is a small, independent, loosely coupled service that owns a specific business capability and communicates with others via APIs or messaging.[^1][^4]

**Key Characteristics:**

- Single responsibility
- Independently deployable
- Own database (database per service)
- Technology agnostic
- Lightweight communication


### Q2. Difference between Monolithic and Microservices Architecture?

| Aspect | Monolithic | Microservices |
| :-- | :-- | :-- |
| **Deployment** | Single unit | Independent services [^5] |
| **Scalability** | Scale entire app | Scale individual services |
| **Technology** | Single stack | Polyglot [^4] |
| **Database** | Shared | Separate per service |
| **Failure Impact** | Entire system | Isolated to service |

### Q3. Advantages of Microservices?

- **Independent Deployment:** Services can be updated without affecting others[^5]
- **Scalability:** Scale only the services that need it
- **Fault Isolation:** Failure in one service doesn't crash the system
- **Technology Diversity:** Use best tools for each service
- **Faster Development:** Teams work independently

***

## Design Patterns

### Q4. What is the API Gateway Pattern?

**Answer:** API Gateway acts as a single entry point for all client requests, handling routing, authentication, rate limiting, and load balancing.[^5]

**Spring Cloud Gateway Example:**

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
        - id: order-service
          uri: lb://ORDER-SERVICE
          predicates:
            - Path=/orders/**
```

**Benefits:**

- Simplifies client-side code
- Centralized security
- Protocol translation
- Response aggregation


### Q5. Explain Service Discovery Pattern with Eureka

**Answer:** Service discovery allows services to find and communicate with each other dynamically without hard-coded addresses.[^4][^5]

**Eureka Server Setup:**

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

**application.yml:**

```yaml
server:
  port: 8761
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

**Eureka Client (Service Registration):**

```java
@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
```

**application.yml:**

```yaml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
spring:
  application:
    name: product-service
```


### Q6. What is the Database per Service Pattern?

**Answer:** Each microservice manages its own database, ensuring loose coupling and independent evolution.[^1][^4]

**Example:**

- **User Service:** PostgreSQL for relational user data
- **Product Catalog:** MongoDB for flexible product schemas
- **Order Service:** MySQL for transactional consistency
- **Analytics Service:** Cassandra for time-series data

**Advantages:**

- Service independence
- Technology choice per service
- Easier scaling
- Fault isolation

**Challenges:**

- Distributed transactions
- Data consistency
- Complex queries across services

***

## Communication Patterns

### Q7. Synchronous vs Asynchronous Communication?

| Aspect | Synchronous | Asynchronous |
| :-- | :-- | :-- |
| **Protocol** | REST, gRPC | Messaging (Kafka, RabbitMQ) |
| **Coupling** | Tight | Loose [^4] |
| **Response** | Immediate | Eventually consistent |
| **Use Case** | Read operations | Events, notifications |

### Q8. REST Communication Example with RestTemplate

```java
@Configuration
public class RestConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;
    
    public User getUserById(Long userId) {
        String url = "http://USER-SERVICE/users/" + userId;
        return restTemplate.getForObject(url, User.class);
    }
}
```


### Q9. How to use Feign Client for Inter-Service Communication?

**Answer:** Feign is a declarative REST client that simplifies HTTP calls.[^4]

```java
@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id);
}

@Service
public class OrderService {
    @Autowired
    private UserClient userClient;
    
    public Order createOrder(Long userId) {
        User user = userClient.getUserById(userId);
        // create order logic
    }
}
```


### Q10. Event-Driven Communication with Kafka

**Producer:**

```java
@Service
public class OrderEventProducer {
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;
    
    public void publishOrderCreated(OrderEvent event) {
        kafkaTemplate.send("order-events", event);
    }
}
```

**Consumer:**

```java
@Service
public class NotificationService {
    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void handleOrderEvent(OrderEvent event) {
        // send notification
        System.out.println("Order created: " + event.getOrderId());
    }
}
```


***

## Resilience \& Fault Tolerance

### Q11. What is Circuit Breaker Pattern?

**Answer:** Circuit Breaker prevents cascading failures by stopping calls to failing services and providing fallback responses.[^1][^5]

**States:**

1. **Closed:** Normal operation
2. **Open:** Requests fail immediately
3. **Half-Open:** Test if service recovered

**Resilience4j Example:**

```java
@Service
public class ProductService {
    
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProduct")
    public Product getProduct(Long id) {
        return restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + id, Product.class);
    }
    
    public Product fallbackGetProduct(Long id, Throwable t) {
        return new Product(id, "Default Product", 0.0);
    }
}
```

**application.yml:**

```yaml
resilience4j:
  circuitbreaker:
    instances:
      productService:
        sliding-window-size: 10
        failure-rate-threshold: 50
        wait-duration-in-open-state: 10000
        permitted-number-of-calls-in-half-open-state: 3
```


### Q12. Explain Retry Pattern

**Answer:** Automatically retry failed requests with configurable delays.[^4]

```java
@Retry(name = "paymentService", fallbackMethod = "fallbackPayment")
public PaymentResponse processPayment(PaymentRequest request) {
    return paymentClient.process(request);
}

public PaymentResponse fallbackPayment(PaymentRequest request, Throwable t) {
    return new PaymentResponse("FAILED", "Service unavailable");
}
```

**Configuration:**

```yaml
resilience4j:
  retry:
    instances:
      paymentService:
        max-attempts: 3
        wait-duration: 1000
        retry-exceptions:
          - java.net.ConnectException
```


### Q13. What is Bulkhead Pattern?

**Answer:** Isolates resources (thread pools) to prevent failures from affecting entire system.[^1]

```java
@Bulkhead(name = "userService", type = Bulkhead.Type.THREADPOOL)
public User getUser(Long id) {
    return userClient.findById(id);
}
```


### Q14. Rate Limiting Pattern

```java
@RateLimiter(name = "orderApi")
@GetMapping("/orders")
public List<Order> getOrders() {
    return orderService.getAllOrders();
}
```

**Configuration:**

```yaml
resilience4j:
  ratelimiter:
    instances:
      orderApi:
        limit-for-period: 10
        limit-refresh-period: 1s
        timeout-duration: 0
```


***

## Configuration \& Security

### Q15. Centralized Configuration with Spring Cloud Config

**Config Server:**

```java
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication { }
```

**application.yml:**

```yaml
server:
  port: 8888
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/yourorg/config-repo
          default-label: main
```

**Client Service:**

```yaml
spring:
  application:
    name: user-service
  config:
    import: configserver:http://localhost:8888
```


### Q16. How to implement OAuth2 Security?

**Resource Server:**

```java
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/api/public/**").permitAll()
            .anyRequest().authenticated();
    }
}
```

**JWT Configuration:**

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://auth-server.com
          jwk-set-uri: https://auth-server.com/.well-known/jwks.json
```


### Q17. Refresh Configuration without Restart (@RefreshScope)

```java
@RestController
@RefreshScope
public class ConfigController {
    
    @Value("${app.message}")
    private String message;
    
    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
```

**Trigger refresh:**

```bash
curl -X POST http://localhost:8080/actuator/refresh
```


***

## Data Management

### Q18. What is Saga Pattern for Distributed Transactions?

**Answer:** Saga manages distributed transactions using a sequence of local transactions with compensating actions.[^5][^1]

**Choreography-based Saga:**

```java
// Order Service
@Service
public class OrderService {
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafka;
    
    public void createOrder(Order order) {
        order.setStatus("PENDING");
        orderRepository.save(order);
        kafka.send("order-created", new OrderEvent(order.getId()));
    }
    
    @KafkaListener(topics = "payment-failed")
    public void compensateOrder(PaymentFailedEvent event) {
        Order order = orderRepository.findById(event.getOrderId());
        order.setStatus("CANCELLED");
        orderRepository.save(order);
    }
}

// Payment Service
@Service
public class PaymentService {
    @KafkaListener(topics = "order-created")
    public void processPayment(OrderEvent event) {
        try {
            // process payment
            kafka.send("payment-success", new PaymentEvent(event.getOrderId()));
        } catch (Exception e) {
            kafka.send("payment-failed", new PaymentFailedEvent(event.getOrderId()));
        }
    }
}
```


### Q19. CQRS Pattern Implementation

**Answer:** Separates read and write operations for scalability.[^4][^1]

```java
// Command Side
@PostMapping("/accounts/transfer")
public ResponseEntity<String> transferMoney(@RequestBody TransferCommand cmd) {
    commandBus.dispatch(cmd);
    return ResponseEntity.accepted().body("Transfer initiated");
}

// Query Side
@GetMapping("/accounts/{id}/balance")
public AccountBalance getBalance(@PathVariable Long id) {
    return queryRepository.findBalanceById(id);
}
```


### Q20. Event Sourcing Pattern

**Answer:** Store state changes as a sequence of immutable events.[^1]

```java
@Entity
public class AccountEvent {
    @Id
    private Long id;
    private Long accountId;
    private String eventType; // CREATED, DEPOSITED, WITHDRAWN
    private BigDecimal amount;
    private LocalDateTime timestamp;
}

@Service
public class AccountEventStore {
    public void saveEvent(AccountEvent event) {
        eventRepository.save(event);
    }
    
    public Account reconstructAccount(Long accountId) {
        List<AccountEvent> events = eventRepository.findByAccountId(accountId);
        Account account = new Account();
        events.forEach(event -> account.apply(event));
        return account;
    }
}
```


***

## Monitoring \& Deployment

### Q21. Distributed Tracing with Sleuth and Zipkin

**Dependencies:**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-zipkin</artifactId>
</dependency>
```

**Configuration:**

```yaml
spring:
  zipkin:
    base-url: http://localhost:9411/
  sleuth:
    sampler:
      probability: 1.0
```


### Q22. Health Checks with Spring Boot Actuator

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

**Custom Health Indicator:**

```java
@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        boolean serviceUp = checkExternalService();
        if (serviceUp) {
            return Health.up().withDetail("service", "Available").build();
        }
        return Health.down().withDetail("service", "Unavailable").build();
    }
}
```


### Q23. Containerization with Docker

**Dockerfile:**

```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/order-service.jar order-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "order-service.jar"]
```

**docker-compose.yml:**

```yaml
version: '3.8'
services:
  eureka-server:
    image: eureka-server:latest
    ports:
      - "8761:8761"
  
  user-service:
    image: user-service:latest
    ports:
      - "8081:8081"
    environment:
      EUREKA_CLIENT_SERVICEURL_DEFAULTZONE: http://eureka-server:8761/eureka/
```


### Q24. Kubernetes Deployment

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: user-service
spec:
  replicas: 3
  selector:
    matchLabels:
      app: user-service
  template:
    metadata:
      labels:
        app: user-service
    spec:
      containers:
      - name: user-service
        image: user-service:1.0
        ports:
        - containerPort: 8080
---
apiVersion: v1
kind: Service
metadata:
  name: user-service
spec:
  selector:
    app: user-service
  ports:
  - port: 80
    targetPort: 8080
  type: LoadBalancer
```


***

## Advanced Topics

### Q25. API Versioning Strategies

```java
// URI Versioning
@GetMapping("/v1/products")
public List<Product> getProductsV1() { }

@GetMapping("/v2/products")
public List<ProductV2> getProductsV2() { }

// Header Versioning
@GetMapping(value = "/products", headers = "API-Version=1")
public List<Product> getProductsV1() { }
```


### Q26. Strangler Pattern for Migration

**Answer:** Gradually replace monolith features with microservices.[^1]

**Steps:**

1. Identify feature to migrate
2. Build new microservice
3. Route traffic to new service
4. Monitor and validate
5. Decommission old code

### Q27. Backends for Frontends (BFF)

```java
// Mobile BFF
@RestController
@RequestMapping("/mobile-api")
public class MobileBFFController {
    public MobileResponse getHomeData() {
        // Aggregate multiple services
        // Return optimized response for mobile
    }
}

// Web BFF
@RestController
@RequestMapping("/web-api")
public class WebBFFController {
    public WebResponse getHomeData() {
        // Different aggregation for web
    }
}
```


### Q28. Concurrent Collections for Thread Safety

```java
// ConcurrentHashMap
private ConcurrentHashMap<String, Product> cache = new ConcurrentHashMap<>();

// CopyOnWriteArrayList
private CopyOnWriteArrayList<String> logs = new CopyOnWriteArrayList<>();

// BlockingQueue
private BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
```


### Q29. Best Practices

**Design Principles:**

- Keep services stateless
- Design for failure
- Automate everything (CI/CD)
- Monitor and log centrally
- Use API gateways
- Implement circuit breakers
- Prefer async communication
- Database per service
- Limit service size (2-pizza team rule)

**Anti-Patterns to Avoid:**

- Shared databases
- Chatty services
- Distributed monolith
- Ignoring network latency
- Missing monitoring


### Q30. Microservices Testing Strategy

**Levels:**

1. **Unit Tests:** Test individual components
2. **Integration Tests:** Test service interactions
3. **Contract Tests:** Verify API contracts
4. **End-to-End Tests:** Test complete flows

**Example:**

```java
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreateOrder() throws Exception {
        mockMvc.perform(post("/orders")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"userId\":1,\"amount\":100}"))
            .andExpect(status().isCreated());
    }
}
```


***

## Common Interview Scenarios

### Scenario 1: How would you handle a failing payment service?

**Answer:**

1. Implement Circuit Breaker
2. Add retry logic with exponential backoff
3. Provide fallback response
4. Queue payment for later processing
5. Notify user of pending status

### Scenario 2: Service A needs data from Services B, C, D. How to optimize?

**Answer:**

1. Use API Gateway for aggregation
2. Implement BFF pattern
3. Consider async communication
4. Cache frequently accessed data
5. Use parallel calls with CompletableFuture

### Scenario 3: How to ensure data consistency across services?

**Answer:**

1. Implement Saga pattern
2. Use event sourcing
3. Eventual consistency model
4. Compensating transactions
5. Distributed tracing for debugging

***

This comprehensive guide covers all essential Spring Boot microservices topics for interviews with practical code examples. Save this as a `.md` file for easy reference and study.[^5][^4][^1]
<span style="display:none">[^2][^3][^6][^7][^8]</span>

<div align="center">⁂</div>

[^1]: https://www.geeksforgeeks.org/advance-java/microservices-interview-questions/

[^2]: https://www.wecreateproblems.com/interview-questions/spring-boot-interview-questions

[^3]: https://www.ashokit.in/blog/top-20-spring-boot-interview-questions-answers

[^4]: https://www.codingshuttle.com/blog/top-20-microservice-interview-questions-for-advanced-spring-boot-developers-in-2025

[^5]: https://www.hirist.tech/blog/top-25-spring-boot-microservices-interview-questions-with-answers/

[^6]: https://www.vinsys.com/blog/microservices-interview-questions

[^7]: https://www.youtube.com/watch?v=cNzFPWuju8k

[^8]: https://nareshit.com/blogs/top-30-spring-boot-and-microservices-interview-questions-for-freshers

