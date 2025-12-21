### Front-End — Angular 18 (Angular-specific guidance)

**Short summary:** Use Angular 18 for modern web apps; focus on correctness, performance, and developer ergonomics. Prefer AOT builds, strict TypeScript settings, lazy-loaded feature modules or standalone components, and server-side rendering (when SEO/first-load matters).

### Architecture recommendations
- Prefer **standalone components** (where suitable) to simplify module graphs; use NgModules for reusable/legacy module boundaries.
- Break the app into **feature modules** and lazy-load routes for smaller initial bundles.
- Use **OnPush change detection**, immutability, and micro-benchmarks for hot paths.
- Consider **SSR (Angular Universal) + hydration** for SEO and faster first meaningful paint when needed.
- For very large apps, evaluate **micro-frontends** (Module Federation or web components) and monorepos (Nx) for scale and team ownership.

### State & data handling
- Use local component state for UI concerns and services for shared state.
- For complex global state, prefer NgRx (or lighter alternatives like Akita or RxJS-based patterns); consider server-state libraries for caching and synchronization.
- Consider Angular's reactive primitives (RxJS and Signals where adopted) and prefer explicit unidirectional data flows.

### Performance & optimization
- Build with **AOT** and production flags; enable `optimization` and `budgets` in `angular.json`.
- Analyze bundles (source-map-explorer, webpack-bundle-analyzer) and remove large dependencies or lazy-load them.
- Use image optimization, code-splitting, preconnect, CDN hosting, and critical CSS to improve LCP and FCP.

### Build, tooling & CI
- Use Angular CLI v18 (`npx -p @angular/cli@18 ng ...`) for project setup and migrations.
- Enable `strict` mode and fixed TypeScript versions suggested by `ng update`.
- Run linting, unit tests, e2e tests, and Lighthouse audits in CI; publish build artifacts with reproducible builds.

### Security
- Avoid direct DOM insertion (`innerHTML`) unless sanitized; enable CSP and secure cookie practices; validate inputs server-side.
- Keep dependencies updated and scan for vulnerabilities; automate dependency updates where possible.
> See `OAUTH2_SECURITY_JAVA.md` for a concise OAuth2 / token security design guide and interview bullets.

### CSRF & Refresh Tokens (Cookie vs Token flows)

- **CSRF protection**: If your app relies on cookies for authentication, protect state-changing endpoints using CSRF tokens (synchronizer token pattern) or the double-submit cookie pattern. Issue a CSRF token to the client (non-HttpOnly cookie or inlined in the HTML) and require it in a custom header (e.g., `X-CSRF-Token`) for state-changing requests.
- **Bearer tokens vs cookies**: When using Bearer tokens in the `Authorization` header CSRF risk is lower, but XSS becomes the primary concern — protect against XSS to keep tokens safe.
- **Refresh token handling**:
	- Store refresh tokens in **HttpOnly, Secure, SameSite** cookies (avoid localStorage for refresh tokens) and call refresh endpoints with `withCredentials: true` from the client.
	- Use **refresh token rotation** (issue a new refresh token on use and revoke the old one) to detect token theft and force re-authentication on reuse.
	- Keep access tokens short-lived and use refresh tokens for obtaining new access tokens; provide a revocation endpoint and capability to invalidate tokens server-side.
- **Cookie best practices**: set `HttpOnly`, `Secure`, and appropriate `SameSite` (Lax/Strict) attributes; if cross-site cookies are required use `SameSite=None` plus `Secure` and only over HTTPS.

### Angular & Client details

- For SPAs using HttpOnly refresh cookies: call the refresh endpoint using fetch/HttpClient with `credentials: 'include'` / `withCredentials: true` so the browser sends cookies automatically.
- To send CSRF tokens, expose a non-HttpOnly CSRF cookie (or page meta tag) and include it in a header via an HTTP interceptor.

### Short Spring examples (server-side)

