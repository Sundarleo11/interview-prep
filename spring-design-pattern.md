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

```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
MyBean bean = (MyBean) ctx.getBean("myBean");
```

---

## 4. Proxy Pattern
**Definition**: Provides a surrogate or placeholder for another object to control access.  
**Spring Usage**: Used in AOP (Aspect-Oriented Programming).

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

```java
JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
String name = jdbcTemplate.queryForObject("SELECT name FROM users WHERE id=?", String.class, 1);
```

---

## 6. Observer Pattern
**Definition**: Defines a one-to-many dependency so that when one object changes state, all its dependents are notified.  
**Spring Usage**: ApplicationEventPublisher and listeners.

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

```java
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
```

---
