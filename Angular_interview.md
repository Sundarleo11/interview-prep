# Angular Interview Guide

----

## 📑 Table of Contents

### 1. What is the basic use of async pipe in Angular?

### 2. What is View Encapsulation in Angular?

### 3. What is Content Projection in Angular?

### 4. What are Authentication Guards in Angular?

### 5. What are Reactive Forms and Template-Driven Forms?

### 6. How does Angular Application Bootstrap?

### 7. What is APP INITIALIZER?

### 8. How to load components dynamically?

### 9. What is trackBy in Angular?

### 10. How do you reset a form?

### 11. Difference between setValue() and patchValue()

### 12. Template-driven Form Example

### 13. What is Change Detection in Angular?

### 14. What is Router Outlet?

### 15. Can we have Multiple Router Outlets?

### 16. How do you perform Error Handling in Observables?

### 17. Which RxJS operators do you use commonly?

### 18. forkJoin vs switchMap

### 19. What is angular.json?

### 20. ng build vs ng serve

### 21. Environment-specific Config

### 22. dependencies vs devDependencies

### 23. Use of Interceptor

### 24. How many ways can we bind data to DOM?

### 25. Angular Lifecycle Hooks

### 26. Why do we need Routing in Angular?

### 27. Different Types of Pipes

### 28. How to format date using Pipe?

### 29. Can we create Custom Pipe?

### 30. Use of @ViewChild

### 31. Difference between Observable and Promise

### 32. What is Shared Module in Angular?

### 33. Providers in Angular

### 34. Constructor vs ngOnInit

### 35. How to call backend service in Angular?

### 36. Types of Data Binding

### 37. How does Angular handle Dependency Injection?

### 38. What is Lazy Loading and how to achieve it?

### 39. How to pass data between components?

### 40. Difference between Attribute and Structural Directive




---

## ✅ Angular Interview Questions

### 1. What is the basic use of `async` pipe in Angular?

**Definition:**
The `async` pipe subscribes to an Observable or Promise and returns the latest emitted value. It also handles **unsubscribe automatically** when the component is destroyed.

**Example:**

```html
<p>{{ user$ | async }}</p>
```

---

### 2. What is View Encapsulation in Angular?

**Definition:**
View Encapsulation determines how Angular styles are scoped to components.

**Types:**

* `Emulated` (Default) → Styles scoped using unique attributes.
* `ShadowDom` → Uses native Shadow DOM.
* `None` → No encapsulation; styles leak globally.

**Example:**

```typescript
@Component({
  selector: 'app-test',
  template: `<h1>Hello</h1>`,
  styles: [`h1 { color: red; }`],
  encapsulation: ViewEncapsulation.Emulated
})
```

---

### 3. What is Content Projection in Angular?

**Definition:**
Content projection (like `ng-content`) allows inserting external content into a component template.

**Example:**

```html
<!-- Parent -->
<app-card>
  <p>Inside card</p>
</app-card>

<!-- Child Component -->
<div class="card">
  <ng-content></ng-content>
</div>
```

---

### 4. What are Authentication Guards in Angular?

**Definition:**
Guards control navigation based on conditions (e.g., authentication).

**Types:**

* `CanActivate`
* `CanDeactivate`
* `CanLoad`
* `Resolve`
* `CanActivateChild`

**Example:**

```typescript
@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
  canActivate(): boolean {
    return !!localStorage.getItem('token');
  }
}
```

---

### 5. What are Reactive Forms and Template-Driven Forms?

**Definition:**

* **Template-driven**: Uses `ngModel`, simpler for small forms.
* **Reactive**: Uses `FormGroup`, `FormControl` for complex forms and dynamic validations.

**Example (Reactive):**

```typescript
form = new FormGroup({
  name: new FormControl('')
});
```

---

### 6. How does Angular Application Bootstrap?

**Definition:**
Angular bootstraps from `main.ts` → `platformBrowserDynamic().bootstrapModule(AppModule)` → loads `AppComponent`.

---

### 7. What is `APP_INITIALIZER`?

**Definition:**
A token that allows running logic **before the app initializes** (e.g., load config).

**Example:**

```typescript
providers: [
  { provide: APP_INITIALIZER, useFactory: initApp, deps: [ConfigService], multi: true }
]
```

---

### 8. How to load components dynamically?

Use `ViewContainerRef.createComponent()`.

---

### 9. What is `trackBy` in Angular?

**Definition:**
Improves performance by tracking items using an ID instead of re-rendering the entire list.

**Example:**

```html
<li *ngFor="let item of items; trackBy: trackById">{{ item.name }}</li>
```

---

### 10. How do you reset a form?

**Reactive Form:**

```typescript
this.form.reset();
```

---

### 11. Difference between `setValue()` and `patchValue()`

* `setValue()` → Requires all fields.
* `patchValue()` → Updates partial fields.

---

### 12. Template-driven Form Example

```html
<form #f="ngForm">
  <input name="username" ngModel>
</form>
```

---

### 13. How do you change settings of `zone.js`?

Use **zone-flags** before loading `zone.js`.

---

### 14. What is Change Detection in Angular?

**Definition:**
Process that updates the DOM when data changes.

**Strategies:**

* `Default`
* `OnPush`

---

### 15. What is Router Outlet?

**Definition:**
`<router-outlet>` acts as a placeholder for rendering routed components.

---

### 16. Can we have Multiple Router Outlets?

Yes, using **named outlets**.

---

### 17. How do you perform Error Handling in Observables?

**Example:**

```typescript
this.service.getData().pipe(
  catchError(err => of([]))
);
```

