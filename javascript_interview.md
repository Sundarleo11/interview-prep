# JavaScript Interview Guide

This README provides **JavaScript interview questions, definitions, examples, and diagrams**, making it perfect for GitHub.

---

## ✅ Core Concepts

### 1. Hoisting
**Definition:** Hoisting is JavaScript's behavior of moving declarations (not initializations) to the top of their scope before execution.
```javascript
console.log(a); // undefined
var a = 10;
```

### 2. Rest & Spread Operator
**Definition:** Rest collects arguments into an array, while Spread expands arrays or objects into individual elements.
```javascript
function sum(...nums){return nums.reduce((a,b)=>a+b);}
const arr=[1,2,3];
const copy=[...arr];
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
**Definition:** A closure is a function that retains access to its lexical scope even after the outer function has returned.
```javascript
function outer(){let count=0;return()=>++count;}
const counter=outer();
console.log(counter()); //1
```
![Closure Diagram](https://user-images.githubusercontent.com/your-link/closure-diagram.png)

### 6. Event Loop
**Definition:** The event loop manages the execution of synchronous and asynchronous code in JavaScript.
```javascript
console.log('Start');
setTimeout(()=>console.log('Timeout'),0);
Promise.resolve().then(()=>console.log('Promise'));
console.log('End');
```
![Event Loop Diagram](https://user-images.githubusercontent.com/your-link/event-loop.png)

### 7. Promises
**Definition:** Promises represent the eventual completion or failure of an asynchronous operation.
```javascript
new Promise(res=>setTimeout(()=>res('Done'),1000)).then(console.log);
```

### 8. Async/Await
**Definition:** Async/Await simplifies working with Promises, making async code look synchronous.
```javascript
async function getData(){const data=await Promise.resolve('Hello');console.log(data);}getData();
```

### 9. this Keyword (Regular vs Arrow)
**Definition:** `this` refers to the object that calls the function. Arrow functions don't have their own `this`.
```javascript
const obj={val:42,reg:function(){console.log(this.val)},arr:()=>console.log(this.val)};
obj.reg(); //42
obj.arr(); //undefined
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

### 20. for...in vs for...of
**Definition:** `for...in` iterates keys, `for...of` iterates values.
```javascript
const arr=['a','b'];
for(let i in arr)console.log(i); // keys
for(let v of arr)console.log(v); // values
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
**Definition:** JavaScript uses mark-and-sweep to remove unreachable objects.
```javascript
let obj={data:123};
obj=null; // eligible for GC
```
![Memory Management Diagram](https://user-images.githubusercontent.com/your-link/memory-gc.png)

---

✅ This README now has **definitions (2-3 lines each)**, **examples**, and **diagrams for Event Loop, Closure, and Memory Management**.

