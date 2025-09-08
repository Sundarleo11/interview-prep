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
**A:** Destructuring allows extracting values from arrays or objects into separate variables.

---

### Q5. What is a Closure?
**A:** A closure is created when a function remembers its outer scope even after it has executed.

---

### Q6. Explain the Event Loop in JavaScript.
**A:** The event loop allows JavaScript to perform non-blocking async operations by managing the call stack and task queues.

---

### Q7. What are Promises?
**A:** Promises represent the eventual completion or failure of an asynchronous operation.

---

### Q8. What is Async/Await?
**A:** `async` declares an asynchronous function returning a Promise. `await` pauses until the Promise resolves.

---

### Q9. Difference between Regular Functions and Arrow Functions?
**A:** Regular functions have their own `this`, can be constructors, and have `arguments`. Arrow functions have lexical `this`, no `arguments`, and can’t be constructors.

---

### Q10. What are ES6 Classes?
**A:** ES6 classes are syntactic sugar over prototypes to create objects and enable inheritance.

---

### Q11. Explain Prototype-based inheritance.
**A:** Objects inherit properties and methods from their prototype object.

---

### Q12. Arrow Functions and benefits?
**A:** Provide concise syntax and lexical `this` binding.

---

### Q13. What are Template Literals?
**A:** Strings using backticks (`` ` ``) with embedded expressions.

---

### Q14. What are Default Parameters?
**A:** Function parameters with default values if not provided.

---

### Q15. Explain map, filter, and reduce.
**A:** 
- `map`: transforms each element.  
- `filter`: selects elements.  
- `reduce`: accumulates values.

---

### Q16. What is Currying?
**A:** Converting a function with multiple args into a series of functions with one arg each.

---

### Q17. Explain Debouncing and Throttling.
**A:** Debounce delays execution until after pause. Throttle limits execution to once per interval.

---

### Q18. What are call, apply, and bind?
**A:** 
- `call`: invoke with `this` and arguments.  
- `apply`: invoke with `this` and array args.  
- `bind`: returns new function with bound `this`.

---

### Q19. Deep Copy vs Shallow Copy?
**A:** Shallow copy copies first level only. Deep copy duplicates nested objects.

---

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
**A:** Automatic via garbage collector (Mark-and-Sweep). Unreachable objects are cleared.

---

### Q24. Difference between let, const, and var?
**A:** 
- `var`: function-scoped, hoisted.  
- `let`: block-scoped, not redeclared.  
- `const`: block-scoped, not reassigned.

---

### Q25. const with primitive vs non-primitive?
**A:** 
- Primitive: value cannot change.  
- Objects: reference fixed but properties mutable.

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
**A:** Every object has a prototype for inheritance.

---

### Q29. Arrow functions and advantages?
**A:** Shorter syntax, lexical `this`, not for constructors.

---

### Q30. When to use bind, call, and apply?
**A:** Use them to set `this` explicitly.

---

### Q31. Spread vs Rest?
**A:** Spread expands, Rest collects.

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
