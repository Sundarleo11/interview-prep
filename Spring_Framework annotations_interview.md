
# 🌱 Spring Annotations Cheat Sheet

A **comprehensive guide** to commonly used **Spring Framework** and **Spring Boot** annotations with definitions

---

## ✅ 1. Core Stereotype Annotations

| Annotation       | Definition                                                                                  |
|-----------------|---------------------------------------------------------------------------------------------|
| **@Component**   | Marks a class as a Spring-managed component (bean). Generic stereotype for any bean.     |
| **@Service**     | Specialization of `@Component`. Indicates business logic layer.                           |
| **@Repository**  | Specialization of `@Component`. DAO layer; provides persistence exception translation.    |
| **@Controller**  | Used in Spring MVC to define a web controller that handles HTTP requests.                 |
| **@RestController** | Combines `@Controller` and `@ResponseBody`. Used to build REST APIs returning JSON/XML.|

---
Spring MVC Architecture

MVC stands for:

Model → Holds application data and business logic.

View → Displays data (UI).

Controller → Handles user requests, processes them using the model, and returns the view.

```
Client Request → DispatcherServlet → Controller → Service → DAO → Model
           ↓
      View Resolver → View (HTML/JSP/JSON)
           ↓
       Response to Client

```

---

## ✅ 2. Dependency Injection Annotations

| Annotation      | Definition                                                                                   |
|---------------|------------------------------------------------------------------------------------------------|
| **@Autowired**  | Injects dependencies by type. Works on fields, constructors, and setters.                  |
| **@Qualifier**  | Resolves ambiguity when multiple beans of the same type exist (used with `@Autowired`).     |
| **@Primary**    | Marks a bean as the preferred choice during autowiring when multiple candidates exist.      |
| **@Value**      | Injects values from property files, environment variables, or SpEL. Example: `@Value("${app.name}")`. |
| **@Lazy**       | Marks a bean for lazy initialization (created only when needed).                            |
| **@Scope**      | Defines bean scope: `singleton`, `prototype`, `request`, `session`, `application`.         |



| **Scope**             | **Description**                                                                                    |
| --------------------- | -------------------------------------------------------------------------------------------------- |
| `singleton` (default) | A single instance per Spring container (shared across the application).                            |
| `prototype`           | A new bean instance is created every time it is requested.                                         |
| `request`             | A new bean instance is created for every HTTP request (Web-aware only).                            |
| `session`             | A single bean instance is created for an HTTP session (Web-aware only).                            |
| `application`         | A single bean instance is created for the entire web application lifecycle (ServletContext scope). |


---

## ✅ 3. Configuration & Bean Annotations

| Annotation        | Definition                                                                               |
|-------------------|------------------------------------------------------------------------------------------|
| **@Configuration** | Marks a class as a source of Spring bean definitions.                                   |
| **@Bean**          | Declares a bean inside a `@Configuration` class (equivalent to `<bean>` in XML).        |
| **@PropertySource**| Specifies a property file to load configuration values.                                  |
| **@Import**        | Allows importing additional configuration classes.                                       |

---

## ✅ 4. Spring Boot Specific Annotations

| Annotation              | Definition                                                                    |
|-------------------------|-------------------------------------------------------------------------------|
| **@SpringBootApplication** | Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.|
| **@EnableAutoConfiguration** | Enables Spring Boot’s auto-configuration.                                  |
| **@ComponentScan**       | Defines the packages to scan for components (`@Component`, `@Service`, etc.). |

---

## ✅ 5. AOP (Aspect-Oriented Programming) Annotations

| Annotation        | Definition                                                                            |
|-------------------|---------------------------------------------------------------------------------------|
| **@Aspect**       | Marks a class as an Aspect for AOP.                                                  |
| **@Before**       | Advice that runs before a method execution.                                          |
| **@After**        | Advice that runs after method execution (success or failure).                        |
| **@AfterReturning**| Advice that runs only after successful execution.                                    |
| **@AfterThrowing** | Advice that runs when a method throws an exception.                                  |
| **@Around**       | Advice that runs before and after a method execution (can modify input/output).      |
| **@Pointcut**     | Defines reusable pointcut expressions for AOP.                                       |

---

## ✅ 6. Transaction Management

| Annotation        | Definition                                                            |
|-------------------|-----------------------------------------------------------------------|
| **@Transactional**| Marks a class or method as transactional. Manages DB transactions automatically. |

