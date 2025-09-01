# Interview Prep Guide

## Index


---

This repository contains comparative study tables for various concepts in Java, Spring, and JavaScript. Below you can find the comparison tables and explanations.

---

## Java Comparisons

### StringBuffer vs StringBuilder

| Feature           | StringBuffer            | StringBuilder            |
| ----------------- | ----------------------- | ------------------------ |
| **Mutability**    | ✅ Mutable               | ✅ Mutable                |
| **Thread-safety** | ✅ Synchronized (safe)   | ❌ Not synchronized       |
| **Performance**   | Slower (sync overhead)  | Faster                   |
| **Best use case** | Multi-threaded programs | Single-threaded programs |
| **Introduced in** | JDK 1.0                 | JDK 1.5                  |

---

### Abstract Class vs Interface

| Feature              | Abstract Class                             | Interface                                                       |
| -------------------- | ------------------------------------------ | --------------------------------------------------------------- |
| **Keyword**          | `abstract class`                           | `interface`                                                     |
| **Methods**          | Can have abstract & concrete methods       | By default abstract (Java 8+: default & static methods allowed) |
| **Variables**        | Can have instance & static variables       | Only `public static final` (constants)                          |
| **Constructors**     | ✅ Yes                                      | ❌ No                                                            |
| **Inheritance**      | A class can extend only 1 abstract class   | A class can implement multiple interfaces                       |
| **Access modifiers** | Can be `private`, `protected`, `public`    | Always `public` (methods & variables)                           |
| **Use case**         | When classes share common state + behavior | When classes just share a contract (no common state)            |

---

### SOLID Principles

- **S** → Single Responsibility (One job per class)
- **O** → Open/Closed (Extend, don’t modify)
- **L** → Liskov Substitution (Subclasses must follow parent contract)
- **I** → Interface Segregation (Small, focused interfaces)
- **D** → Dependency Inversion (Depend on abstractions, not concrete)

---

### Collection vs Collections

| Feature      | **Collection**                      | **Collections**                           |
| ------------ | ----------------------------------- | ----------------------------------------- |
| **Type**     | Interface                           | Utility class                             |
| **Package**  | `java.util.Collection`              | `java.util.Collections`                   |
| **Purpose**  | Defines standard methods for groups | Provides helper methods for collections   |
| **Examples** | `List`, `Set`, `Queue` implement it | `Collections.sort()`, `Collections.max()` |

---

### Array vs List

| Feature            | **Array**                                                                        | **List (Interface in JCF)**                                               |
| ------------------ | -------------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| **Definition**     | A fixed-size data structure to store elements of the same type.                  | A part of Java Collection Framework that can grow/shrink dynamically.     |
| **Size**           | Fixed at creation (cannot be changed).                                           | Dynamic (can grow or shrink at runtime).                                  |
| **Data type**      | Can store **primitives** (`int[]`, `char[]`, etc.) and objects.                  | Stores only **objects** (e.g. `List<Integer>` instead of `int`).          |
| **Performance**    | Fast (less overhead, direct memory access).                                      | Slightly slower (dynamic resizing, extra features).                       |
| **Flexibility**    | Rigid (must know size in advance, no built-in methods for insert/remove/search). | Very flexible (methods like `add()`, `remove()`, `contains()`, `sort()`). |
| **Part of JCF**    | ❌ Not part of Java Collection Framework.                                         | ✅ Part of Java Collection Framework.                                      |
| **Access**         | Uses `array[index]`.                                                             | Uses `list.get(index)` and `list.set(index, value)`.                      |
| **Default values** | Numeric types → `0`, boolean → `false`, objects → `null`.                        | No default values; empty until elements are added.                        |
| **Example**        | `int[] arr = {1,2,3};`                                                           | `List<Integer> list = new ArrayList<>();`                                 |

---

### ArrayList vs LinkedList

