# Angular Interview Guide (Grouped)

This guide groups Angular interview questions into thematic sections for easier reference.

## Index

### Basic / Direct Questions
- [What is the basic use of async pipe in Angular?](#what-is-the-basic-use-of-async-pipe-in-angular)
- [What is View Encapsulation in Angular?](#what-is-view-encapsulation-in-angular)
- [What is Content Projection in Angular?](#what-is-content-projection-in-angular)
- [What are Reactive Forms and Template-Driven Forms?](#what-are-reactive-forms-and-template-driven-forms)
- [How does Angular Application Bootstrap?](#how-does-angular-application-bootstrap)
- [What is angular.json?](#what-is-angularjson)
- [ng build vs ng serve](#ng-build-vs-ng-serve)
- [Environment-specific Config](#environment-specific-config)
- [dependencies vs devDependencies](#dependencies-vs-devdependencies)
- [Different Types of Pipes](#different-types-of-pipes)
- [How to format date using Pipe?](#how-to-format-date-using-pipe)
- [Can we create Custom Pipe?](#can-we-create-custom-pipe)
- [What is Router Outlet?](#what-is-router-outlet)
- [Can we have Multiple Router Outlets?](#can-we-have-multiple-router-outlets)
- [What is trackBy in Angular?](#what-is-trackby-in-angular)
- [How do you reset a form?](#how-do-you-reset-a-form)
- [Difference between setValue() and patchValue()](#difference-between-setvalue-and-patchvalue)
- [Template-driven Form Example](#template-driven-form-example)
- [How many ways can we bind data to DOM?](#how-many-ways-can-we-bind-data-to-dom)
- [Types of Data Binding](#types-of-data-binding)
- [Why do we need Routing in Angular?](#why-do-we-need-routing-in-angular)
- [Difference between Attribute and Structural Directive](#difference-between-attribute-and-structural-directive)

### Intermediate / Core Concepts
- [Angular Lifecycle Hooks](#angular-lifecycle-hooks)
- [What is Change Detection in Angular?](#what-is-change-detection-in-angular)
- [Use of @ViewChild](#use-of-viewchild)
- [What is Shared Module in Angular?](#what-is-shared-module-in-angular)
- [Providers in Angular](#providers-in-angular)
- [Constructor vs ngOnInit](#constructor-vs-ngoninit)
- [How does Angular handle Dependency Injection?](#how-does-angular-handle-dependency-injection)
- [What is Lazy Loading and how to achieve it?](#what-is-lazy-loading-and-how-to-achieve-it)
- [What is APP_INITIALIZER?](#what-is-app_initializer)
- [How to load components dynamically?](#how-to-load-components-dynamically)
- [Use of Interceptor](#use-of-interceptor)
- [How to call backend service in Angular?](#how-to-call-backend-service-in-angular)

### RxJS / Async Handling
- [Difference between Observable and Promise](#difference-between-observable-and-promise)
- [Key Differences Between Observable and Promise (Table)](#key-differences-between-observable-and-promise-table)
- [Which RxJS operators do you use commonly?](#which-rxjs-operators-do-you-use-commonly)
- [forkJoin vs switchMap](#forkjoin-vs-switchmap)
- [How do you perform Error Handling in Observables?](#how-do-you-perform-error-handling-in-observables)
- [Subject & Types of Subject (Subject, BehaviorSubject, ReplaySubject, AsyncSubject)](#subject--types-of-subject-subject-behaviorsubject-replaysubject-asyncsubject)
- [Subject vs BehaviorSubject](#subject-vs-behaviorsubject)

### Advanced / Scenario-based Questions
- [What are Authentication Guards in Angular?](#what-are-authentication-guards-in-angular)
- [How do you change settings of zone.js?](#how-do-you-change-settings-of-zonejs)
- [How to pass data between components?](#how-to-pass-data-between-components)
- [Scenario: Secure a route using CanActivate guard](#scenario-secure-a-route-using-canactivate-guard)
- [Scenario: Optimize *ngFor rendering using trackBy](#scenario-optimize-ngfor-rendering-using-trackby)
- [Scenario: Reset a form after submitting](#scenario-reset-a-form-after-submitting)
- [Scenario: Load config before app initializes with APP_INITIALIZER](#scenario-load-config-before-app-initializes-with-app_initializer)
- [Scenario: Handle multiple API calls (forkJoin vs switchMap)](#scenario-handle-multiple-api-calls-forkjoin-vs-switchmap)
- [Scenario: Pass data between unrelated components using a service with Subject](#scenario-pass-data-between-unrelated-components-using-a-service-with-subject)

---

## Basic / Direct Questions

### What is the basic use of async pipe in Angular?
**Answer:**
The `async` pipe subscribes to an Observable or Promise and returns the latest emitted value. It also handles **unsubscribe automatically** when the component is destroyed.

**Example:**
```html
<p>{{ user$ | async }}</p>
```

---

### What is View Encapsulation in Angular?
**Answer:**
View Encapsulation determines how Angular styles are scoped to components.

**Types:**
- **Emulated** (Default) – Uses simulated Shadow DOM by adding unique attributes.
- **ShadowDom** – Uses native Shadow DOM encapsulation.
- **None** – No encapsulation; styles are global.

**Example:**
```typescript
@Component({
  selector: 'app-test',
  template: `<h1>Hello</h1>`,
  styles: [`h1 { color: red; }`],
  encapsulation: ViewEncapsulation.Emulated
})
export class TestComponent {}
```

---

### What is Content Projection in Angular?
**Answer:**
Content Projection (using `<ng-content>`) allows you to insert external content into a component's template.

**Example:**
```html
<!-- Parent Component Template -->
<app-card>
  <p>Projected content goes here</p>
</app-card>

<!-- Child Component Template -->
<div class="card">
  <ng-content></ng-content>
</div>
```

---

### What are Reactive Forms and Template-Driven Forms?
**Answer:**
Angular provides two approaches for handling forms:

- **Template-driven forms:** Use directives like `ngModel` for easier, less complex forms.
- **Reactive forms:** Use `FormGroup` and `FormControl` for more complex and dynamic forms with better testability.

**Reactive Example:**
```typescript
form = new FormGroup({
  name: new FormControl('')
});
```

---

### How does Angular Application Bootstrap?
**Answer:**
Angular bootstraps from the `main.ts` file, where `platformBrowserDynamic().bootstrapModule(AppModule)` is called to launch the application by loading `AppComponent` through the module's declarations.

---

### What is angular.json?
**Answer:**
`angular.json` is the Angular CLI configuration file that defines project settings, including build options, file replacements, assets, styles, and more.

---

### ng build vs ng serve
**Answer:**
- **ng build:** Compiles the application for deployment, producing static assets.
- **ng serve:** Builds the application and serves it locally with live-reload for development.

---

### Environment-specific Config
**Answer:**
Angular allows using different configurations for various environments (development, production) by using the `fileReplacements` option in `angular.json` to swap configuration files.

---

### dependencies vs devDependencies
**Answer:**
- **dependencies:** Packages required at runtime.
- **devDependencies:** Packages needed only during development, such as testing or build tools.

---

### Different Types of Pipes
**Answer:**
Angular provides several built-in pipes such as:
- `date`
- `currency`
- `json`
- `async`
- `uppercase` and `lowercase`

You can also create custom pipes.

---

### How to format date using Pipe?
**Answer:**
You can format dates using the built-in `date` pipe.

**Example:**
```html
<p>{{ today | date:'shortDate' }}</p>
```

---

### Can we create Custom Pipe?
**Answer:**
Yes, you can create a custom pipe using the `@Pipe` decorator and implementing the `PipeTransform` interface.

---

### What is Router Outlet?
**Answer:**
`<router-outlet>` acts as a placeholder in your template where the matched component for a route is displayed.

---

### Can we have Multiple Router Outlets?
**Answer:**
Yes, Angular supports multiple router outlets using **named outlets**. This allows different sections of the page to be updated independently based on the route configuration.

---

### What is trackBy in Angular?
**Answer:**
The `trackBy` function improves performance in `*ngFor` loops by providing a unique identifier for items, helping Angular track changes and avoid re-rendering unchanged DOM elements.

**Example:**
```html
<li *ngFor="let item of items; trackBy: trackById">{{ item.name }}</li>
```

---

### How do you reset a form?
**Answer:**
For a reactive form, you can call the `reset()` method on the form instance:

```typescript
this.form.reset();
```

---

### Difference between setValue() and patchValue()
**Answer:**
- **setValue():** Requires that all values for the form controls are provided.
- **patchValue():** Allows partial updates to the form model.

---

### Template-driven Form Example
**Answer:**
In template-driven forms, you use the `ngForm` directive along with `ngModel`:

```html
<form #f="ngForm">
  <input name="username" ngModel>
</form>
```

---

### How many ways can we bind data to DOM?
**Answer:**
Angular supports multiple data binding techniques:
- **Interpolation:** `{{ data }}`
- **Property Binding:** `[property]="value"`
- **Event Binding:** `(event)="handler()"`
- **Two-way Binding:** `[(ngModel)]="value"`

---

### Types of Data Binding
**Answer:**
The types of data binding include:
- **One-way data binding:** From component to view or vice versa.
- **Two-way data binding:** Synchronizes data between the component and view (using `[(ngModel)]`).

---

### Why do we need Routing in Angular?
**Answer:**
Routing enables navigation between different views and components without reloading the page, thereby creating a single-page application experience.

---

### Difference between Attribute and Structural Directive
**Answer:**
- **Attribute Directives:** Change the appearance or behavior of an element (e.g., `ngClass`).
- **Structural Directives:** Change the DOM layout by adding or removing elements (e.g., `*ngIf`, `*ngFor`).

---

## 🔹 Intermediate / Core Concepts

### Angular Lifecycle Hooks
**Answer:**
Angular lifecycle hooks such as `ngOnInit`, `ngOnChanges`, `ngDoCheck`, `ngAfterViewInit`, `ngAfterContentInit`, and `ngOnDestroy` allow you to tap into key events in a component's lifecycle.

---

### What is Change Detection in Angular?
**Answer:**
Change Detection is the process by which Angular determines and updates the view when data changes in the model. It supports strategies like the default and OnPush approaches.

---

### Use of @ViewChild
**Answer:**
The `@ViewChild` decorator is used to access a child component, directive, or DOM element from a parent component.

---

### What is Shared Module in Angular?
**Answer:**
A Shared Module is used to collect and re-export common components, directives, and pipes that will be used across multiple modules in an application.

---

### Providers in Angular
**Answer:**
Providers in Angular configure dependency injection by defining how to obtain a value for a dependency. Providers can be registered at the module, component, or directive level.

---

### Constructor vs ngOnInit
**Answer:**
- **Constructor:** Used for dependency injection and initializing class members.
- **ngOnInit:** A lifecycle hook called after the constructor, ideal for performing component initialization that requires bindings.

---

### How does Angular handle Dependency Injection?
**Answer:**
Angular uses a hierarchical dependency injection system where providers are registered at various levels, allowing for instance sharing, and scoping of dependencies.

---

### What is Lazy Loading and how to achieve it?
**Answer:**
Lazy Loading is a technique where feature modules are loaded on demand rather than at initial load time. This is achieved using the `loadChildren` syntax in the routing configuration.

---

### What is APP_INITIALIZER?
**Answer:**
`APP_INITIALIZER` is a token that allows you to execute functions before the Angular app is initialized, often used to load configuration data.

---

### How to load components dynamically?
**Answer:**
You can load components dynamically using the `ViewContainerRef.createComponent()` method, which creates a component at runtime.

---

### Use of Interceptor
**Answer:**
HTTP Interceptors are used to globally modify HTTP requests and responses, such as adding authentication tokens or logging request details.

---

### How to call backend service in Angular?
**Answer:**
Backend services can be called using Angular's `HttpClient` service which supports making HTTP requests and handling responses with observables.

---

## 🔹 RxJS / Async Handling

### Difference between Observable and Promise
**Answer:**
- **Observable:** Returns a stream of data over time and supports multiple emissions, cancellation, and RxJS operators.
- **Promise:** Represents a single asynchronous value and executes immediately.

---

### Key Differences Between Observable and Promise (Table)
**Answer:**
| Feature              | Observable                          | Promise                      |
| -------------------- | ----------------------------------- | ---------------------------- |
| **Values**           | Multiple values over time           | A single value              |
| **Execution**        | Lazy (executes on subscription)     | Eager (executes immediately) |
| **Cancellation**     | Can unsubscribe                     | Cannot cancel               |
| **Operators**        | Rich set of RxJS operators          | No operators                |

---

### Which RxJS operators do you use commonly?
**Answer:**
Common operators include `map`, `mergeMap`, `switchMap`, `concatMap`, `forkJoin`, and `catchError`.

---

### forkJoin vs switchMap
**Answer:**
- **forkJoin:** Runs multiple observables in parallel and emits once when all complete.
- **switchMap:** Switches to a new observable, cancelling the previous one if a new emission occurs.

---

### How do you perform Error Handling in Observables?
**Answer:**
Error handling in Observables is typically done using the `catchError` operator which allows you to intercept errors and return a safe fallback value.

---

### Subject & Types of Subject (Subject, BehaviorSubject, ReplaySubject, AsyncSubject)
**Answer:**
A **Subject** is both an Observable and an Observer, multicast to multiple subscribers.
- **BehaviorSubject:** Requires an initial value and emits the last value on new subscriptions.
- **ReplaySubject:** Replays a specified number of previous emissions to new subscribers.
- **AsyncSubject:** Emits only the last value upon completion.

---

### Subject vs BehaviorSubject
**Answer:**
- **Subject:** Does not hold a current value; subscribers only receive values emitted after subscription.
- **BehaviorSubject:** Holds a current value and emits it immediately to new subscribers.

---

## 🔹 Advanced / Scenario-based Questions

### What are Authentication Guards in Angular?
**Answer:**
Authentication Guards (like `CanActivate`, `CanDeactivate`, etc.) are used to control navigation to routes based on authentication status or other conditions.

---

### How do you change settings of zone.js?
**Answer:**
You can change settings of `zone.js` by setting configuration flags (zone-flags) **before** importing `zone.js` in your application.

---

### How to pass data between components?
**Answer:**
Data can be passed between components using `@Input()` and `@Output()` decorators, services with subjects, or via router parameters.

---

### Scenario: Secure a route using CanActivate guard
**Answer:**
Implement a guard by creating a service that implements the `CanActivate` interface, then check authentication status (e.g., via a token in local storage) before allowing route activation.

---

### Scenario: Optimize *ngFor rendering using trackBy
**Answer:**
Provide a `trackBy` function in your `*ngFor` directive to uniquely identify items, reducing DOM manipulations when the list changes.

---

### Scenario: Reset a form after submitting
**Answer:**
After form submission, call the form's `reset()` method to clear all fields and reset the form state.

---

### Scenario: Load config before app initializes with APP_INITIALIZER
**Answer:**
Use the `APP_INITIALIZER` token to provide a factory function that loads configuration data (e.g., from a JSON file) before the application bootstraps.

---

### Scenario: Handle multiple API calls (forkJoin vs switchMap)
**Answer:**
Use `forkJoin` to wait for multiple API calls to complete in parallel, or `switchMap` to cancel previous requests when a new one is made, depending on the use case.

---

### Scenario: Pass data between unrelated components using a service with Subject
**Answer:**
Create a shared service that encapsulates a Subject. Components can subscribe to this Subject to receive data and use methods on the service to emit data, facilitating communication between unrelated components.

---

