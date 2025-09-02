# Java 8 Essential Features Guide

## Introduction
Java 8 introduced functional programming concepts and major interface enhancements, making Java more expressive and powerful.

## 1. Interface Improvements


Key Interface Updates in Java 8

| Feature                              | Description                                                                 |
|--------------------------------------|-----------------------------------------------------------------------------|
| Default Methods                      | Interfaces can now include method implementations using the `default` keyword. This allows adding new methods to interfaces without breaking existing implementations. |
| Static Methods                       | Interfaces can define `static` methods that belong to the interface itself, not the implementing class. These are useful for utility or helper methods. |
| Functional Interfaces               | Interfaces with a single abstract method, used as the foundation for lambda expressions. Marked with `@FunctionalInterface`. |
| Method References                   | Enables referencing existing methods using `ClassName::methodName`, often used with functional interfaces. |
| Optional Return Types               | Interfaces can now use the `Optional<T>` class to safely handle potentially `null` return values. |
| Annotations on Interfaces           | Java 8 allows annotations to be applied directly to interface declarations. |
| Multiple Inheritance with Default Methods | If a class implements multiple interfaces with conflicting default methods, it must override the method to resolve ambiguity. |

### Default Methods
Default methods allow interfaces to have concrete implementations without breaking existing code.

```java
interface Vehicle {
    // Default method example
    default void start() {
        System.out.println("Vehicle is starting...");
    }
}

class Car implements Vehicle {
    // Automatically gets start() method
}
```

### Static Methods in Interfaces
```java
interface Calculator {
    // Static utility method
    static int add(int a, int b) {
        return a + b;
    }
}
// Usage: Calculator.add(5, 3)
```

## 2. Functional Programming

### Functional Interfaces
```java
@FunctionalInterface
interface Processor {
    void process(String data);
    
    // Can have default methods too
    default void init() {
        System.out.println("Initializing processor");
    }
}
```

### Lambda Expressions

A lambda expression is a short block of code that accepts parameters and returns a value. It's similar to a method, but you don't need to write a lot of boilerplate code and it can be passed around as an object.

#### Basic Syntax
```java
(parameters) -> { statements }
```

#### Lambda Expression Types:
1. **No parameters:**
```java
() -> System.out.println("Hello World")
```

2. **Single parameter:**
```java
name -> System.out.println("Hello " + name)
```

3. **Multiple parameters:**
```java
(x, y) -> x + y
```

4. **With type declarations:**
```java
(String x, String y) -> x.length() + y.length()
```

5. **Multiple statements:**
```java
(x, y) -> {
    int sum = x + y;
    return sum * 2;
}
```

#### Before and After Lambda Examples:

1. **Traditional Anonymous Class:**
```java
// Old way
Runnable oldWay = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};
```

2. **Lambda Expression:**
```java
// New way with lambda
Runnable newWay = () -> System.out.println("Hello");
```

#### Common Use Cases:

1. **With Collections:**
```java
List<String> names = Arrays.asList("John", "Jane", "Adam");
// Sort using lambda
names.sort((a, b) -> a.compareTo(b));
```

2. **With Functional Interfaces:**
```java
// Predicate
Predicate<String> isLong = s -> s.length() > 5;
System.out.println(isLong.test("Hello World")); // true

// Consumer
Consumer<String> printer = s -> System.out.println(s);
printer.accept("Hello Lambda!");

// Function
Function<String, Integer> lengthFinder = str -> str.length();
System.out.println(lengthFinder.apply("Hello")); // 5
```

3. **With Streams:**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
      .filter(n -> n % 2 == 0)      // Lambda as filter
      .map(n -> n * n)              // Lambda as mapper
      .forEach(n -> System.out.println(n)); // Lambda as consumer
```

#### Key Points About Lambdas:
- They must implement a functional interface (interface with single abstract method)
- Can access final or effectively final variables from enclosing scope
- Can't change values of local variables (must be final or effectively final)
- Can access instance variables and static variables
- No need to specify return type - it's inferred
```

## 3. Stream API and Collections

### Stream vs Collection
- **Collection**: A data structure that stores elements
- **Stream**: A pipeline for processing data using functional operations
- Streams are read-only and don't modify the source
- Enables declarative, lazy processing