---

### 18. Which RxJS operators do you use commonly?

`map`, `mergeMap`, `switchMap`, `concatMap`, `forkJoin`, `catchError`

---

### 19. `forkJoin` vs `switchMap`

* `forkJoin`: Runs multiple observables in parallel, emits **once when all complete**.
* `switchMap`: Switches to new observable, cancels previous.

---

### 20. What is `angular.json`?

Config file for Angular CLI (build, assets, styles).

---

### 21. `ng build` vs `ng serve`

* `ng build`: Builds for deployment.
* `ng serve`: Builds + serves locally with live reload.

---

### 22. Environment-specific Config

Use `fileReplacements` in `angular.json`.

---

### 23. `dependencies` vs `devDependencies`

* `dependencies`: Required at runtime.
* `devDependencies`: Required only for development (e.g., testing).

---

### 24. Use of Interceptor

Modify HTTP requests/responses globally (e.g., add auth token).

---

### 25. How many ways can we bind data to DOM?

* Interpolation: `{{ data }}`
* Property Binding: `[property]="value"`
* Event Binding: `(click)="method()"`
* Two-way Binding: `[(ngModel)]="value"`

---

### 26. Angular Lifecycle Hooks

`ngOnInit`, `ngOnChanges`, `ngDoCheck`, `ngAfterViewInit`, `ngAfterContentInit`, `ngOnDestroy`

---

### 27. Why do we need Routing in Angular?

To enable navigation between views without full page reload.

---

### 28. Different Types of Pipes

`date`, `currency`, `json`, `async`, `uppercase`, `lowercase`

---

### 29. How to format date using Pipe?

```html
<p>{{ today | date:'shortDate' }}</p>
```

---

### 30. Can we create Custom Pipe?

Yes, using `@Pipe` decorator.

---

### 31. Use of @ViewChild

Access child components, DOM elements, or directives.

---

### 32. Difference between Observable and Promise

* Observable: Multiple values over time, cancellable.
* Promise: Single value, not cancellable.

---

### 33. What is Shared Module in Angular?

Module containing common components, directives, pipes for reuse.

---

### 34. Providers in Angular

Defines services for DI at module or component level.

---

### 35. Constructor vs `ngOnInit`

* Constructor: For dependency injection.
* `ngOnInit`: For initialization logic after data-bound properties.

---

### 36. How to call backend service in Angular?

Using `HttpClient` service.

---

### 37. Types of Data Binding

* Interpolation
* Property
* Event
* Two-way

---

### 38. How does Angular handle Dependency Injection?

Hierarchical Injector → Provides instances per module/component.

---

### 39. What is Lazy Loading and how to achieve it?

Load feature modules on demand using `loadChildren` in routes.

---

### 40. How to pass data between components?

* `@Input()` and `@Output()`
* Service with Subject
* Router params
* Local storage

---

### 41. Difference between Attribute and Structural Directive

* Attribute: Changes appearance/behavior (`ngClass`).
* Structural: Changes DOM structure (`*ngIf`, `*ngFor`).

### 42.Key Differences Between Observable and Promise

| Feature              | **Observable**                          | **Promise**                      |
| -------------------- | --------------------------------------- | -------------------------------- |
| **Values**           | Can emit **multiple values over time**  | Emits **only one value**         |
| **Execution**        | **Lazy** (executes when subscribed)     | **Eager** (executes immediately) |
| **Cancelation**      | Possible via `unsubscribe()`            | Not possible after started       |
| **Operators**        | Has RxJS operators like `map`, `filter` | No such operators                |
| **Push vs Pull**     | Push-based, supports streaming          | Push-based but only one emission |
| **Built-in Support** | Part of RxJS (used in Angular)          | Native JavaScript feature        |

---


### Subject & Types of Subject

Subject: Both an Observable and Observer. Multicasts values.

Types:

Subject → Normal.

BehaviorSubject → Requires initial value, emits last value to new subscribers.

ReplaySubject → Replays old values to new subscribers.

AsyncSubject → Emits only last value after completion. 


### 44. Subject vs behaviorSubject

A Subject is both an Observable and an Observer.

It allows values to be multicast to multiple subscribers.

Subscribers only receive values emitted after subscription.

```
import { Subject } from 'rxjs';

const subject = new Subject<number>();
subject.subscribe(val => console.log('Subscriber 1:', val));
subject.next(10); // Subscriber 1: 10
subject.next(20); // Subscriber 1: 20

```

BehaviorSubject (RxJS)

A BehaviorSubject is a special type of Subject that:

Requires an initial value.

Always emits the latest value to new subscribers immediately upon subscription.

```import { BehaviorSubject } from 'rxjs';

const behaviorSubject = new BehaviorSubject<number>(0);
behaviorSubject.subscribe(val => console.log('Subscriber 1:', val)); // 0
behaviorSubject.next(5); // Subscriber 1: 5
behaviorSubject.subscribe(val => console.log('Subscriber 2:', val)); // 5
```

| Feature                 | **Subject**                              | **BehaviorSubject**                                       |
| ----------------------- | ---------------------------------------- | --------------------------------------------------------- |
| **Initial Value**       | ❌ No initial value required              | ✅ Requires an initial value                               |
| **Last Emitted Value**  | ❌ Does **not** store last value          | ✅ Stores and emits last value to new subscribers          |
| **On New Subscription** | Subscriber gets **nothing until next()** | Subscriber immediately gets **current/latest value**      |
| **Use Case**            | When **no need to keep previous value**  | When **always want subscribers to have the latest value** |