---

## ✅ 7. Spring MVC & REST Annotations

| Annotation         | Definition                                                                           |
|--------------------|--------------------------------------------------------------------------------------|
| **@RequestMapping**| Maps HTTP requests to handler methods (supports all HTTP methods).                   |
| **@GetMapping**, **@PostMapping**, **@PutMapping**, **@DeleteMapping**, **@PatchMapping** | Shorthand for specific HTTP methods. |
| **@RequestParam**  | Extracts query parameters from the request.                                          |
| **@PathVariable**  | Extracts values from the URI path.                                                   |
| **@RequestBody**   | Binds HTTP request body to a Java object.                                            |
| **@ResponseBody**  | Indicates the return value should be written directly to the response body.          |
| **@ModelAttribute**| Binds a model attribute to a method parameter.                                       |
| **@ExceptionHandler** | Handles specific exceptions in a controller.                                       |
| **@ControllerAdvice** | Global exception handler for controllers.                                          |
| **@RestControllerAdvice** | Combines `@ControllerAdvice` and `@ResponseBody` for REST APIs.               |

---

## ✅ 8. Security Annotations

| Annotation        | Definition                                                             |
|-------------------|------------------------------------------------------------------------|
| **@EnableWebSecurity**| Enables Spring Security configuration.                              |
| **@PreAuthorize** | Checks method access using SpEL expressions (role-based security).     |
| **@Secured**      | Specifies security roles allowed to access a method.                   |

---

## ✅ 9. Scheduling & Async Annotations

| Annotation          | Definition                                              |
|---------------------|---------------------------------------------------------|
| **@EnableScheduling**| Enables scheduling in Spring.                          |
| **@Scheduled**       | Schedules a method to run at fixed intervals or cron. |
| **@EnableAsync**      | Enables asynchronous method execution.                |
| **@Async**            | Executes a method asynchronously in a separate thread.|



## ✅ 10. Unit Testing Annotations in Spring Boot

| **Annotation**                         | **Definition / Purpose**                                                                         |
| -------------------------------------- | ------------------------------------------------------------------------------------------------ |
| **@RunWith(SpringRunner.class)**       | Integrates Spring TestContext Framework with JUnit (used in JUnit 4).                            |
| **@ExtendWith(SpringExtension.class)** | Integrates Spring TestContext Framework with JUnit 5 (Jupiter).                                  |
| **@SpringBootTest**                    | Loads the complete Spring application context for integration testing.                           |
| **@WebMvcTest**                        | Loads only the **web layer** (controllers, filters) for MVC tests (no Service/Repository beans). |
| **@DataJpaTest**                       | Loads only JPA components (repositories) with an in-memory database for testing.                 |
| **@MockBean**                          | Creates a mock of a Spring bean and adds it to the ApplicationContext for test isolation.        |
| **@SpyBean**                           | Creates a spy (partial mock) of a Spring bean and adds it to the ApplicationContext.             |
| **@TestConfiguration**                 | Defines additional beans for test purposes (used with @SpringBootTest).                          |
| **@AutoConfigureMockMvc**              | Auto-configures MockMvc for testing Spring MVC controllers without starting a real server.       |
| **@Transactional**                     | Rolls back transactions automatically after each test for database consistency.                  |


## ✅ 11. JPA Entity & Mapping Annotations

