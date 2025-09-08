# JavaScript Interview Guide

This guide contains **top JavaScript interview questions and answers** arranged in a structured format with an index.

---

## 📑 Index of Questions

1. What is Hoisting in JavaScript?
2. Difference between Rest and Spread operators
3. Difference between slice and splice
4. What is Destructuring?
5. What is a Closure?
6. Explain the Event Loop in JavaScript
7. What are Promises in JavaScript?
8. What is Async/Await?
9. Difference between Regular Functions and Arrow Functions
10. What are ES6 Classes?
11. Explain Prototype-based inheritance
12. What are Arrow Functions and benefits?
13. What are Template Literals?
14. What are Default Parameters?
15. Explain map, filter, reduce
16. What is Currying?
17. Explain Debouncing & Throttling
18. What are call, apply, and bind?
19. Difference between Deep Copy and Shallow Copy
20. Difference between for, for...in, and for...of
21. What are Modules in JavaScript?
22. What is Optional Chaining and Nullish Coalescing?
23. Memory Management & Garbage Collection
24. Difference between let, const, and var
25. const with primitive vs non-primitive
26. Shallow copy vs Deep copy
27. Difference between map and filter
28. What is a prototype?
29. Arrow functions and their advantages
30. When to use bind, call, and apply
31. Spread vs Rest operators
32. What is event delegation?
33. Types of events in JavaScript
34. Event capturing vs Event bubbling
35. JavaScript object methods
36. Object.seal() vs Object.freeze()
37. Can you change const objects vs primitives?
38. What is the Event Loop?
39. Microtasks vs Macrotasks
40. Example code for Debounce
41. What is `Promise.all` in JavaScript?

---

## ✅ JavaScript Interview Questions & Answers

### Q1. What is Hoisting in JavaScript?
**A:** Hoisting is a JavaScript mechanism where variable and function declarations are moved to the top of their containing scope (global or function scope) during the compilation phase, before the code is executed.

Important: Only declarations are hoisted, not initializations

---

### Q2. Difference between Rest and Spread operators?
**A:** Rest (`...`) collects multiple arguments into an array. Spread (`...`) expands elements of an array/object.

Rest Operator (...) Used in:

Function parameters
Destructuring
Example:
```
function sum(...numbers) {
  return numbers.reduce((total, num) => total + num, 0);
}

console.log(sum(1, 2, 3, 4)); // Output: 10

Here, ...numbers collects all arguments into an array.
```


Spread Used in:

Array/Object cloning
Merging
Passing arguments

```
const arr1 = [1, 2, 3];
const arr2 = [...arr1, 4, 5];

console.log(arr2); // Output: [1, 2, 3, 4, 5]

Here, ...arr1 spreads the elements of arr1 into arr2.
```

| Feature       | Rest (`...`)                          | Spread (`...`)                             |
|--------------|----------------------------------------|--------------------------------------------|
| **Purpose**   | Collects multiple values into one      | Expands values from an iterable or object   |
| **Used in**   | Function parameters, destructuring     | Arrays, objects, function calls             |
| **Example**   | `function fn(...args)`                | `[...array]` or `{...object}`              |


---

### Q3. Difference between slice and splice?
**A:** `slice` returns a shallow copy without modifying the array. `splice` modifies the array by adding/removing elements.

| Feature         | `slice()`                                      | `splice()`                                      |
|----------------|------------------------------------------------|-------------------------------------------------|
| **Purpose**     | Extracts a portion of an array                 | Adds/removes/replaces elements in an array      |
| **Return Value**| Returns a new array                            | Returns the removed elements                    |
| **Original Array** | Unchanged (non-mutating)                   | Changed (mutating)                              |
| **Use Case**    | When you want to copy or extract data         | When you want to update the array               |

```
slice() Example
const fruits = ['apple', 'banana', 'cherry', 'date'];
const sliced = fruits.slice(1, 3); // ['banana', 'cherry']
console.log(fruits); // ['apple', 'banana', 'cherry', 'date'] — original unchanged


splice() Example

const fruits = ['apple', 'banana', 'cherry', 'date'];
const removed = fruits.splice(1, 2, 'blueberry', 'kiwi');
// removes 'banana' and 'cherry', inserts 'blueberry' and 'kiwi'
console.log(fruits); // ['apple', 'blueberry', 'kiwi', 'date']
console.log(removed); // ['banana', 'cherry']


```

