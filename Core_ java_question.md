# Java Interview Questions – Index

> **Tip:** Click any question below to jump straight to its answer.

1. [Difference between JVM, JRE, and JDK](#1-difference-between-jvm-jre-and-jdk)
2. [Key components of JVM architecture](#2-key-components-of-jvm-architecture)
3. [Can a Java application run without JRE?](#3-can-a-java-application-run-without-jre)
4. [Can we install JDK without JRE?](#4-can-we-install-jdk-without-jre)
5. [JVM Memory Storage](#5-jvm-memory-storage)
6. [Garbage Collection in Java](#6-garbage-collection-in-java)
7. [Role of finalize() method](#7-role-of-finalize-method)
8. [Garbage Collection Algorithms](#8-garbage-collection-algorithms)
9. [Memory Leak in Java](#9-memory-leak-in-java)
10. [Is Java 100% Object-Oriented?](#10-is-java-100-object-oriented)
11. [Advantages of Partial OOP in Java](#11-advantages-of-partial-oop-in-java)
12. [Use of OOP in Enterprise Projects](#12-use-of-oop-in-enterprise-projects)
13. [Explain public static void main(String[] args)](#13-explain-public-static-void-mainstring-args)
14. [What if main() is not static?](#14-what-if-main-is-not-static)
15. [Can we override or overload main()?](#15-can-we-override-or-overload-main)
16. [Primitive vs Non-Primitive Types](#16-primitive-vs-non-primitive-types)
17. [Why no pointers in Java?](#17-why-no-pointers-in-java)
18. [Wrapper Classes](#18-wrapper-classes)
19. [Autoboxing & Unboxing](#19-autoboxing--unboxing)
20. [Unexpected behavior with Integer and ==, and NullPointerException with unboxing](#20-unexpected-behavior-with-integer-and--and-nullpointerexception-with-unboxing)
21. [Exception Handling: try–catch–finally](#21-exception-handling-trycatchfinally)
22. [Checked vs Unchecked Exceptions](#22-checked-vs-unchecked-exceptions)
23. [String Pool](#23-string-pool)
24. [String vs StringBuffer vs StringBuilder](#24-string-vs-stringbuffer-vs-stringbuilder)
25. [Packages](#25-packages)
26. [Access modifiers](#26-access-modifiers)
27. [Getters and Setters](#27-getters-and-setters)
28. [Can a top-level class be private/protected?](#28-can-a-top-level-class-be-privateprotected)
29. [Class and Object](#29-class-and-object)
30. [Singleton Class](#30-singleton-class)
31. [Prevent multiple instances in Singleton](#31-prevent-multiple-instances-in-singleton)
32. [What is a constructor in Java?](#32-what-is-a-constructor-in-java)
33. [Can we use a private constructor?](#33-can-we-use-a-private-constructor)
34. [Can a constructor be overloaded?](#34-can-a-constructor-be-overloaded)
35. [What is immutability in Java?](#35-what-is-immutability-in-java)
36. [Why are immutable objects useful?](#36-why-are-immutable-objects-useful)
37. [What are immutable classes?](#37-what-are-immutable-classes)
38. [How can we create an immutable class?](#38-how-can-we-create-an-immutable-class)
39. [What does inheritance mean in Java?](#39-what-does-inheritance-mean-in-java)
40. [Can a class extend itself?](#40-can-a-class-extend-itself)
41. [Why is multiple inheritance not possible?](#41-why-is-multiple-inheritance-not-possible)
42. [Difference between inheritance and composition](#42-difference-between-inheritance-and-composition)
43. [What is polymorphism in Java?](#43-what-is-polymorphism-in-java)
44. [How is method overloading related to polymorphism?](#44-how-is-method-overloading-related-to-polymorphism)
45. [What is dynamic method dispatch?](#45-what-is-dynamic-method-dispatch)
46. [Can constructors be polymorphic?](#46-can-constructors-be-polymorphic)
47. [What is abstraction in Java?](#47-what-is-abstraction-in-java)
48. [Example of abstraction](#48-example-of-abstraction)
49. [What happens if a class includes an abstract method?](#49-what-happens-if-a-class-includes-an-abstract-method)
50. [How does abstraction help?](#50-how-does-abstraction-help)
51. [What is an interface in Java?](#51-what-is-an-interface-in-java)
52. [Difference between interface and abstract class](#52-difference-between-interface-and-abstract-class)
53. [When to use interface vs class extension?](#53-when-to-use-interface-vs-class-extension)
54. [How to achieve multiple inheritance in Java?](#54-how-to-achieve-multiple-inheritance-in-java)
55. [Can an interface contain static methods?](#55-can-an-interface-contain-static-methods)
56. [What is encapsulation?](#56-what-is-encapsulation)
57. [How does encapsulation provide security?](#57-how-does-encapsulation-provide-security)
58. [What is method overloading?](#58-what-is-method-overloading)
59. [How does Java choose the correct overloaded method?](#59-how-does-java-choose-the-correct-overloaded-method)
60. [Can we overload methods by changing only return type?](#60-can-we-overload-methods-by-changing-only-return-type)
61. [Rules for method overloading](#61-rules-for-method-overloading)
62. [What is method overriding?](#62-what-is-method-overriding)
63. [@Override annotation](#63-override-annotation)
64. [What if multiple subclasses override the same method?](#64-what-if-multiple-subclasses-override-the-same-method)
65. [What are this and super keywords?](#65-what-are-this-and-super-keywords)
66. [Can this be reassigned?](#66-can-this-be-reassigned)
67. [What if we use super in a class without a superclass?](#67-what-if-we-use-super-in-a-class-without-a-superclass)
68. [Can this or super be used in static methods?](#68-can-this-or-super-be-used-in-static-methods)
69. [What is static keyword?](#69-what-is-static-keyword)
70. [Can static blocks throw exceptions?](#70-can-static-blocks-throw-exceptions)
71. [Can static methods be overridden?](#71-can-static-methods-be-overridden)
72. [Can static methods access non-static members?](#72-can-static-methods-access-non-static-members)
73. [What is static block used for?](#73-what-is-static-block-used-for)
74. [Can we print without main method?](#74-can-we-print-without-main-method)
75. [What is final keyword?](#75-what-is-final-keyword)
76. [Common use cases of final](#76-common-use-cases-of-final)
77. [How does final help immutability?](#77-how-does-final-help-immutability)
78. [Performance consideration of final](#78-performance-consideration-of-final)
79. [What is a functional interface?](#79-what-is-a-functional-interface)
80. [Can a functional interface extend another interface?](#80-can-a-functional-interface-extend-another-interface)
81. [New features in Java 8](#81-new-features-in-java-8)
82. [Difference between filter() and map()](#82-difference-between-filter-and-map)
83. [New features in Java 11](#83-new-features-in-java-11)
84. [New features in Java 17](#84-new-features-in-java-17)
85. [New features in Java 21](#85-new-features-in-java-21)
86. [What is Collections Framework?](#86-what-is-collections-framework)
87. [Main interfaces in Collections Framework](#87-main-interfaces-in-collections-framework)
88. [How iterator works?](#88-how-iterator-works)
89. [Common methods in collections](#89-common-methods-in-collections)
90. [Handling concurrency in collections](#90-handling-concurrency-in-collections)
91. [Choosing right collection](#91-choosing-right-collection)
92. [Enhancements in Java 8 (Collections)](#92-enhancements-in-java-8-collections)
93. [Iterator vs ListIterator](#93-iterator-vs-listiterator)
94. [How does HashMap handle collisions?](#94-how-does-hashmap-handle-collisions)
95. [What happens when two keys have the same hash code?](#95-what-happens-when-two-keys-have-the-same-hash-code)
96. [What changes were made to HashMap in Java 8?](#96-what-changes-were-made-to-hashmap-in-java-8)
97. [Can we use a class as a key in HashMap?](#97-can-we-use-a-class-as-a-key-in-hashmap)
98. [Explain ConcurrentHashMap.](#98-explain-concurrenthashmap)
99. [How does it improve performance? (ConcurrentHashMap)](#99-how-does-it-improve-performance-concurrenthashmap)
100. [Time complexity of HashSet / HashMap operations](#100-time-complexity-of-hashset--hashmap-operations)
101. [Time complexity of TreeSet / TreeMap](#101-time-complexity-of-treeset--treemap)
102. [Internal implementation of HashMap/TreeMap/HashSet/TreeSet](#102-internal-implementation-of-hashmaptreemaphashsettreeset)
103. [What are design patterns and why do we use them?](#103-what-are-design-patterns-and-why-do-we-use-them)
104. [Common design patterns](#104-common-design-patterns)
105. [How design patterns impact performance](#105-how-design-patterns-impact-performance)
106. [Which pattern is used for managing DB connections?](#106-which-pattern-is-used-for-managing-db-connections)
107. [How to choose the appropriate design pattern?](#107-how-to-choose-the-appropriate-design-pattern)
108. [SOLID Principles](#108-solid-principles)
109. [What is a thread in Java & how to create it?](#109-what-is-a-thread-in-java--how-to-create-it)
110. [Thread lifecycle](#110-thread-lifecycle)
111. [Two threads updating same data?](#111-two-threads-updating-same-data)
112. [Can we start a thread twice?](#112-can-we-start-a-thread-twice)
113. [Thread vs Runnable](#113-thread-vs-runnable)
114. [How to ensure a method is thread-safe?](#114-how-to-ensure-a-method-is-thread-safe)
115. [What are volatile variables?](#115-what-are-volatile-variables)
116. [What is thread synchronization & why important?](#116-what-is-thread-synchronization--why-important)
117. [Where to use wait() and notify()?](#117-where-to-use-wait-and-notify)
118. [Java Memory Model](#118-java-memory-model)
119. [Can we create a server without Spring or any framework?](#119-can-we-create-a-server-without-spring-or-any-framework)
120. [Transient keyword](#120-transient-keyword)
121. [Exchanger class](#121-exchanger-class)
122. [What is Reflection?](#122-what-is-reflection)
123. [WeakReference vs SoftReference](#123-weakreference-vs-softreference)
124. [Java Flight Recorder](#124-java-flight-recorder)
125. [Serialization vs Deserialization](#125-serialization-vs-deserialization)
126. [Young Generation vs Old Generation memory](#126-young-generation-vs-old-generation-memory)

---

# Java Interview Questions and Answers

## 1. Difference between JVM, JRE, and JDK
JVM (Java Virtual Machine) is the engine that runs Java bytecode and makes Java platform-independent.  
JRE (Java Runtime Environment) contains the JVM and the standard libraries required to run a Java program.  
JDK (Java Development Kit) is for developers and includes everything in JRE plus additional tools like compilers and debuggers to create Java applications.

## 2. Key components of JVM architecture
JVM has three major components:
- Class Loader – loads class files into the JVM
- Runtime Data Areas – store data required while the program runs
- Execution Engine – executes the instructions inside the class files

## 3. Can a Java application run without JRE?
No, you cannot run a Java application without JRE because it contains essential tools and libraries the application needs.  
However, modern Java versions have a tool called jlink, which allows bundling your application with its own minimal runtime.

## 4. Can we install JDK without JRE?
No. JDK always contains JRE. It is not possible to have JDK without JRE.

## 5. JVM Memory Storage
JVM memory is divided into:
- Heap Space – stores objects and shared data
- Stack Memory – stores method calls and local variables
- Method Area / Metaspace – stores class-level information
- Native Method Stacks

## 6. Garbage Collection in Java
Garbage Collection automatically frees memory by removing objects that are no longer used.

## 7. Role of finalize() method
It gives the object a chance to clean up resources (like closing files or network connections) before it is collected.

## 8. Garbage Collection Algorithms
JVM uses multiple algorithms such as:
- Mark & Sweep
- Mark & Compact
- Generational GC

## 9. Memory Leak in Java
A memory leak occurs when objects are no longer needed but are still referenced, preventing garbage collector from reclaiming memory.

## 10. Is Java 100% Object-Oriented?
No. Because Java uses primitive types (int, char, boolean, etc.) that are not objects.

## 11. Advantages of Partial OOP in Java
Primitive types make Java faster and lighter. The mixed model helps Java integrate well with other technologies.

## 12. Use of OOP in Enterprise Projects
OOP helps organize code, makes maintenance easy, supports scalability, and enables reusability.

## 13. Explain public static void main(String[] args)
public – accessible from anywhere  
static – no object required to call it  
void – no return value  
main – entry point of Java application  
String[] args – receives command-line arguments

## 14. What if main() is not static?
The JVM will not be able to launch the application. It will compile but fail at runtime with an error:  
“main method is not static.”

## 15. Can we override or overload main()?
Override? ❌ No. Static methods cannot be overridden.  
Overload? ✅ Yes.  
Will JVM call overloaded main? ❌ No. It always calls the original signature.

## 16. Primitive vs Non-Primitive Types
Primitive Types: int, double, char, boolean – fixed size and not objects.  
Non-Primitive Types: arrays, classes, interfaces, String.  
Primitive types cannot be null.

## 17. Why no pointers in Java?
To make Java safer and more secure.

## 18. Wrapper Classes
They wrap primitive types into objects—required for collections because collections cannot store primitives.

## 19. Autoboxing & Unboxing
Autoboxing: converting primitive → wrapper  
Unboxing: converting wrapper → primitive

## 20. Unexpected behavior with Integer and ==, and NullPointerException with unboxing
Comparing two Integer objects using == may be wrong because it compares references, not values.  
Unboxing a null Integer results in NPE.

## 21. Exception Handling: try–catch–finally
try → code that may throw exception  
catch → handles exception  
finally → runs always (even if return occurs)  
finally does not execute only when JVM exits using System.exit().  
Only one finally block is allowed.

## 22. Checked vs Unchecked Exceptions
Checked: must be declared/handled (e.g., IOException)  
Unchecked: Runtime exceptions (e.g., NullPointerException)  
Multiple exceptions can be handled in one catch using | operator.

## 23. String Pool
A special memory area where String literals are stored.  
If a string already exists, JVM reuses the object.  
It’s not beneficial when there are many unique strings (memory overhead).

## 24. String vs StringBuffer vs StringBuilder
String – immutable  
StringBuffer – mutable & thread-safe  
StringBuilder – mutable & faster (NOT thread-safe)  
StringBuffer is better when multiple threads modify the same string.

## 25. Packages
Used to group related classes, prevent naming conflicts, and organize code.

## 26. Access modifiers
public, protected, default, private.

## 27. Getters and Setters
Used instead of public fields to maintain encapsulation and allow validation.

## 28. Can a top-level class be private/protected?
No. It can only be public or default.

## 29. Class and Object
Class – blueprint  
Object – instance of class  
Objects can be created using new, factory methods, or cloning.  
A class may exist without fields or methods.

## 30. Singleton Class
A class that can have only one instance.  
Used for shared resources like configuration or database connection.

## 31. Prevent multiple instances in Singleton
Synchronize the method that creates the instance, or use a static initializer.

## 32. What is a constructor in Java?
A constructor in Java is a special method used to initialize objects. Its name is the same as the class name, and it may take arguments to set initial values for object attributes.

## 33. Can we use a private constructor?
Yes, we can use a private constructor in Java. It is mostly used in classes that provide static methods or contain only static fields.  
A common use is the Singleton Design Pattern, where the goal is to limit the class to only one object.

## 34. Can a constructor be overloaded?
Yes, we can have multiple constructors in a Java class, each with a different set of parameters.  
This lets us create objects in various ways depending on what information we have.

## 35. What is immutability in Java?
Immutability in Java means that once an object’s state is created, it cannot be changed.

## 36. Why are immutable objects useful?
Immutable objects are useful in concurrent programming because they can be shared across threads without needing synchronization.

## 37. What are immutable classes?
Immutable classes are classes whose objects cannot be modified after creation.

## 38. How can we create an immutable class?
- Declare the class as final so it cannot be extended.
- Make all fields private and final.
- Do not provide setter methods.
- Initialize all fields in the constructor.

## 39. What does inheritance mean in Java?
Inheritance in Java means a class can use features of another class. It helps reuse code and make things simpler.

## 40. Can a class extend itself?
No. A class in Java cannot extend itself. If it tries, it causes an error.

## 41. Why is multiple inheritance not possible?
Java avoids multiple inheritance because it can create complications, such as method conflicts when two parent classes have methods with the same signature.

## 42. Difference between inheritance and composition
Inheritance: One class gets features from another class.  
Composition: A class is made using objects/parts of other classes. It is more flexible.

## 43. What is polymorphism in Java?
Polymorphism means the same piece of code can perform different actions based on the object it deals with.  
Example: A method draw() may draw a circle for a Circle object and a square for a Square object.

## 44. How is method overloading related to polymorphism?
Method overloading uses the same method name with different inputs in the same class. It is a type of compile-time polymorphism.

## 45. What is dynamic method dispatch?
Dynamic method dispatch allows Java to decide which overridden method to call at runtime based on the actual object type.

## 46. Can constructors be polymorphic?
No. Constructors cannot be polymorphic. They can be overloaded but not overridden.

## 47. What is abstraction in Java?
Abstraction means focusing on what needs to be done, not how it is done.  
It provides a blueprint for other parts of the program.

## 48. Example of abstraction
Java Collections framework uses abstraction.  
When we use List, we do not need to know whether it is implemented using ArrayList or LinkedList.

## 49. What happens if a class includes an abstract method?
That class must be declared abstract, and objects cannot be created directly from it.

## 50. How does abstraction help?
It helps change parts of a program without affecting others, keeping the system flexible and manageable.

## 51. What is an interface in Java?
An interface is a blueprint for a class. It defines a set of methods that the class must implement.

## 52. Difference between interface and abstract class
Abstract class: 0–100% abstraction  
Interface: 100% abstraction (before Java 8; now can have default & static methods)  
Abstract class can have both abstract & non-abstract methods  
Interface mainly had abstract methods

## 53. When to use interface vs class extension?
Use interface: when you want to list required methods.  
Use class extension: when a new class needs behavior from an existing class.

## 54. How to achieve multiple inheritance in Java?
Using interfaces. A class can implement multiple interfaces.

## 55. Can an interface contain static methods?
Yes. They can be called without creating an instance.

## 56. What is encapsulation?
Encapsulation means storing data and methods inside a class and controlling who can access or modify the data using access modifiers.

## 57. How does encapsulation provide security?
It hides important data and prevents unwanted or accidental changes.

## 58. What is method overloading?
Overloading is using the same method name with different parameters.

## 59. How does Java choose the correct overloaded method?
Java compiler checks the number and types of arguments and picks the method that matches best.

## 60. Can we overload methods by changing only return type?
No. Parameter list must be different.

## 61. Rules for method overloading
- Different number of parameters
- Different types of parameters
- Different order of parameters

## 62. What is method overriding?
A subclass provides a new version of a method with the same name, return type, and parameters.

## 63. @Override annotation
Helps compiler verify that a method truly overrides a superclass method.

## 64. What if multiple subclasses override the same method?
Each subclass has its own implementation.

## 65. What are this and super keywords?
this refers to current class object  
super refers to parent class members

## 66. Can this be reassigned?
No. It is read-only.

## 67. What if we use super in a class without a superclass?
It gives a compilation error.

## 68. Can this or super be used in static methods?
No. Static methods do not belong to any object instance.

## 69. What is static keyword?
Static members belong to the class, not objects.

## 70. Can static blocks throw exceptions?
Yes, but they must be handled inside the block.

## 71. Can static methods be overridden?
No. They are bound at compile time.

## 72. Can static methods access non-static members?
Yes, but only by creating an object.

## 73. What is static block used for?
To initialize static variables. It runs once when the class loads.

## 74. Can we print without main method?
Before Java 8 – Yes  
After Java 8 – No

## 75. What is final keyword?
Used to declare constants, prevent method overriding, and prevent inheritance.

## 76. Common use cases of final
Constant values  
Method parameters  
Local variables in inner classes

## 77. How does final help immutability?
It prevents unintended modifications, improving thread safety.

## 78. Performance consideration of final
final can improve performance by reducing overhead.

## 79. What is a functional interface?
An interface with exactly one abstract method.  
Supports functional programming.

## 80. Can a functional interface extend another interface?
Only if the parent interface has no abstract methods.

## 81. New features in Java 8
- Lambda expressions
- Stream API
- Method references
- Default methods
- Optional class
- New Date/Time API

## 82. Difference between filter() and map()
filter() – removes elements based on condition  
map() – transforms each element

## 83. New features in Java 11
- HTTP Client
- Epsilon GC
- ZGC
- var for lambda parameters
- String enhancements (strip, stripLeading, stripTrailing, repeat)

## 84. New features in Java 17
- Sealed classes
- Pattern matching for switch
- Foreign function & memory API

## 85. New features in Java 21
- Virtual threads
- Structured concurrency
- Scoped values
- Unmodifiable sequence collections
- Record patterns

## 86. What is Collections Framework?
A set of tools to organize, store, and manage data.

## 87. Main interfaces in Collections Framework
List, Set, Queue, Map.

## 88. How iterator works?
Helps traverse elements one by one.

## 89. Common methods in collections
add, remove, clear, size, isEmpty.

## 90. Handling concurrency in collections
Using ConcurrentHashMap, CopyOnWriteArrayList.

## 91. Choosing right collection
List → ordered, duplicates allowed  
Set → unique  
Queue → FIFO  
Map → key-value pairs

## 92. Enhancements in Java 8 (Collections)
Streams + lambda expressions.

## 93. Iterator vs ListIterator
Iterator → forward only  
ListIterator → forward + backward

## 94. How does HashMap handle collisions?
The HashMap manages this collision by maintaining either a LinkedList or a balanced tree inside that bucket, depending on the Java version.

## 95. What happens when two keys have the same hash code?
If two keys have the same hash code, they end up in the same bucket. In HashMap, those keys are linked together inside a list (or tree), helping the map manage them properly.

## 96. What changes were made to HashMap in Java 8?
Before Java 8, HashMap used only a simple LinkedList to store collided items.  
From Java 8 onward, if too many items land in the same bucket, that LinkedList is converted into a balanced tree (Red-Black tree). This improves search speed.

## 97. Can we use a class as a key in HashMap?
Yes, but when we use a class as a key, the class must properly override hashCode() and equals() to ensure correct behavior.

## 98. Explain ConcurrentHashMap.
ConcurrentHashMap is a thread-safe version of HashMap.  
It allows multiple threads to access the map at the same time without locking the entire map.  
It internally divides the map into parts so threads can lock only the portion they need.

## 99. How does it improve performance? (ConcurrentHashMap)
Multiple threads can read/write different parts of the map simultaneously, reducing waiting time and improving efficiency.

## 100. Time complexity of HashSet / HashMap operations
Insert: Average O(1), Worst O(n) (if rehashing happens)  
Delete: Average O(1), Worst O(n)  
Retrieve: Average O(1), Worst O(n) due to hash collisions

## 101. Time complexity of TreeSet / TreeMap
For insert, delete, and retrieve operations → O(log n)  
Because they are internally sorted using balanced trees.

## 102. Internal implementation of HashMap/TreeMap/HashSet/TreeSet
HashMap uses an array of nodes; each node is a LinkedList or Tree depending on collisions.  
TreeMap uses a Red-Black Tree.  
HashSet internally uses HashMap.  
TreeSet internally uses TreeMap.

## 103. What are design patterns and why do we use them?
Design patterns are proven solutions to common software design problems.  
They help create code that is organized, maintainable, scalable, and easy to understand.

## 104. Common design patterns
Singleton → Only one instance of a class globally  
Observer → Objects get notified when another object's state changes  
Factory Method → Subclasses decide which object to create; promotes flexibility

## 105. How design patterns impact performance
Patterns may add some complexity but improve long-term architecture, maintainability, and scalability.

## 106. Which pattern is used for managing DB connections?
Singleton pattern — ensures that a single shared connection is used efficiently.

## 107. How to choose the appropriate design pattern?
Understand the problem, analyze system design needs, and select the pattern that fits the application and performance requirements.

## 108. SOLID Principles
S — Single Responsibility Principle: A class should have only one reason to change.  
O — Open/Closed Principle: Classes should be open for extension but closed for modification.  
L — Liskov Substitution Principle: Subclasses should replace parent classes without breaking functionality.  
I — Interface Segregation Principle: Don’t force a class to implement methods it doesn’t need; break large interfaces into smaller ones.  
D — Dependency Inversion Principle: High-level modules should depend on abstractions, not concrete implementations.

## 109. What is a thread in Java & how to create it?
A thread is a path of execution in a program.  
Create by:
- Extending Thread class
- Implementing Runnable interface

## 110. Thread lifecycle
New → Runnable → Blocked/Waiting → Timed Waiting → Terminated

## 111. Two threads updating same data?
Use synchronized blocks/methods to ensure only one thread accesses the shared structure at a time.

## 112. Can we start a thread twice?
No. Restarting a thread throws IllegalStateException.

## 113. Thread vs Runnable
Thread class defines the thread itself  
Runnable allows defining code to run inside a thread

## 114. How to ensure a method is thread-safe?
Use synchronization, volatile variables, or concurrent data structures.

## 115. What are volatile variables?
Volatile ensures the latest value is always read and shared across threads immediately.

## 116. What is thread synchronization & why important?
It prevents multiple threads from accessing shared resources simultaneously → avoids data inconsistency.

## 117. Where to use wait() and notify()?
For thread communication — one thread waits, another notifies when task is completed.

## 118. Java Memory Model
Defines rules to ensure consistent read/write of shared data between threads.

## 119. Can we create a server without Spring or any framework?
Yes.
Use:
- ServerSocket for TCP server
- HttpServer class for HTTP server

## 120. Transient keyword
Marks fields that should NOT be serialized.

## 121. Exchanger class
A synchronization point where two threads exchange data with each other.

## 122. What is Reflection?
Ability to inspect and modify class behavior at runtime (methods, fields, constructors).

## 123. WeakReference vs SoftReference
WeakReference: Collected immediately when no strong refs exist  
SoftReference: Collected only when JVM memory is low

## 124. Java Flight Recorder
A profiling tool to record diagnostic data with low performance overhead.

## 125. Serialization vs Deserialization
Serialization: Convert object → byte stream  
Deserialization: Convert byte stream → object

## 126. Young Generation vs Old Generation memory
Young Generation: Holds newly created objects  
Old Generation: Holds objects that survived multiple GC cycles
