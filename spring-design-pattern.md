# 🌱 Spring Design Patterns

Spring Framework is built on many design patterns.  
This document explains the **key design patterns used in Spring** with **definitions, usage, and code examples**.  

Great for **interview preparation** 🚀  

---

# 🔹 Core Patterns in Spring

1. Singleton Pattern  
2. Prototype Pattern  
3. Factory Pattern  
4. Proxy Pattern  
5. Template Method Pattern  
6. Observer Pattern  
7. Adapter Pattern  
8. Decorator Pattern  
9. Front Controller Pattern  
10. Dependency Injection (IoC Principle)  

---

## 1. Singleton Pattern
**Definition**: Ensures only **one instance** of a class is created and shared.  
**Spring Usage**: Default scope of a Spring bean is **singleton**.

- **Why Needed:** Prevents multiple instances, saves memory, ensures consistent state.
- **Scope:** Stateless services, configuration, shared resources.
- **Advantages:** Memory efficient, consistent, easy to debug.
- **Disadvantages:** Not suitable for stateful beans, can cause issues in multi-threaded scenarios.
- **Simple Example:** `@Component` bean returns same instance for every request.
- **Real-time Use Case:** Service classes like `UserService` or `EmailService` that should be shared across the application.

```java
@Component
public class MyService {
    public void serve() {
        System.out.println("Serving from: " + this.hashCode());
    }
}

@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApp.class, args);
        MyService s1 = ctx.getBean(MyService.class);
        MyService s2 = ctx.getBean(MyService.class);
        System.out.println(s1 == s2); // true
    }
}
```

---

## 2. Prototype Pattern
**Definition**: Creates a new instance of a class every time it is requested.  
**Spring Usage**: Bean scope can be set to prototype.

- **Why Needed:** Useful for stateful beans, each request gets a fresh instance.
- **Scope:** Temporary/session data, per-request beans.
- **Advantages:** No shared state, flexible.
- **Disadvantages:** Higher memory usage, harder to manage lifecycle.
- **Simple Example:** `@Scope("prototype")` bean returns new instance each time.
- **Real-time Use Case:** Shopping cart beans in an e-commerce app, where each user/session needs a separate cart instance.

```java
@Component
@Scope("prototype")
public class MyPrototypeService {}

@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApp.class, args);
        MyPrototypeService s1 = ctx.getBean(MyPrototypeService.class);
        MyPrototypeService s2 = ctx.getBean(MyPrototypeService.class);
        System.out.println(s1 == s2); // false
    }
}
```

---

## 3. Factory Pattern
**Definition**: Creates objects without exposing the instantiation logic.  
**Spring Usage**: BeanFactory and ApplicationContext are examples.

- **Why Needed:** Centralizes and abstracts object creation.
- **Scope:** Complex object creation, dependency management.
- **Advantages:** Loose coupling, reusable, easy to manage.
- **Disadvantages:** Can add complexity, extra configuration.
- **Simple Example:** `ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");`
- **Real-time Use Case:** Creating DataSource or Repository beans using Spring's factory mechanisms.

```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
MyBean bean = (MyBean) ctx.getBean("myBean");
```

---

## 4. Proxy Pattern
**Definition**: Provides a surrogate or placeholder for another object to control access.  
**Spring Usage**: Used in AOP (Aspect-Oriented Programming).

- **Why Needed:** Add cross-cutting concerns (logging, security) without changing business logic.
- **Scope:** Logging, security, transactions, caching.
- **Advantages:** Separation of concerns, reusable aspects.
- **Disadvantages:** Can be hard to debug, adds indirection.
- **Simple Example:** `@Aspect` class logs method calls before execution.
- **Real-time Use Case:** Transaction management in Spring, where methods are wrapped with transaction boundaries using proxies.

```java
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore() {
        System.out.println("Logging before method execution");
    }
}
```

---

## 5. Template Method Pattern
**Definition**: Defines the skeleton of an algorithm, deferring steps to subclasses.  
**Spring Usage**: JdbcTemplate, RestTemplate, etc.