| Annotation                                                      | What it does / Key attrs                                                     |
|----------------------------------------------------------------|------------------------------------------------------------------------------|
| `@Entity`                                                     | Marks a class as a JPA entity (must have an id).                            |
| `@Table(name, schema, indexes = …, uniqueConstraints = …)`    | Maps entity to a table and lets you add indexes/uniques.                    |
| `@Id`                                                         | Primary key field.                                                           |
| `@GeneratedValue(strategy = IDENTITY | SEQUENCE | AUTO | TABLE, generator = …)` | Defines PK generation strategy.                                             |
| `@SequenceGenerator(name, sequenceName, allocationSize)`      | Defines a DB sequence for `SEQUENCE` strategy.                              |
| `@TableGenerator`                                             | Uses a table to generate ids (rarely used in modern apps).                  |
| `@Column(name, nullable, unique, length, updatable, insertable)` | Column mapping and constraints.                                          |
| `@Transient`                                                  | Marks a field that should **not** be persisted.                             |
| `@Enumerated(EnumType.STRING | ORDINAL)`                     | Persists enums (prefer `STRING` to avoid issues when enum order changes).   |
| `@Lob`                                                        | Large objects (`TEXT`, `BLOB`).                                             |
| `@Temporal(DATE | TIME | TIMESTAMP)`                          | For legacy `java.util.Date/Calendar`. Not needed for `java.time.*`.         |
| `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`        | Relationship mappings. Use `mappedBy`, `cascade`, `fetch`, `orphanRemoval`. |
| `@JoinColumn(name, nullable)`                                 | Defines FK column for *to-one* relations.                                   |
| `@JoinTable(name, joinColumns, inverseJoinColumns)`           | Join table for many-to-many relationships.                                  |
| `@Embeddable` / `@Embedded`                                   | Value objects embedded into the owning table.                               |
| `@EmbeddedId`                                                 | Composite key as embedded type.                                             |
| `@MapsId`                                                     | Maps relation field into (part of) composite id.                            |
| `@Version`                                                    | Optimistic locking column.                                                  |
| `@Inheritance(strategy = SINGLE_TABLE | JOINED | TABLE_PER_CLASS)` | Inheritance mapping; with `@DiscriminatorColumn/@DiscriminatorValue`.       |
| `@SecondaryTable`                                             | Split entity across multiple tables.                                        |
| `@NamedQuery` / `@NamedQueries`                               | Predefined JPQL queries.                                                    |
| `@Converter` / `@Convert`                                     | Attribute converters for custom types.                                      |


## ✅ 12.  Spring Data Repository & Query Annotations

| Annotation                                                                                                          | What it does / Key attrs                                          |
|---------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| `@EnableJpaRepositories(basePackages = …)`                                                                         | Enables Spring Data JPA repository scanning.                      |
| `@Repository`                                                                                                       | Stereotype; exception translation (part of core annotations).      |
| `@NoRepositoryBean`                                                                                                 | Marks a base repository interface that **should not** be instantiated. |
| `@Query("…")`                                                                                                       | Defines JPQL or native (`nativeQuery = true`) queries.            |
| `@Modifying(clearAutomatically = true, flushAutomatically = true)`                                                  | Marks a `@Query` as update/delete. Requires `@Transactional`.     |
| `@Param("…")`                                                                                                       | Names parameters in `@Query`.                                     |
| `@EntityGraph(attributePaths = { … })`                                                                              | Controls fetch graph to prevent N+1 select problems.              |
| `@Lock(LockModeType.PESSIMISTIC_WRITE | READ | OPTIMISTIC)`                                                        | Applies locking mode on query methods.                            |
| `@Procedure("proc_name")`                                                                                           | Calls a stored procedure from repository method.                  |
| `@QueryHints(@QueryHint(name="…", value="…"))`                                                                      | Adds JPA provider-specific query hints (e.g., read-only).         |
| **Auditing:** `@EnableJpaAuditing`, `@CreatedDate`, `@LastModifiedDate`, `@CreatedBy`, `@LastModifiedBy`, `@EntityListeners(AuditingEntityListener.class)` | Enables automatic population of audit fields (created/modified info). |


---

## ✅ Quick Summary Table

| Category           | Examples                                        |
|--------------------|-----------------------------------------------|
| **Core**           | `@Component`, `@Service`, `@Controller`      |
| **DI**             | `@Autowired`, `@Qualifier`, `@Value`         |
| **Config**         | `@Configuration`, `@Bean`, `@PropertySource` |
| **Boot**           | `@SpringBootApplication`, `@EnableAutoConfiguration` |
| **AOP**            | `@Aspect`, `@Before`, `@Around`             |
| **Transaction**    | `@Transactional`                             |
| **MVC/REST**       | `@GetMapping`, `@RequestBody`, `@PathVariable` |
| **Security**       | `@EnableWebSecurity`, `@PreAuthorize`        |
| **Scheduling**     | `@Scheduled`, `@Async`                      |

---

## ✅ Interview Questions
- Difference between `@Component`, `@Service`, and `@Repository`?
- How does `@Autowired` work internally? By type or by name?
- Difference between `@Controller` and `@RestController`?
- Purpose of `@EnableAutoConfiguration` in Spring Boot?
- Difference between `@RequestParam` and `@PathVariable`?
- How does `@Transactional` handle rollback for checked exceptions?