| Feature                         | **ArrayList**                                                                               | **LinkedList**                                                                                              |
| ------------------------------- | ------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| **Data Structure**              | Uses a **dynamic array** internally.                                                        | Uses a **doubly linked list** internally.                                                                   |
| **Access (get/set)**            | **O(1)** → Fast (direct index access).                                                      | **O(n)** → Slow (traverses from start/end).                                                                 |
| **Insertion/Deletion (middle)** | **O(n)** → Shifts elements.                                                                 | **O(1)** → Just change links.                                                                               |
| **Insertion/Deletion (end)**    | `add()` is **O(1)** (amortized).                                                            | `addLast()` is **O(1)**.                                                                                    |
| **Memory usage**                | Less memory (just elements).                                                                | More memory (extra storage for pointers prev/next).                                                         |
| **Iteration**                   | Better cache locality → generally faster iteration.                                         | Slower iteration (pointers break locality).                                                                 |
| **Use cases**                   | Best when you need **fast random access** and fewer insert/remove operations in the middle. | Best when you need **lots of insertions/deletions** in the middle, but don’t care much about random access. |

---

### HashMap vs LinkedHashMap

| Feature               | **HashMap**                                                 | **LinkedHashMap**                                                                  |
| --------------------- | ----------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| **Data Structure**    | Hash table (buckets).                                       | Hash table **+ doubly linked list** (to maintain order).                           |
| **Order of elements** | **Unordered**, no guarantee of order.                       | **Insertion order is preserved** (can also maintain access order if configured).   |
| **Performance**       | O(1) average for `put()`, `get()`, `remove()`.              | O(1) average, but slightly slower than `HashMap` (due to maintaining linked list). |
| **Memory usage**      | Lower (just stores entries in buckets).                     | Higher (extra pointers for linked list).                                           |
| **Null keys/values**  | 1 `null` key allowed, multiple `null` values allowed.       | Same: 1 `null` key allowed, multiple `null` values allowed.                        |
| **Use case**          | When you just need fast lookups without caring about order. | When you need **fast lookups + predictable order** (like caching, LRU, etc.).      |

---

### HashMap vs ConcurrentHashMap

| Feature                           | **HashMap**                                                                                                           | **ConcurrentHashMap**                                                                                                                 |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------- |
| **Thread-safety**                 | ❌ **Not thread-safe** → Multiple threads modifying can cause data inconsistency (like infinite loop or lost updates). | ✅ **Thread-safe** → Designed for concurrent access in multi-threaded environments.                                                    |
| **Null keys/values**              | Allows **1 null key** and multiple null values.                                                                       | ❌ **No null keys or null values** allowed.                                                                                            |
| **Performance (single-threaded)** | Faster than `ConcurrentHashMap` (no synchronization overhead).                                                        | Slightly slower (due to concurrency control).                                                                                         |
| **Performance (multi-threaded)**  | Unsafe → May cause `ConcurrentModificationException`.                                                                 | Efficient concurrent reads and writes. Uses **lock-striping** (segments/partitions, in Java 8 it uses finer-grained synchronization). |
| **Iteration**                     | **Fail-fast** → If modified during iteration, throws `ConcurrentModificationException`.                               | **Fail-safe** → Doesn’t throw exception. Iterators work on a snapshot (weakly consistent).                                            |
| **Use case**                      | Best for **single-threaded applications** or when external synchronization is handled.                                | Best for **multi-threaded applications** requiring safe concurrent access.                                                            |

---

### Set vs HashSet

| Feature         | **Set**                                                                                                                             | **HashSet**                                                                                     |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| **Definition**  | An **interface** in the Java Collection Framework (`java.util`). It represents a **collection of unique elements** (no duplicates). | A **class** in Java (`java.util`) that implements the **Set** interface using a **hash table**. |
| **Type**        | Interface (cannot be instantiated directly).                                                                                        | Concrete implementation of Set (can be instantiated).                                           |
| **Order**       | Depends on implementation (e.g., `HashSet`, `LinkedHashSet`, `TreeSet`).                                                            | **Unordered** (does not guarantee insertion order).                                             |
| **Null values** | Depends on implementation.                                                                                                          | Allows **one null** element.                                                                    |
| **Performance** | Not applicable (interface).                                                                                                         | O(1) average for `add`, `remove`, `contains` (because of hashing).                              |
| **Hierarchy**   | Parent interface.                                                                                                                   | Child class → `public class HashSet<E> implements Set<E>`.                                      |

