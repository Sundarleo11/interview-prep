# 📘 React Hooks – Complete Guide (React 18+)

This document explains **all 14 built-in React hooks** with:

- ✅ Definition  
- ✅ Use Case  
- ✅ Sample Code  

---

## 🔹 1. `useState`

**Definition:** Adds state to functional components.  
**Use Case:** Counters, toggles, form inputs.  

```jsx
import { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);
  return (
    <button onClick={() => setCount(count + 1)}>
      Count: {count}
    </button>
  );
}
```

---

## 🔹 2. `useEffect`

**Definition:** Runs side effects after render.  
**Use Case:** API calls, subscriptions, cleanup.  

```jsx
import { useState, useEffect } from "react";

function Timer() {
  const [time, setTime] = useState(0);

  useEffect(() => {
    const id = setInterval(() => setTime(t => t + 1), 1000);
    return () => clearInterval(id); // cleanup
  }, []);

  return <h1>Time: {time}</h1>;
}
```

---

## 🔹 3. `useLayoutEffect`

**Definition:** Like `useEffect`, but runs **before browser paints**.  
**Use Case:** Measure DOM size/scroll before update.  

```jsx
import { useLayoutEffect, useRef } from "react";

function Box() {
  const boxRef = useRef();

  useLayoutEffect(() => {
    console.log("Box height:", boxRef.current.offsetHeight);
  });

  return <div ref={boxRef} style={{ height: 100, background: "lightblue" }} />;
}
```

---

## 🔹 4. `useContext`

**Definition:** Accesses data from a React Context without prop drilling.  
**Use Case:** Theme, Auth, Language.  

```jsx
import { createContext, useContext } from "react";

const ThemeContext = createContext("light");

function Button() {
  const theme = useContext(ThemeContext);
  return <button style={{ background: theme === "dark" ? "black" : "white" }}>{theme}</button>;
}

function App() {
  return (
    <ThemeContext.Provider value="dark">
      <Button />
    </ThemeContext.Provider>
  );
}
```

---

## 🔹 5. `useReducer`

**Definition:** Alternative to `useState` for complex state logic.  
**Use Case:** State with multiple transitions (Redux-like).  

```jsx
import { useReducer } from "react";

function reducer(state, action) {
  switch (action.type) {
    case "inc": return { count: state.count + 1 };
    case "dec": return { count: state.count - 1 };
    default: return state;
  }
}

function Counter() {
  const [state, dispatch] = useReducer(reducer, { count: 0 });
  return (
    <>
      <h1>{state.count}</h1>
      <button onClick={() => dispatch({ type: "inc" })}>+</button>
      <button onClick={() => dispatch({ type: "dec" })}>-</button>
    </>
  );
}
```

---

## 🔹 6. `useCallback`

**Definition:** Memoizes a function so it doesn’t change unless dependencies change.  
**Use Case:** Prevent re-creating functions passed to child components.  

```jsx
import { useState, useCallback } from "react";

function Button({ onClick }) {
  return <button onClick={onClick}>Click</button>;
}

function App() {
  const [count, setCount] = useState(0);

  const handleClick = useCallback(() => {
    setCount(c => c + 1);
  }, []);

  return (
    <>
      <h1>{count}</h1>
      <Button onClick={handleClick} />
    </>
  );
}
```

---

## 🔹 7. `useMemo`

**Definition:** Memoizes a computed value.  
**Use Case:** Expensive calculations, derived state.  

```jsx
import { useState, useMemo } from "react";

function ExpensiveCalc({ num }) {
  const result = useMemo(() => {
    console.log("Calculating...");
    return num * 2;
  }, [num]);

  return <h1>{result}</h1>;
}
```

---

## 🔹 8. `useRef`

**Definition:** Stores mutable values that persist across renders.  
**Use Case:** Access DOM elements, store instance variables.  

```jsx
import { useRef, useEffect } from "react";

function InputFocus() {
  const inputRef = useRef();

  useEffect(() => {
    inputRef.current.focus();
  }, []);

  return <input ref={inputRef} placeholder="Auto focused" />;
}
```

---

## 🔹 9. `useImperativeHandle`

**Definition:** Customizes what is exposed when using `ref` with `forwardRef`.  
**Use Case:** Expose specific functions from child to parent.  