✅ 1. Difference between @Component, @Service, and @Repository?

@Component

A generic stereotype for any Spring-managed component (bean).

Indicates that the class is a candidate for component scanning and bean creation.

@Service

Specialization of @Component.

Used for service layer classes that contain business logic.

Helps for better readability and intent.

@Repository

Specialization of @Component.

Indicates DAO (Data Access Object) classes.

Enables automatic exception translation for persistence-related exceptions into Spring’s DataAccessException.

👉 Key Difference:
All three register a bean, but @Service and @Repository add semantic meaning and extra behavior (like exception translation).

✅ 2. How does @Autowired work internally? By type or by name?

By default, @Autowired works by type (Spring tries to match the type of the dependency).

If multiple beans of the same type exist, Spring:

Looks for a matching bean name (by property name).

If still ambiguous, throws NoUniqueBeanDefinitionException unless:

@Qualifier is used to specify the bean.

Or one bean is marked with @Primary.

👉 Internals:
Uses reflection and BeanPostProcessor (AutowiredAnnotationBeanPostProcessor) to inject dependencies during bean creation.

✅ 3. Difference between @Controller and @RestController?

@Controller

Used in Spring MVC to return views (HTML, JSP).

Requires @ResponseBody on methods to return JSON/XML.

@RestController

Combines @Controller + @ResponseBody.

Always returns data (JSON/XML) directly, not views.

Commonly used in RESTful web services.

Example:

@Controller
public class MyController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello() { return "Hello"; }
}

@RestController
public class MyRestController {
    @GetMapping("/hello")
    public String hello() { return "Hello"; }
}

✅ 4. Purpose of @EnableAutoConfiguration in Spring Boot?

Tells Spring Boot to auto-configure beans based on:

Classpath dependencies (e.g., if spring-boot-starter-web is present → configures DispatcherServlet, Jackson, etc.)

Properties in application.properties or application.yml.

Eliminates manual configuration of common components (DataSource, DispatcherServlet, etc.).

Used internally in @SpringBootApplication.

✅ 5. Difference between @RequestParam and @PathVariable?
Feature	@RequestParam	@PathVariable
Source	Query parameters or form data	URI path
Example URL	/user?id=101	/user/101
Example Mapping	@RequestParam("id") int id	@PathVariable("id") int id

Example:

@GetMapping("/user")
public String getUser(@RequestParam int id) { return "ID: " + id; }

@GetMapping("/user/{id}")
public String getUserById(@PathVariable int id) { return "ID: " + id; }


✅ 6. How does @Transactional handle rollback for checked exceptions?

By default, Spring rolls back only for unchecked exceptions (RuntimeException and Error).

Checked exceptions (like IOException) do not cause rollback unless:

rollbackFor attribute is specified:

@Transactional(rollbackFor = Exception.class)
public void someMethod() { ... }


Can also configure noRollbackFor for specific exceptions.

✅ 7. @PropertySource vs@Value vs @ConfigurationProperties?


| Feature                 | `@PropertySource`                      | `@Value`                 | `@ConfigurationProperties`                  |
| ----------------------- | -------------------------------------- | ------------------------ | ------------------------------------------- |
| **Purpose**             | Load `.properties` into Spring Context | Inject a single property | Bind multiple properties into a POJO        |
| **Scope**               | Class-level                            | Field / Parameter        | Class-level                                 |
| **Supports YAML**       | ❌                                      | ✅ (via Environment)      | ✅                                           |
| **SpEL Support**        | ❌                                      | ✅                        | ❌                                           |
| **Grouping Properties** | ❌                                      | ❌                        | ✅                                           |
| **Validation**          | ❌                                      | ❌                        | ✅ (JSR-303)                                 |
| **Use Case**            | Non-Boot apps for property files       | Few, simple values       | Many related configs, structured properties |


✅ 8.@Configuration vs @EnableAutoConfiguration

| Aspect         | `@Configuration`               | `@EnableAutoConfiguration`                        |
| -------------- | ------------------------------ | ------------------------------------------------- |
| Purpose        | Defines beans manually in code | Configures beans automatically based on classpath |
| Scope          | Pure Spring core               | Spring Boot-specific                              |
| Manual vs Auto | Manual bean creation           | Automatic configuration                           |
| Common Usage   | Custom configurations          | Boot application startup                          |

---