---

### Set Types

| **Set Type**      | **Null Allowed?**                          | **Details**                                                                                                                                           |
| ----------------- | ------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| **HashSet**       | ✅ Yes (only **one null element** allowed). | Because it’s based on `HashMap`, which allows one `null` key.                                                                                         |
| **LinkedHashSet** | ✅ Yes (only **one null element** allowed). | Maintains insertion order, but still only one `null`.                                                                                                 |
| **TreeSet**       | ⚠️ Usually **No**                          | - If you try to add `null`, it will throw `NullPointerException` because `TreeSet` uses sorting (natural/comparator). Sorting `null` is not possible. |

---

### Stream Operations: Intermediate vs Terminal

| Feature         | Intermediate                                   | Terminal                                |
| --------------- | ---------------------------------------------- | --------------------------------------- |
| **Execution**   | Lazy (doesn’t run until terminal is called)    | Eager (executes pipeline)               |
| **Return Type** | Stream (can be chained)                        | Non-stream (collection, value, void)    |
| **Examples**    | `map`, `filter`, `sorted`, `limit`, `distinct` | `collect`, `forEach`, `reduce`, `count` |

---

### map() vs flatMap()

| Feature                 | `map()`                                 | `flatMap()`                                                    |
| ----------------------- | --------------------------------------- | -------------------------------------------------------------- |
| **Output per element**  | One value (can be object or collection) | A Stream (which gets flattened)                                |
| **Resulting Structure** | Stream of objects (may be nested)       | Flattened Stream (no nesting)                                  |
| **When to use**         | Simple one-to-one transformation        | When each element produces multiple values (list/array/stream) |

---

### stream() vs parallelStream()

| Feature         | `stream()` (Sequential)   | `parallelStream()` (Parallel)                                    |
| --------------- | ------------------------- | ---------------------------------------------------------------- |
| **Execution**   | Single thread (main)      | Multiple threads (ForkJoinPool)                                  |
| **Performance** | Good for small datasets   | Better for large datasets (CPU intensive)                        |
| **Order**       | Maintains encounter order | Order is **not guaranteed** (unless you use `.forEachOrdered()`) |
| **Threading**   | No extra threads          | Uses `ForkJoinPool.commonPool()`                                 |
| **Use case**    | Simple transformations    | Heavy computation, large data                                    |

---

### Comparable vs Comparator

| Feature          | Comparable            | Comparator                      |
| ---------------- | --------------------- | ------------------------------- |
| **Package**      | `java.lang`           | `java.util`                     |
| **Method**       | `compareTo(Object o)` | `compare(Object o1, Object o2)` |
| **Sorting**      | Natural order         | Custom order                    |
| **Location**     | Inside the class      | Outside the class (separate)    |
| **Number of logics** | Only one              | Multiple possible               |

---

### ArrayList vs Vector

| Feature           | ArrayList                                                                                                                 | Vector                                                              |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------- |
| **Thread Safety** | Not synchronized. Multiple threads accessing it concurrently can cause issues.                                            | Synchronized. Thread-safe for single operations.                    |
| **Performance**   | Faster because it’s not synchronized.                                                                                     | Slower due to synchronization overhead.                             |
| **Growth**        | Increases size by 50% when capacity is exceeded.                                                                          | Doubles the size when capacity is exceeded.                         |
| **Legacy**        | Introduced in **Java 1.2**. Modern and preferred.                                                                         | Introduced in **Java 1.0**. Considered legacy, rarely used now.     |
| **Iterator**      | Uses `fail-fast` iterator (`ArrayList`’s iterator throws `ConcurrentModificationException` if modified during iteration). | Also uses `fail-fast` iterator, but `Enumeration` can also be used. |
| **Usage**         | Recommended in single-threaded applications.                                                                              | Useful if you need synchronized access.                             |