---

### Q4. What is Destructuring?
**A:** Destructuring is a syntax in JavaScript that allows you to unpack values from arrays or properties from objects into distinct variables in a concise way.

**Example with Arrays:**
```javascript
const numbers = [1, 2, 3];
const [a, b, c] = numbers;
console.log(a); // 1
console.log(b); // 2
console.log(c); // 3
```

---

### Q5. What is a Closure?
**A:** A closure is a feature in JavaScript where an inner function has access to the outer (enclosing) function’s variables, even after the outer function has finished executing. Closures allow functions to "remember" their lexical scope.

**Example:**
```javascript
function outer() {
  let count = 0;
  function inner() {
    count++;
    return count;
  }
  return inner;
}

const counter = outer();
console.log(counter()); // 1
console.log(counter()); // 2
```

---

### Q6. Explain the Event Loop in JavaScript.
**A:** The event loop is a mechanism in JavaScript that enables non-blocking asynchronous operations by managing the call stack, microtask queue, and macrotask queue. It checks the call stack for tasks to execute, and when the stack is empty, it processes tasks from the microtask queue (like resolved Promises) before moving to the macrotask queue (like `setTimeout`, `setInterval`).

**Example:**
```javascript
console.log('Start');

setTimeout(() => {
  console.log('Macrotask: setTimeout');
}, 0);

Promise.resolve().then(() => {
  console.log('Microtask: Promise');
});

console.log('End');

/*

Start
End
Microtask: Promise
Macrotask: setTimeout

*/
```

How it works:

'Start' is logged (call stack).
setTimeout callback is scheduled in the macrotask queue.
Promise .then callback is scheduled in the microtask queue.
'End' is logged (call stack).
Microtasks are processed next: 'Microtask: Promise' is logged.
Macrotasks are processed: 'Macrotask: setTimeout' is logged.

flowchart LR
    A[Call Stack] --empty--> B{Microtask Queue}
    B --empty--> C{Macrotask Queue}
    C --task--> A
    subgraph Queues
      B
      C
    end
    D[JS Engine]
    D --> A
    D --> B
    D --> C

1.The call stack runs all synchronous code.
2.When the stack is empty, the event loop checks the microtask queue (Promises, MutationObservers) and runs all microtasks.
3.Then, it processes one task from the macrotask queue (setTimeout, setInterval, I/O).
4.This cycle repeats, allowing JavaScript to handle async operations efficiently.

---

### Q7. What are Promises?
**A:** A Promise in JavaScript is an object that represents the eventual completion (success) or failure of an asynchronous operation and its resulting value. Promises provide a cleaner alternative to callbacks for handling asynchronous code, making it easier to chain operations and handle errors.

**Types (States) of Promises:**
1. **Pending:** Initial state, neither fulfilled nor rejected.
2. **Fulfilled:** The operation completed successfully.
3. **Rejected:** The operation failed.

**Example:**
```javascript
const promise = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve("Success!");
    // or reject("Error!");
  }, 1000);
});

promise
  .then(result => console.log(result)) // "Success!" after 1 second
  .catch(error => console.log(error));
```

---

### Q8. What is Async/Await?
**A:** `async` and `await` are keywords in JavaScript that simplify working with Promises and asynchronous code. An `async` function always returns a Promise. The `await` keyword pauses the execution of the async function until the Promise is resolved or rejected, making asynchronous code look and behave more like synchronous code.

**Example:**
```javascript
function fetchData() {
  return new Promise(resolve => {
    setTimeout(() => resolve("Data received!"), 1000);
  });
}

async function getData() {
  const result = await fetchData();
  console.log(result); // "Data received!" after 1 second
}

getData();
```

---

### Q9. Difference between Regular Functions and Arrow Functions?
**A:**  
- **Regular functions** have their own `this` context, can be used as constructors, and have access to the `arguments` object.  
- **Arrow functions** do not have their own `this` (they inherit from the enclosing scope), cannot be used as constructors, and do not have their own `arguments` object.

| Feature                | Regular Function                | Arrow Function                        |
|------------------------|---------------------------------|---------------------------------------|
| `this` binding         | Own `this` (dynamic)            | Lexical `this` (inherits from parent) |
| Constructor            | Can be used as constructor      | Cannot be used as constructor         |
| `arguments` object     | Available                       | Not available                         |
| Prototype              | Has prototype                   | No prototype                          |
| Syntax                 | Longer                          | Shorter (concise)                     |
| Methods in objects     | Recommended                     | Not recommended                       |
| Implicit return        | No                              | Yes (if no braces)                    |