```jsx
import { useImperativeHandle, useRef, forwardRef } from "react";

const Input = forwardRef((props, ref) => {
  const inputRef = useRef();

  useImperativeHandle(ref, () => ({
    focus: () => inputRef.current.focus()
  }));

  return <input ref={inputRef} />;
});

function App() {
  const inputRef = useRef();
  return (
    <>
      <Input ref={inputRef} />
      <button onClick={() => inputRef.current.focus()}>Focus Input</button>
    </>
  );
}
```

---

## 🔹 10. `useTransition` (React 18)

**Definition:** Allows marking state updates as **non-urgent** (low-priority).  
**Use Case:** Smooth UI updates with heavy rendering.  

```jsx
import { useState, useTransition } from "react";

function Search() {
  const [query, setQuery] = useState("");
  const [list, setList] = useState([]);
  const [isPending, startTransition] = useTransition();

  function handleChange(e) {
    const value = e.target.value;
    setQuery(value);
    startTransition(() => {
      setList(Array(2000).fill(value));
    });
  }

  return (
    <>
      <input value={query} onChange={handleChange} />
      {isPending ? <p>Loading...</p> : list.map((item, i) => <div key={i}>{item}</div>)}
    </>
  );
}
```

---

## 🔹 11. `useDeferredValue` (React 18)

**Definition:** Defers updating a value until less urgent work is finished.  
**Use Case:** Show instant UI while deferring expensive rendering.  

```jsx
import { useState, useDeferredValue } from "react";

function List({ input }) {
  const deferredInput = useDeferredValue(input);
  return <div>{Array(1000).fill(deferredInput).join(",")}</div>;
}

function App() {
  const [text, setText] = useState("");
  return (
    <>
      <input value={text} onChange={e => setText(e.target.value)} />
      <List input={text} />
    </>
  );
}
```

---

## 🔹 12. `useId` (React 18)

**Definition:** Generates a stable unique ID.  
**Use Case:** Accessibility, form fields.  

```jsx
import { useId } from "react";

function Form() {
  const id = useId();
  return (
    <>
      <label htmlFor={id}>Name</label>
      <input id={id} type="text" />
    </>
  );
}
```

---

## 🔹 13. `useSyncExternalStore` (React 18)

**Definition:** Subscribe to external data sources safely.  
**Use Case:** Redux/Zustand state integration.  

```jsx
import { useSyncExternalStore } from "react";

function subscribe(callback) {
  window.addEventListener("resize", callback);
  return () => window.removeEventListener("resize", callback);
}

function getSnapshot() {
  return window.innerWidth;
}

function WindowSize() {
  const width = useSyncExternalStore(subscribe, getSnapshot);
  return <h1>Window width: {width}</h1>;
}
```

---

## 🔹 14. `useInsertionEffect` (React 18)

**Definition:** Fires synchronously before DOM mutations.  
**Use Case:** CSS-in-JS libraries for injecting styles.  

```jsx
import { useInsertionEffect } from "react";

function StyledBox() {
  useInsertionEffect(() => {
    const style = document.createElement("style");
    style.innerHTML = ".box { color: red; }";
    document.head.appendChild(style);
  }, []);

  return <div className="box">Hello</div>;
}
```

---

# ✅ Summary Table

| Hook | Purpose | Example Use Case |
|------|---------|------------------|
| **useState** | State management | Counter, form |
| **useEffect** | Side-effects | API calls, timers |
| **useLayoutEffect** | DOM measurement before paint | Scroll, size |
| **useContext** | Global state access | Theme, Auth |
| **useReducer** | Complex state transitions | Counter, form logic |
| **useCallback** | Memoize functions | Prevent re-renders |
| **useMemo** | Memoize values | Expensive calc |
| **useRef** | DOM refs / mutable values | Focus input, store prev value |
| **useImperativeHandle** | Custom ref APIs | Expose child methods |
| **useTransition** | Low-priority updates | Smooth UI in search |
| **useDeferredValue** | Defer value updates | Laggy input optimization |
| **useId** | Unique ID generator | Forms, accessibility |
| **useSyncExternalStore** | Subscribe to external store | Redux integration |
| **useInsertionEffect** | Inject styles before paint | CSS-in-JS |