```java
// Set refresh token cookie (Spring)
ResponseCookie cookie = ResponseCookie.from("refresh_token", token)
		.httpOnly(true)
		.secure(true)
		.sameSite("Strict")
		.path("/")
		.maxAge(Duration.ofDays(30))
		.build();
response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

// Enable CSRF with cookie-based token repo
http
	.csrf(csrf -> csrf
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	);
```

### Interview bullets — quick answers
- “CSRF: use SameSite + CSRF tokens for cookie-based auth; for Bearer tokens use Authorization header and protect against XSS.”
- “Store refresh tokens as HttpOnly Secure cookies and rotate on use; provide a revocation endpoint and short-lived access tokens.”
- “In Angular, call refresh with `withCredentials: true` and attach CSRF token from a non-HttpOnly cookie or meta tag via an interceptor.”

### Testing & observability
- Unit: Jest/Karma; Component tests with Testing Library; E2E: Cypress/Playwright.
- Track client-side metrics (FCP, LCP, CLS) and errors (Sentry/RUM); include tracing/correlation IDs for request flows.

### Upgrade / Migration quick steps (Angular 18)
1. Commit and branch: `git checkout -b upgrade/angular-18`.
2. Use the v18 CLI to migrate: `npx -p @angular/cli@18 ng update @angular/core @angular/cli` and follow the output.
3. Update peer deps (TypeScript, RxJS, zone.js) as suggested and run `npm install`.
4. Run `ng build --configuration production`, unit and e2e tests, and fix template/TS errors.
5. Iterate until CI and tests pass; update Docker/CI Node versions as needed.

### Interview points — quick bullets
- Prefer AOT, strict checks, and smaller initial bundles; lazy-load features and use OnPush to reduce change detection work.
- Explain SSR vs CSR trade-offs: SSR improves SEO and first meaningful paint; CSR can give snappier subsequent navigation.
- State choices: “I use local component state for UI, NgRx for complex app-wide invariants, and server-state caching for remote data.”
- Upgrade approach: commit, run `ng update` with the target CLI, update peers, fix errors, run tests.

### Useful commands
```powershell
# create (Angular 18) new project
npx -p @angular/cli@18 ng new my-app --routing --style=scss

# migrate existing project safely
git checkout -b upgrade/angular-18
npx -p @angular/cli@18 ng update @angular/core @angular/cli
npm install
ng build --configuration production
```

---




### Back-Ens Java Overall Architecture Style

Monolithic: All components are bundled together into a single deployable unit. This makes it simpler in terms of deployment but can lead to scalability challenges as it grows.

Microservices: The application is broken into smaller, independent services, each responsible for a specific function. This makes scaling, deployment, and maintenance more flexible and resilient.

### Interview points
- Monolith pros: simpler deployment, easier local debugging, less operational overhead.
- Monolith cons: harder to scale by component, slower release cycles, team coordination bottlenecks.
- Microservices pros: independent deploys, team autonomy, easier per-service scaling.
- Microservices cons: operational complexity (service discovery, tracing), data consistency challenges, higher infra cost.
- When to choose: start monolith for fast iteration; extract services when you need independent scaling or faster teams.

2. User Authentication and Authorization

Authentication: Users typically log in using a username and password, or via OAuth/SSO mechanisms. After authentication, the system issues a token (like a JWT) that the user includes in subsequent requests.

Authorization: Once authenticated, users have specific roles or permissions. For example, an admin might have access to certain endpoints that a regular user wouldn’t. Role-based access control (RBAC) is commonly used.

### Interview points
- Auth methods: session cookies (stateful) vs JWT/OAuth2 (stateless); trade-offs in revocation and complexity.
- Token best practices: short-lived access tokens, use refresh tokens, store securely (HttpOnly+Secure cookies or secure storage).
- Passwords: store with strong hashing (bcrypt/Argon2), enforce MFA for sensitive access.
- Authorization: RBAC for roles, ABAC for attributes; principle of least privilege.
- Common Qs: token revocation, replay protection, CSRF mitigation, and secure token rotation.

3. Data Flow and APIs