**Example:**
```javascript
function regular() {
  console.log(this); // Own 'this'
  console.log(arguments); // Has 'arguments'
}

const arrow = () => {
  console.log(this); // Lexical 'this'
  // console.log(arguments); // Error: arguments is not defined
};
```

---

### Q10. What are ES6 Classes?
**A:** ES6 classes are a new syntax introduced in ECMAScript 2015 (ES6) that provide a clearer and more concise way to create objects and handle inheritance in JavaScript. They are syntactic sugar over JavaScript's existing prototype-based inheritance, making it easier to define constructor functions and methods.

**Key Features:**
- Use the `class` keyword to define a class.
- Support for constructors, instance methods, and static methods.
- Inheritance using the `extends` keyword.
- Easier to read and maintain compared to prototype-based syntax.

**Example:**
```javascript
class Animal {
  constructor(name) {
    this.name = name;
  }
  speak() {
    console.log(`${this.name} makes a sound.`);
  }
}

class Dog extends Animal {
  speak() {
    console.log(`${this.name} barks.`);
  }
}

const dog = new Dog("Rex");
dog.speak();
```

---

### Q11. Explain Prototype-based inheritance.
**A:** Objects inherit properties and methods from their prototype object.

---

### Q12. What are Arrow Functions and benefits?
**A:** Arrow functions are a concise way to write functions in JavaScript, introduced in ES6. They have a shorter syntax, use lexical `this` binding (inherit `this` from the surrounding scope), and cannot be used as constructors.

**Advantages:**
- Shorter, cleaner syntax.
- Lexical `this` (no need for `.bind(this)`).
- No `arguments` object (useful for callbacks).
- Cannot be used as constructors (avoids misuse).

**Example:**
```javascript
const add = (a, b) => a + b;

const obj = {
  value: 10,
  getValue: () => this.value, // 'this' is not bound to obj
  getValueRegular: function() { return this.value; }
};

console.log(add(2, 3)); // 5
console.log(obj.getValue()); // undefined
console.log(obj.getValueRegular()); //
```

---

