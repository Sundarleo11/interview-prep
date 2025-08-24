# JavaScript Interview Guide

Here’s the full list of questions **with serial numbers** (clean and easy to copy):

---

### ✅ JavaScript Interview Questions

1. What is **Hoisting** in JavaScript?
2. What is the difference between **Rest** and **Spread** operators? Provide examples.
3. What is the difference between **slice** and **splice**?
4. What is **Destructuring** in JavaScript?
5. What is a **Closure**? How does it work?
6. Explain the **Event Loop** in JavaScript.
7. What are **Promises** in JavaScript?
8. What is **Async/Await** and how does it work?
9. What is the difference between **Regular Functions** and **Arrow Functions**?
10. What are **ES6 Classes** in JavaScript?
11. Explain **Prototype-based inheritance** in JavaScript.
12. What are **Arrow Functions** and their benefits?
13. What are **Template Literals**?
14. What are **Default Parameters** in JavaScript?
15. Explain **map**, **filter**, and **reduce** with examples.
16. What is **Currying** in JavaScript?
17. Explain **Debouncing** and **Throttling**. When to use each?
18. What are **call**, **apply**, and **bind** methods? Explain with examples.
19. What is the difference between **Deep Copy** and **Shallow Copy**?
20. What is the difference between **for**, **for...in**, and **for...of** loops? When to use each?
21. What are **Modules** in JavaScript? How do you use `import` and `export`?
22. What is **Optional Chaining** and **Nullish Coalescing**?
23. Explain **Memory Management & Garbage Collection** in JavaScript.

    * How does **Mark-and-Sweep** algorithm work?
    * What is **reachability** in JavaScript?
    * What causes **memory leaks**?
    * How can you avoid **memory leaks**?


## ✅ Core Concepts

### 1. Hoisting
**Definition:** Hoisting is JavaScript's behavior of moving declarations (not initializations) to the top of their scope before execution.
```javascript
console.log(a); // undefined
var a = 10;

let and const //ReferenceError: Cannot access variable before initialization
```

### 2. Rest & Spread Operator
**Definition:** 

The ... (three dots) operator in JavaScript serves two purposes:

* Rest Parameter: Collects multiple arguments into a single array.

* Spread Operator: Expands elements of an array or object into individual elements.

```javascript
let arr = [1,2,3,4];
console.log(arr.slice(1,3)); // [2,3]


//Splice: Modifies the array (add/remove).

arr.splice(1,2); // removes 2,3
```

### 3. Slice vs Splice
**Definition:** Slice returns a shallow copy without modifying the original array. Splice changes the original array by adding/removing elements.
```javascript
const arr=[1,2,3,4];
console.log(arr.slice(1,3)); // [2,3]
arr.splice(1,2); // removes 2,3
```

### 4. Destructuring
**Definition:** Destructuring allows extracting values from arrays or objects into separate variables.
```javascript
const {name,age}={name:"John",age:25};
```

### 5. Closures
**Definition:** Closure = Function + Lexical Scope.