- **Why Needed:** Standardizes algorithm structure, allows customization of steps.
- **Scope:** Database access, REST calls, repetitive tasks with variable steps.
- **Advantages:** Reduces code duplication, enforces best practices.
- **Disadvantages:** Can be rigid, subclassing required for customization.
- **Simple Example:** `JdbcTemplate` handles connection, you provide query logic.
- **Real-time Use Case:** Using `JdbcTemplate` to execute SQL queries with custom row mapping logic in a DAO class.

```java
JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
String name = jdbcTemplate.queryForObject("SELECT name FROM users WHERE id=?", String.class, 1);
```

---

## 6. Observer Pattern
**Definition**: Defines a one-to-many dependency so that when one object changes state, all its dependents are notified.  
**Spring Usage**: ApplicationEventPublisher and listeners.

- **Why Needed:** Enables event-driven programming, decouples event source and listeners.
- **Scope:** Application events, messaging, notifications.
- **Advantages:** Loose coupling, scalable, flexible.
- **Disadvantages:** Harder to trace flow, potential performance issues with many listeners.
- **Simple Example:** `ApplicationListener` receives events published in context.
- **Real-time Use Case:** Sending email notifications when a new user registers, using Spring events and listeners.

```java
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    public void onApplicationEvent(MyEvent event) {
        System.out.println("Received event: " + event.getMessage());
    }
}
```

---

## 7. Adapter Pattern
**Definition**: Allows incompatible interfaces to work together.  
**Spring Usage**: HandlerAdapter in Spring MVC.

- **Why Needed:** Integrate legacy or third-party code with new interfaces.
- **Scope:** MVC controllers, external APIs, legacy systems.
- **Advantages:** Reusability, easy integration.
- **Disadvantages:** Adds extra layer, can reduce performance.
- **Simple Example:** `HandlerAdapter` adapts controller methods to HTTP requests.
- **Real-time Use Case:** Integrating a legacy payment gateway API with a modern Spring MVC controller.

```java
public interface Target {
    void request();
}

public class Adapter implements Target {
    private Adaptee adaptee;
    public void request() {
        adaptee.specificRequest();
    }
}
```

---

## 8. Decorator Pattern
**Definition**: Adds behavior to objects dynamically.  
**Spring Usage**: BeanPostProcessor can be used to decorate beans.

- **Why Needed:** Add responsibilities to beans at runtime.
- **Scope:** Logging, validation, monitoring.
- **Advantages:** Flexible, avoids subclass explosion.
- **Disadvantages:** Can make code harder to follow, performance overhead.
- **Simple Example:** `BeanPostProcessor` modifies beans before/after init.
- **Real-time Use Case:** Adding audit logging to all service beans using a custom `BeanPostProcessor`.

```java
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        // decorate bean
        return bean;
    }
}
```

---

## 9. Front Controller Pattern
**Definition**: Provides a centralized request handling mechanism.  
**Spring Usage**: DispatcherServlet in Spring MVC.

- **Why Needed:** Centralizes control, simplifies request processing.
- **Scope:** Web applications, request routing.
- **Advantages:** Consistent handling, easier security and logging.
- **Disadvantages:** Can become a bottleneck, single point of failure.
- **Simple Example:** `DispatcherServlet` routes all HTTP requests in Spring MVC.
- **Real-time Use Case:** All HTTP requests in a Spring Boot web app are routed through `DispatcherServlet` for centralized processing.

```xml
<!-- web.xml -->
<servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
</servlet>
```

---

## 10. Dependency Injection (IoC Principle)
**Definition**: Objects receive their dependencies from an external source rather than creating them.  
**Spring Usage**: Core principle of Spring.

- **Why Needed:** Promotes loose coupling, easier testing and maintenance.
- **Scope:** All layers of large applications.
- **Advantages:** Testable, maintainable, flexible.
- **Disadvantages:** More configuration, can be complex for beginners.
- **Simple Example:** `@Autowired` injects repository into service class.
- **Real-time Use Case:** Injecting a `PaymentService` into an `OrderController` to process payments in an e-commerce application.

```java
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
```