Front-End to Back-End: The front-end (like a web or mobile app) sends requests to the back-end APIs. These requests could be RESTful or GraphQL-based.

API Gateway: Often, an API gateway sits in front of the services, handling routing, authentication, and rate limiting.

### Interview points
- REST vs GraphQL: REST is simple and cache-friendly; GraphQL is flexible for clients but harder to cache/monitor.
- API gateway responsibilities: routing, auth, rate limiting, TLS termination, canary releases.
- Best practices: consistent status codes, versioning, idempotency for unsafe retries, pagination, rate limits.
- Observability: expose metrics and trace IDs at API boundaries for correlation.
- Security: input validation, auth checks, throttling, and API quotas.

4. Data Storage and Management

Databases: You might use relational databases (like MySQL, PostgreSQL) for structured data and NoSQL databases (like MongoDB, Cassandra) for unstructured or semi-structured data.

Caching: Implement caching (e.g., with Redis or Memcached) to reduce database load and improve response times.

### Interview points
- Choose DB by access pattern: relational for ACID and complex queries; NoSQL for scale and flexible schemas.
- Consistency models: understand ACID vs eventual consistency trade-offs.
- Scaling DBs: read replicas for reads, sharding/partitioning for write scale, and indexing strategies.
- Caching patterns: cache-aside, read-through, write-through; be mindful of cache invalidation.
- Backups, migrations, and disaster recovery are crucial design considerations.

5. Scalability and Performance

Horizontal Scaling: Adding more instances of services to handle increased load. This is often done via container orchestration tools like Kubernetes.

Load Balancing: Distributing incoming traffic across multiple instances to ensure no single instance is overwhelmed.

### Interview points
- Horizontal vs vertical scaling: prefer stateless horizontal scaling for elasticity.
- Make services stateless or externalize session state (Redis, DB).
- Autoscaling triggers: CPU, memory, request latency, custom metrics.
- Load balancer patterns: L4 vs L7, health checks, sticky sessions trade-offs.
- Database scaling: replicas, partitioning, CQRS for read/write separation.
- Use CDNs for static assets and aggressive caching for hotspots.

6. Error Handling and Resilience

Retry Mechanisms: Implementing retries for transient failures to ensure robustness.

Circuit Breaker Pattern: If a service is failing, the circuit breaker stops requests to it, preventing further strain and allowing the service to recover.

### Interview points
- Retries: use exponential backoff + jitter and ensure idempotency for safe retries.
- Timeouts: enforce sensible timeouts to avoid resource exhaustion.
- Pattern use: circuit breakers, bulkheads, and graceful degradation.
- Observability: track error rates and implement alerts for SLO breaches.
- Test resilience with chaos engineering and fault injection.

7. Security Measures

Encryption: Use HTTPS for data in transit and encryption at rest for sensitive data.

Access Control: Ensure that only authorized users can access certain endpoints, and use role-based or attribute-based access control.

### Interview points
- TLS everywhere, strong cipher suites, and certificate management (automate rotation).
- Secrets management: use vaults or secret stores, avoid hardcoding secrets.
- Input validation and sanitization, protect against OWASP Top 10.
- Principle of least privilege, network segmentation, and audit logging.
- Secure supply chain: scan dependencies and enforce signed artifacts.

8. Monitoring and Logging

Monitoring Tools: Use tools like Prometheus, Grafana, or New Relic to keep an eye on performance metrics.

Logging: Centralized logging with tools like ELK stack or Splunk helps in debugging and tracking issues.

### Interview points
- Metrics: track latency, error rates, throughput; use SLIs/SLOs and meaningful alerts.
- Logging: structured logs, correlation IDs, centralized aggregation, and retention policies.
- Tracing: distributed tracing (Jaeger/Zipkin) to debug cross-service flows.
- Dashboards and runbooks: have runbooks for common incidents and actionable alerts.
- Health checks and synthetic monitoring for end-to-end availability checks.

### Distributed tracing adds:

-Trace ID – same for entire request

-Span ID – for each microservice call

-Parent Span ID – defines call hierarchy