---

### Promise vs Observable

| Feature     | Promise            | Observable                      |
| ----------- | ------------------ | ------------------------------- |
| **Values**      | Single async value | Multiple values (sync or async) |
| **Execution**   | Always async       | Can be sync or async            |
| **Laziness**    | Eager              | Lazy (starts on subscription)   |
| **Cancelation** | Cannot cancel      | Can unsubscribe                 |

---

## Spring Annotations Comparisons

### @Controller vs @RestController

| Feature         | `@Controller`                                                                                            | `@RestController`                                                                                                |
| --------------- | -------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- |
| **Purpose**     | Used in **Spring MVC** (returns **views/pages**)                                                         | Used in **REST APIs** (returns **JSON/XML**)                                                                     |
| **Behavior**    | Returns a **view name** (resolved by ViewResolver like JSP/Thymeleaf)                                    | Combines `@Controller` + `@ResponseBody` → directly returns data                                                 |
| **Example**     | `@Controller\nclass MyController {\n  @GetMapping("/home")\n  public String home() { return "index"; }\n}` | `@RestController\nclass MyRestController {\n  @GetMapping("/home")\n  public String home() { return "Hello"; }\n}` |

---

### @Component vs @Configuration

| Feature          | `@Component`                                                                         | `@Configuration`                                                                                          |
| ---------------- | ------------------------------------------------------------------------------------ | --------------------------------------------------------------------------------------------------------- |
| **Purpose**      | Marks a class as a Spring bean (generic stereotype)                                  | Marks a class as a **source of bean definitions**                                                         |
| **How it works** | The class itself is registered as a bean                                             | The class can **define multiple beans** using `@Bean` methods                                             |
| **Bean creation**| Registers **one bean (the class itself)**                                            | Can register **multiple beans**                                                                           |
| **Proxy behavior**| No proxying, just a simple bean                                                      | Uses **CGLIB proxies** so that `@Bean` methods return **singleton beans** (even if called multiple times) |
| **Example**      | `@Component\nclass MyService {}`                                                     | `@Configuration\nclass AppConfig {\n  @Bean\n  public DataSource dataSource() { return new DataSource(); }\n}` |
| **Typical use case**| When you want Spring to auto-detect and manage a class (service, DAO, utility, etc.) | When you want to define **manual bean configuration** (similar to old XML config)                       |

---

### @Configuration vs @EnableAutoConfiguration

| Feature            | `@Configuration`                                                                                      | `@EnableAutoConfiguration`                                                                 |
| ------------------ | ----------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------ |
| **Belongs to**     | **Core Spring**                                                                                       | **Spring Boot**                                                                            |
| **Purpose**        | Marks a class as a **Java config class** (can declare `@Bean` methods)                                | Tells Spring Boot to **auto-configure beans** based on classpath dependencies & properties |
| **Who creates beans?** | You define beans manually with `@Bean`                                                                | Spring Boot scans the classpath & loads default beans automatically                        |
| **Scope**          | Limited to beans you define in that config class                                                      | Global — tries to configure the whole app automatically                                    |
| **Example**        | `@Configuration\nclass AppConfig {\n  @Bean\n  public DataSource dataSource() { return new DataSource(); }\n}` | `@EnableAutoConfiguration\n@Configuration\nclass MyApp {}`                             |
| **Typical use case** | Manual bean creation (custom logic, external library beans)                                           | Bootstrapping a Spring Boot app without needing XML/Java configs                           |

---

## End of Comparisons

This guide aggregates comparison tables for Java, Spring, and JavaScript concepts for quick reference and study.