A closure is created when a function "remembers" its outer scope even after it has executed.
```javascript
function outer(){let count=0;return()=>++count;}
const counter=outer();
console.log(counter()); //1
```
![Closure Diagram](https://odetocode.com/blogs/scott/archive/2007/07/10/closure-on-javascript-closures.aspx)

### 6. Event Loop
**Definition:** 
The Event Loop is the mechanism that allows JavaScript to perform non-blocking asynchronous operations despite being single-threaded.
It continuously checks the Call Stack and Callback Queue (and Microtask Queue) to execute tasks.

```javascript
console.log("Start");

setTimeout(() => {
  console.log("Timeout");
}, 0);

Promise.resolve().then(() => {
  console.log("Promise");
});

console.log("End");

Start
End
Promise
Timeout

```
console.log("Start") → executed immediately.

setTimeout callback goes to Callback Queue.

Promise.then callback goes to Microtask Queue.

Microtask Queue has higher priority than Callback Queue → so Promise runs before Timeout.

✅ Event Loop Order

Call Stack → Execute synchronous code.

Microtask Queue → Promises, MutationObservers.

Callback Queue → setTimeout, setInterval, I/O.



### 7. Promises
**Definition:** Promises represent the eventual completion or failure of an asynchronous operation.
```javascript

const myPromise = new Promise((resolve, reject) => {
  const success = true;
  if (success) {
    resolve("Operation Successful!");
  } else {
    reject("Operation Failed!");
  }
});

```

### 8. Async/Await
**Definition:** Async/Await

* async: Declares an asynchronous function that always returns a Promise.

* await: Pauses the execution of the function until the Promise is resolved or rejected.
```javascript

// Simulate an API call
function fetchUserData() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({ name: "John", age: 25 });
    }, 2000);
  });
}

// Using async/await
async function displayUser() {
  console.log("Fetching user data...");
  
  const user = await fetchUserData(); // Waits here for 2 seconds
  console.log(`Name: ${user.name}, Age: ${user.age}`);
  
  console.log("Done!");
}

displayUser();

output:
Fetching user data...
(wait 2 seconds)
Name: John, Age: 25
Done!

```

### 9. (Regular vs Arrow)
**Definition:** `

* Regular Functions: Declared using function keyword.

* Arrow Functions: Introduced in ES6, provide a shorter syntax and different behavior for this.


| Feature              | **Regular Function**                                  | **Arrow Function**                                          |
| -------------------- | ----------------------------------------------------- | ----------------------------------------------------------- |
| **`this` binding**   | `this` refers to the object that called the function. | `this` is **lexically bound** (inherits from parent scope). |
| **Arguments object** | Has its own `arguments` object.                       | Does **not** have `arguments`.                              |
| **Constructor**      | Can be used as constructor with `new`.                | Cannot be used as constructor (throws error).               |
| **Prototype**        | Has a `prototype` property.                           | No `prototype` property.                                    |
| **Short Syntax**     | No                                                    | Yes                                                         |

```javascript

// Regular Function
function add(a, b) {
  return a + b;
}

// Arrow Function
const addArrow = (a, b) => a + b;


```

### 10. ES6 Classes
**Definition:** Classes in ES6 are syntactic sugar over prototypes for creating objects.
```javascript
class Person{constructor(n){this.name=n;}greet(){console.log(`Hi ${this.name}`);}}
new Person('John').greet();
```

### 11. Prototype
**Definition:** JavaScript uses prototype-based inheritance, where objects can inherit properties from other objects.
```javascript
function Animal(type){this.type=type;}
Animal.prototype.speak=function(){console.log(`${this.type} sound`);};
new Animal('Dog').speak();
```

### 12. Arrow Functions
**Definition:** Arrow functions provide a concise syntax and lexical `this` binding.
```javascript
const add=(a,b)=>a+b;
```

### 13. Template Literals
**Definition:** Template literals allow embedding expressions in strings using backticks.
```javascript
console.log(`I love JS`);
```

### 14. Default Parameters
**Definition:** Allows function parameters to have default values.
```javascript
function greet(n='Guest'){console.log(`Hi ${n}`);}greet();
```

### 15. Map, Filter, Reduce
**Definition:** Functional methods to transform and reduce arrays.
```javascript
const nums=[1,2,3];
console.log(nums.map(n=>n*2));
console.log(nums.filter(n=>n%2));
console.log(nums.reduce((a,b)=>a+b,0));
```

---

## ✅ Advanced Concepts

### 16. Currying
**Definition:** Breaking down a function with multiple arguments into a series of functions that each take one argument.
```javascript
const curry=a=>b=>c=>a+b+c;
console.log(curry(1)(2)(3));
```

### 17. Debouncing & Throttling
**Definition:** Debounce delays function execution until after a pause, Throttle limits execution to once per interval.
```javascript
function debounce(fn,d){let t;return(...a)=>{clearTimeout(t);t=setTimeout(()=>fn(...a),d);}};
function throttle(fn,l){let f;return(...a)=>{if(!f){fn(...a);f=true;setTimeout(()=>f=false,l);}};}
```

### 18. Call, Apply, Bind
**Definition:** Methods to explicitly set `this` when calling a function.
```javascript
function greet(g){console.log(`${g}, ${this.name}`);}const obj={name:'John'};
greet.call(obj,'Hi');greet.apply(obj,['Hello']);const b=greet.bind(obj);b('Hey');
```

### 19. Deep vs Shallow Copy
**Definition:** Shallow copy copies only the first level; deep copy duplicates all nested objects.
```javascript
const obj={a:1,b:{c:2}};
const shallow={...obj};shallow.b.c=10;console.log(obj.b.c); //10
const deep=JSON.parse(JSON.stringify(obj));deep.b.c=20;console.log(obj.b.c); //10
```

### 20. for vs for...in vs for...of
**Definition:** 

| Loop Type    | Iterates Over            | Best For                    |
| ------------ | ------------------------ | --------------------------- |
| **for**      | Numeric index            | Arrays when index needed    |
| **for...in** | Object keys (enumerable) | Objects (not arrays)        |
| **for...of** | Values of iterable       | Arrays, strings, Maps, Sets |


```javascript

//Used when you know the number of iterations.
const arr = [10, 20, 30];

for (let i = 0; i < arr.length; i++) {
  console.log(arr[i]); // 10, 20, 30
}

//for...in Loop
const colors = ["red", "green", "blue"];

for (let color of colors) {
  console.log(color); // red, green, blue
}

for...of Loop

const colors = ["red", "green", "blue"];

for (let color of colors) {
  console.log(color); // red, green, blue
}

```

### 21. Modules (import/export)
**Definition:** ES Modules allow splitting code into separate files.
```javascript
export const greet=name=>`Hi ${name}`;
import {greet} from './export.js';
```

### 22. Optional Chaining & Nullish Coalescing
**Definition:** Safe property access and handling null/undefined with defaults.
```javascript
const user={profile:{name:'John'}};
console.log(user?.profile?.name); // John
console.log(user?.address ?? 'No address');
```

### 23. Memory Management & Garbage Collection
**Definition:** 

JavaScript manages memory automatically using Garbage Collection based on reachability.

Memory Lifecycle

Allocate memory – When variables, objects, or functions are created.

Use memory – Perform operations using those variables.

Release memory – When data becomes unreachable, the Garbage Collector frees it.

✅ Garbage Collection

Algorithm: Most modern JS engines (like V8) use Mark-and-Sweep.

Process:

Start from root objects (e.g., window, global).

Mark all reachable objects.

Sweep and free memory for unmarked objects (unreachable).

✅ What is Reachable?

Objects accessible via global scope, closure, or references.

If no reference exists → object becomes garbage.

✅ Common Memory Leaks

Global variables not cleared.

Forgotten event listeners.

Unused closures.

Detached DOM nodes.

      ┌───────────────┐
      │   Root Objects │
      └───────┬───────┘
              │
        ┌─────▼─────┐
        │ Reachable  │  (Marked - Keep)
        └─────┬─────┘
              │
        ┌─────▼─────┐
        │ Unreachable│ (Unmarked - Remove)
        └────────────┘

```javascript
//Memory Management Example

// Step 1: Allocate Memory
let user = { name: "Alice" };  // Object created in Heap

// Step 2: Use Memory
console.log(user.name); // "Alice"

// Step 3: Release Memory (make it unreachable)
user = null; // Original object is now unreachable

// Garbage Collector will remove it in the next cycle


//Example of Memory Leak
// Memory Leak Example
let data = [];
function addMemory() {
  data.push(new Array(1000000).fill("*")); // Adds large data
}

setInterval(addMemory, 1000); // Keeps adding memory every second

//Closures Holding Memory

function outer() {
  let bigData = new Array(1000000).fill("*");
  return function inner() {
    console.log("Still holding bigData!");
  };
}

const fn = outer(); // bigData stays in memory because of closure
```