### Q13. What are Template Literals?
**A:** Strings using backticks (`` ` ``) with embedded expressions.

---

### Q14. What are Default Parameters?
**A:** Default parameters allow you to specify default values for function parameters. If an argument is not provided or is `undefined` when the function is called, the parameter takes the default value.

**Example:**
```javascript
function greet(name = "Guest") {
  console.log("Hello, " + name + "!");
}

greet("Alice"); // Hello, Alice!
greet();        // Hello,
```

---

### Q15. Explain map, filter, and reduce.
**A:** 
- `map`: transforms each element.  
- `filter`: selects elements.  
- `reduce`: accumulates values.

---

### Q16. What is Currying?
**A:** Currying is a functional programming technique where a function with multiple arguments is transformed into a sequence of functions, each taking a single argument. This allows partial application of functions and can make code more flexible and reusable.

**Example:**
```javascript
// Normal function
function add(a, b) {
  return a + b;
}

// Curried version
function curriedAdd(a) {
  return function(b) {
    return a + b;
  };
}

console.log(add(2, 3));         // 5
console.log(curriedAdd(2)(3));
```

---

### Q17. Explain Debouncing and Throttling.
**A:**  
- **Debouncing** is a technique that delays the execution of a function until a certain amount of time has passed since it was last called. It's useful for events that fire rapidly (like keypress or resize) to ensure the function runs only after the user stops triggering the event.
- **Throttling** ensures a function is only executed once in a specified time interval, no matter how many times the event is triggered. It's useful for limiting the rate of execution (like scroll or window resize events).



---

### Q18. What are call, apply, and bind?
**A:**  
- `call`: Invokes a function with a specified `this` value and arguments provided individually.
- `apply`: Invokes a function with a specified `this` value and arguments provided as an array.
- `bind`: Returns a new function with a specified `this` value and, optionally, preset arguments.

**Example:**
```javascript
function greet(greeting, punctuation) {
  console.log(greeting + ', ' + this.name + punctuation);
}

const person = { name: "Alice" };

greet.call(person, "Hello", "!");      // Hello, Alice!
greet.apply(person, ["Hi", "."]);      // Hi, Alice.
const boundGreet = greet.bind(person, "Hey");
boundGreet("?");                       // Hey, Alice?
```

---

### Q19. Deep Copy vs Shallow Copy?
**A:**  
- **Shallow copy** copies only the first level of an object or array. Nested objects or arrays are still referenced, not duplicated.
- **Deep copy** creates a completely independent copy of the object, including all nested objects and arrays.

| Feature         | Shallow Copy                        | Deep Copy                              |
|-----------------|-------------------------------------|----------------------------------------|
| Nested objects  | Referenced (shared)                 | Fully duplicated (independent)         |
| Performance     | Faster                              | Slower (more processing)               |
| Methods         | `Object.assign()`, spread (`...`)   | `structuredClone()`, recursion, JSON   |

**Shallow Copy Example:**
```javascript
const original = { a: 1, b: { c: 2 } };
const shallow = { ...original };
shallow.b.c = 42;
console.log(original.b.c); // 42 (affected)

**Deep Copy Example:**
const original = { a: 1, b: { c: 2 } };
const deep = JSON.parse(JSON.stringify(original));
deep.b.c = 99;
console.log(original.b.c); // 2 (not affected)

### Q20. Difference between for, for...in, and for...of?
**A:** 
- `for`: index-based iteration.  
- `for...in`: iterates object keys.  
- `for...of`: iterates iterable values.

---

### Q21. What are Modules in JavaScript?
**A:** ES Modules split code into files using `import` and `export`.

---

### Q22. Optional Chaining & Nullish Coalescing?
**A:** 
- `?.` safely accesses properties.  
- `??` provides default for `null` or `undefined`.

---

### Q23. Memory Management & Garbage Collection?
**A:** JavaScript manages memory automatically using a garbage collector, most commonly the Mark-and-Sweep algorithm. When objects become unreachable (no references from code), the garbage collector identifies and removes them, freeing up memory. Developers should avoid creating unnecessary references to help the garbage collector work efficiently.

**Key Points:**
- Memory is allocated when variables, objects, or functions are created.
- The garbage collector periodically checks for objects that are no longer reachable.
- Unreachable objects are cleared from memory automatically.

**Example:**
```javascript
let obj = { name: "Alice" };
obj = null; // The object is now unreachable and will be garbage collected
```

---

### Q24. Difference between let, const, and var?
**A:** 
- `var`: function-scoped, hoisted.  
- `let`: block-scoped, not redeclared.  
- `const`: block-scoped, not reassigned.

---

### Q25. const with primitive vs non-primitive?
**A:**  
- **Primitive:** The value assigned to a `const` primitive (like number, string, boolean) cannot be changed.  
- **Non-primitive (Objects/Arrays):** The reference to the object/array is fixed (cannot be reassigned), but the properties or elements inside can still be changed.

**Example:**
```javascript
const num = 5;
// num = 10; // Error: Assignment to constant variable

const obj = { a: 1 };
obj.a = 2; // Allowed: property can change
// obj = {}; // Error: Assignment to constant variable

const arr = [1, 2, 3];
arr.push(4); // Allowed: elements can change
// arr = [5, 6]; // Error: Assignment to
```

---

### Q26. Shallow copy vs Deep copy?
**A:** Shallow copies share references to nested objects. Deep copies duplicate all.

---

### Q27. Difference between map and filter?
**A:** 
- `map`: transforms each element.  
- `filter`: returns elements passing a test.

---

### Q28. What is a prototype?
**A:** In JavaScript, every object has a prototype, which is another object it inherits properties and methods from. This forms a prototype chain, enabling inheritance and code reuse. When you access a property or method on an object, JavaScript looks for it on the object itself, and if not found, it searches up the prototype chain.

**Example:**
```javascript
const animal = {
  speak() {
    console.log("Animal speaks");
  }
};

const dog = Object.create(animal);
dog.speak(); // Animal speaks
console.log(Object.getPrototypeOf(dog) === animal); // true
```

---

### Q29. Arrow functions and their advantages?
**A:** Arrow functions are a concise way to write functions in JavaScript, introduced in ES6. They have a shorter syntax, use lexical `this` binding (inherit `this` from the surrounding scope), and cannot be used as constructors.

**Advantages:**
- Shorter, cleaner syntax.
- Lexical `this` (no need for `.bind(this)`).
- No `arguments` object (useful for callbacks).
- Cannot be used as constructors (avoids misuse).

**Example:**
```javascript
const add = (a, b) => a + b;

const obj = {
  value: 10,
  getValue: () => this.value, // 'this' is not bound to obj
  getValueRegular: function() { return this.value; }
};

console.log(add(2, 3)); // 5
console.log(obj.getValue()); // undefined
console.log(obj.getValueRegular()); //
```

---

### Q30. When to use bind, call, and apply?
**A:** Use `bind`, `call`, and `apply` to explicitly set the value of `this` inside a function, especially when borrowing methods or working with event handlers and callbacks.

| Method   | When to Use                                      | How it Works                                 |
|----------|--------------------------------------------------|----------------------------------------------|
| `call`   | Invoke a function immediately with custom `this` and arguments listed individually | `fn.call(thisArg, arg1, arg2, ...)`         |
| `apply`  | Invoke a function immediately with custom `this` and arguments as an array         | `fn.apply(thisArg, [arg1, arg2, ...])`      |
| `bind`   | Create a new function with custom `this` and optional preset arguments             | `const boundFn = fn.bind(thisArg, arg1, ...)`|

**Example:**
```javascript
function greet(greeting) {
  console.log(greeting + ', ' + this.name);
}
const person = { name: "Alice" };

greet.call(person, "Hello");           // Hello, Alice
greet.apply(person, ["Hi"]);           // Hi, Alice
const boundGreet = greet.bind(person);
boundGreet("Hey");                     // Hey, Alice
```

---

### Q31. Spread vs Rest?
**A:**  
- **Spread** (`...`) expands elements of an array or object into individual elements.
- **Rest** (`...`) collects multiple elements into a single array or object.

| Feature       | Rest (`...`)                          | Spread (`...`)                             |
|--------------|----------------------------------------|--------------------------------------------|
| **Purpose**   | Collects multiple values into one      | Expands values from an iterable or object   |
| **Used in**   | Function parameters, destructuring     | Arrays, objects, function calls             |
| **Example**   | `function fn(...args)`                | `[...array]` or `{...object}`              |

**Rest Example:**
```javascript
function sum(...numbers) {
  return numbers.reduce((total, num) => total + num, 0);
}
console.log(sum(1, 2, 3)); // 6

**Spread Example: **
const arr1 = [1, 2, 3];
const arr2 = [...arr1, 4, 5];
console.log(arr2); // [1, 2, 3, 4, 5]
```

---

### Q32. What is event delegation?
**A:** Single parent handles events for multiple children.

---

### Q33. Types of events?
**A:** UI, mouse, keyboard, focus, form events.

---

### Q34. Event capturing vs bubbling?
**A:** 
- Capturing: parent → child.  
- Bubbling: child → parent.

---

### Q35. JavaScript object methods?
**A:** `Object.keys()`, `Object.values()`, `Object.entries()`, `Object.assign()`, `Object.freeze()`, `Object.seal()`.

---

### Q36. Object.seal vs Object.freeze?
**A:** 
- `seal`: prevents add/remove, allows modify.  
- `freeze`: prevents add/remove/modify.

---

### Q37. Can const object values change?
**A:** Object properties mutable; primitive const values fixed.

---

### Q38. What is the Event Loop?
**A:** Mechanism for async handling, checking call stack and queues.

---

### Q39. Microtasks vs Macrotasks?
**A:** 
- Microtasks: Promises, MutationObservers.  
- Macrotasks: setTimeout, setInterval, I/O.

---

### Q40. Example of Debounce?
```javascript
function debounce(fn, delay) {
  let timer;
  return function(...args) {
    clearTimeout(timer);
    timer = setTimeout(() => fn.apply(this, args), delay);
  };
}
```

---

### Q41. What is `Promise.all` in JavaScript?
**A:** `Promise.all` is a method that takes an array of Promises and returns a new Promise. This returned Promise resolves when **all** the input Promises resolve, and rejects if **any** of them reject. The resolved value is an array of the resolved values from each input Promise, in the same order.

**Example:**
```javascript
const p1 = Promise.resolve(1);
const p2 = Promise.resolve(2);
const p3 = Promise.resolve(3);

Promise.all([p1, p2, p3])
  .then(results => console.log(results)) // [1, 2, 3]
  .catch(error => console.log(error));

  //If any promise rejects, Promise.all immediately rejects with that reason.
```
