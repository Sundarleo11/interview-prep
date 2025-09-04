# ⚡ React Interview Guide

A complete set of **React interview questions & answers** with explanations and code samples.  

---

## 📑 Table of Contents

1. [Element vs Component](#1-difference-between-element-and-component)  
2. [Pure Components](#2-what-are-pure-components)  
3. [Refs in React](#3-what-are-refs-in-react)  
4. [forwardRef](#4-what-is-forwardref)  
5. [Virtual DOM](#5-what-is-the-virtual-dom)  
6. [HTTP Interceptors](#6-what-are-interceptors-http-requests)  
7. [React Fiber](#7-what-is-react-fiber)  
8. [Lifecycle Methods](#8-lifecycle-methods-class-vs-functional)  
9. [Higher Order Components (HOC)](#9-when-do-we-use-higher-order-components-hoc)  
10. [Lazy Loading](#10-what-is-lazy-loading-in-react)  
11. [Role-Based Nested Routing](#11-role-based-nested-routing)  
12. [Latest React Framework](#12-what-is-the-latest-react-framework)  
13. [Event Delegation](#13-what-is-event-delegation-in-react)  
14. [Types of Events](#14-types-of-events-in-react)  
15. [Event Capturing vs Bubbling](#15-event-capturing-vs-bubbling)  
16. [React.memo](#16-what-is-reactmemo)  
17. [Optimization Techniques](#17-optimization-techniques)  
18. [Tree Shaking](#18-what-is-tree-shaking)  
19. [Debounce in React](#19-debounce-in-react)  
20. [Lifecycle of Components](#20-lifecycle-of-react-components)  
21. [useMemo Use Case](#21-usememo-use-case)  
22. [React Benefits](#22-what-is-react-benefits)  
23. [Puppeteer Fallback](#23-puppeteer-fallback-in-react)  

---

## ✅ Questions & Answers

### 1. Difference between Element and Component
- **Element** → Plain object describing what to render (immutable).  
- **Component** → Function/class that returns an element.  

```jsx
const element = <h1>Hello</h1>; // Element
function Welcome() { return <h1>Hello</h1>; } // Component
```

---

### 2. What are Pure Components?
- `React.PureComponent` does a **shallow comparison of props & state** to avoid unnecessary re-renders.  
- Equivalent for functional components → `React.memo`.

---

### 3. What are Refs in React?
- Refs provide a way to **directly access DOM nodes or React elements**.  

```jsx
const inputRef = useRef();
<input ref={inputRef} />
```

---

### 4. What is forwardRef?
- Technique to **pass refs through a component** to its child.  

```jsx
const Child = React.forwardRef((props, ref) => <input ref={ref} />);
```

---

### 5. What is the Virtual DOM?
- **Virtual DOM** → lightweight in-memory representation of real DOM.  
- React updates Virtual DOM, then diffs & patches changes to the real DOM.

---

### 6. What are interceptors (HTTP requests)?
- Not part of React itself, but in **Axios/Fetch wrappers**.  
- Interceptors allow **modifying requests/responses globally** (e.g., attach tokens).

---

### 7. What is React Fiber?
- **React Fiber** = reconciliation algorithm introduced in React 16.  
- Supports incremental rendering (splitting rendering into chunks).

---

### 8. Lifecycle Methods (Class vs Functional)

**Class Components**
- Mount → `constructor`, `componentDidMount`  
- Update → `shouldComponentUpdate`, `componentDidUpdate`  
- Unmount → `componentWillUnmount`

**Functional Components**
- `useEffect` replaces multiple lifecycle methods.

---

### 9. When do we use Higher Order Components (HOC)?
- HOC = function that takes a component and returns a new one.  
- Use cases: reusability, logging, authentication.

---

### 10. What is Lazy Loading in React?
- **Load components on demand** to reduce bundle size.  

```jsx
const LazyComp = React.lazy(() => import('./MyComp'));
```

---

### 11. Role-Based Nested Routing
- Use `react-router-dom` with **protected routes**.  

```jsx
<Route path="/admin" element={role==="admin" ? <Admin /> : <NoAccess />} />
```

---

### 12. What is the Latest React Framework?
- **Next.js** → server-side rendering + static site generation.  
- Others: Remix, Gatsby.

---

### 13. What is Event Delegation in React?
- React uses **synthetic events** with delegation at the root for performance.

---

### 14. Types of Events in React
- Mouse Events (`onClick`)  
- Keyboard Events (`onKeyDown`)  
- Form Events (`onChange`)  
- Touch Events (`onTouchStart`)  

---

### 15. Event Capturing vs Bubbling
- **Capturing**: Event flows **root → target**.  
- **Bubbling**: Event flows **target → root**.  
- React supports both (`onClick`, `onClickCapture`).

---

### 16. What is React.memo?
- Memoizes functional components to **avoid re-render** if props didn’t change.  

```jsx
export default React.memo(MyComp);
```

---

### 17. Optimization Techniques
- Code splitting → `React.lazy`, dynamic imports  
- Memoization → `React.memo`, `useMemo`, `useCallback`  
- Pure components to reduce re-renders  
- Tree shaking to remove unused code

---

### 18. What is Tree Shaking?
- Dead code elimination by bundlers (Webpack/Rollup).  
- Removes unused imports/functions.

---

### 19. Debounce in React

```jsx
function useDebounce(fn, delay) {
  const timeout = useRef();
  return (...args) => {
    clearTimeout(timeout.current);
    timeout.current = setTimeout(() => fn(...args), delay);
  };
}
```

---

### 20. Lifecycle of React Components
- **Mount → Update → Unmount**  
- In functional components → handled via `useEffect`.

---

### 21. useMemo Use Case
- Avoids recalculating expensive operations unless dependencies change.  

```jsx
const expensiveValue = useMemo(() => compute(num), [num]);
```

---

### 22. What is React? Benefits?
- **React** = JavaScript library for building UI.  
- **Benefits**: Reusability, Virtual DOM performance, ecosystem.  
- **Bundling benefit**: Smaller files + fewer network requests.

---

### 23. Puppeteer Fallback in React
- **Puppeteer** = Headless Chrome for rendering/testing.  
- Fallback for SSR → if JS fails, Puppeteer can render static HTML snapshots.

---