### Stream Operations

#### Intermediate Operations (Lazy)
```java
// These operations don't execute until a terminal operation is called
List<String> names = Arrays.asList("John", "Jane", "Adam", "Mary");
Stream<String> stream = names.stream()
    .filter(name -> name.length() > 3)    // intermediate
    .map(String::toUpperCase)             // intermediate
    .distinct()                           // intermediate
```

#### Terminal Operations (Eager)
```java
// These operations trigger the stream execution
stream.forEach(System.out::println);      // terminal
// or
List<String> result = stream.collect(Collectors.toList()); // terminal
```

### Common Stream Operations

#### map() vs flatMap()
```java
// map(): one-to-one transformation
List<Integer> lengths = words.stream()
    .map(String::length)
    .collect(Collectors.toList());

// flatMap(): one-to-many transformation
List<String> allWords = sentences.stream()
    .flatMap(str -> Arrays.stream(str.split(" ")))
    .collect(Collectors.toList());
```

#### Grouping and Partitioning
```java
// groupingBy: groups elements by a key
Map<Integer, List<String>> byLength = words.stream()
    .collect(Collectors.groupingBy(String::length));

// partitioningBy: splits into true/false groups
Map<Boolean, List<String>> partitioned = words.stream()
    .collect(Collectors.partitioningBy(w -> w.length() > 5));
```

#### Removing Duplicates
```java
// Using distinct()
List<String> unique = words.stream()
    .distinct()
    .collect(Collectors.toList());

// Using toSet()
Set<String> uniqueSet = words.stream()
    .collect(Collectors.toSet());
```

### Custom Collector Example
```java
public class CustomCollector {
    public static <T> Collector<T, List<T>, List<T>> toSortedList(Comparator<? super T> comparator) {
        return Collector.of(
            ArrayList::new,           // supplier
            List::add,               // accumulator
            (left, right) -> {       // combiner
                left.addAll(right);
                return left;
            },
            (list) -> {              // finisher
                list.sort(comparator);
                return list;
            }
        );
    }
}

// Usage
List<String> sorted = words.stream()
    .collect(CustomCollector.toSortedList(String::compareTo));
```

## 4. Optional Type
Safer alternative to null handling:
```java
Optional<String> name = Optional.ofNullable(getName());
name.ifPresent(System.out::println);
String result = name.orElse("Unknown");
```

## 5. Method References
Four types of method references:
1. Static methods: `Math::max`
2. Instance methods: `String::length`
3. Instance methods of objects: `myObject::method`
4. Constructors: `ArrayList::new`

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println);
```

## 6. Complete Example
```java
@FunctionalInterface
interface TextProcessor {
    String process(String text);
    
    default void printInfo() {
        System.out.println("Text Processor v1.0");
    }
    
    static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }
}

public class ModernJavaDemo {
    public static void main(String[] args) {
        // Lambda implementation
        TextProcessor uppercase = str -> str.toUpperCase();
        
        // Using streams
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        words.stream()
            .filter(w -> !TextProcessor.isEmpty(w))
            .map(uppercase::process)
            .forEach(System.out::println);
            
        // Optional usage
        Optional<String> result = Optional.ofNullable(words.get(0));
        System.out.println(result.orElse("No language found"));
    }
}
```

## Common Built-in Functional Interfaces

1. `Predicate<T>`: Tests a condition
2. `Consumer<T>`: Accepts an input, returns nothing
3. `Function<T,R>`: Transforms input to output
4. `Supplier<T>`: Supplies a value
5. `UnaryOperator<T>`: Single argument operation

## Best Practices

1. Keep lambda expressions short and readable
2. Use method references when possible
3. Use meaningful names for lambda parameters
4. Consider using Optional for null-safety
5. Use streams for collection processing
6. Leverage default methods for backward compatibility

## Tips for Multiple Interface Inheritance

When a class implements multiple interfaces with conflicting default methods:

```java
interface A {
    default void show() { System.out.println("A"); }
}

interface B {
    default void show() { System.out.println("B"); }
}

class MyClass implements A, B {
    @Override
    public void show() {
        A.super.show();  // Choose which one to call
        // or B.super.show();
        // or your own implementation
    }
}
```


