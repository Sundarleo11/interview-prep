# OAuth2 Security — Java Design Style

## Key principles
- Use TLS everywhere (HTTPS only) — never send tokens over plaintext.
- Prefer short-lived access tokens and rotate/secure refresh tokens to limit exposure.
- Validate tokens fully: signature, exp, iss, aud, scope, and allow small clock skew.
- Use standards (OAuth2 + OpenID Connect) and verified libraries (Spring Security, Spring Authorization Server, Nimbus JOSE, Keycloak).

## Token design & handling
- JWT vs opaque tokens: JWTs enable stateless validation (verify signature + claims); opaque tokens require server-side introspection (better for immediate revocation).
- Sign tokens with asymmetric keys (RS256); publish keys via JWKS for rotation.
- Avoid sensitive data in JWT claims; keep token claims minimal (sub, scope, aud, exp).
- Use `aud` and `scope` for fine-grained access control.
- Refresh token strategies: rotate refresh tokens on use, mark old tokens invalid, and store server-side if revocation is required.

## Client security
- Confidential clients (server-side) use client secrets and optionally mTLS.
- Public clients (SPAs, mobile) must use PKCE and never store secrest in the client.
- Store tokens securely: HttpOnly, Secure cookies for web apps; avoid localStorage for access tokens; use SameSite flags and CSRF protections.

## Authorization & scopes
- Use scopes/claims to express permissions; enforce them at resource servers.
- Choose RBAC vs ABAC depending on domain; ABAC enables more flexible policies.
- Principle of least privilege: issue minimal scopes and permissions required.

## Revocation, rotation & lifecycle
- Token revocation: support revocation endpoints and make access tokens short-lived to reduce exposure.
- Key rotation: rotate signing keys regularly and expose JWKS; design rotations to be backward-compatible for the overlap window.
- Logout: revoke refresh tokens and consider short access token lifetimes or blacklisting for immediate effect.

## Protection patterns & resilience
- Rate-limit token endpoints and protect against brute-force attacks.
- Add replay detection for refresh token reuse (refresh token rotation detects reuse).
- Cache introspection results with sensible TTLs to reduce load while respecting revocation needs.
- Use circuit breakers and timeouts on auth/introspection calls.

## Observability & operations
- Log auth events (token issuance, revocation, failed validation) with correlation IDs; do not log sensitive token contents.
- Monitor abnormal usage and alert (sudden scope use, multi-geography tokens, or high failure rates).
- Maintain audit trails for compliance (who minted/revoked tokens and when).

## Quick Do / Don't checklist
- Do: use standard libraries, enforce TLS, sign tokens with RS256, use PKCE for public clients, rotate keys and refresh tokens.
- Don't: store tokens in insecure browser storage, roll your own crypto, embed secrets in client code, use long-lived access tokens.

## Short Spring examples

### Resource Server with JWKS
```java
// application.properties
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=https://auth.example.com/.well-known/jwks.json

// Security config (Spring Boot)
http
  .authorizeHttpRequests(a -> a.anyRequest().authenticated())
  .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
```

### Refresh token rotation (conceptual)
```text
1. Client calls /token with refresh_token R1.
2. Server verifies R1, issues new access token A2 and new refresh token R2.
3. Server marks R1 as used/revoked and persists R2 (or issues stateless rotated record).
4. If server sees reuse of R1, treat as token theft and revoke session.
```

### Set refresh token as HttpOnly cookie (Spring)
```java
ResponseCookie cookie = ResponseCookie.from("refresh_token", token)
    .httpOnly(true)
    .secure(true)
    .sameSite("Strict")
    .path("/")
    .maxAge(Duration.ofDays(30))
    .build();
response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
```

## Interview-ready bullets
- "Use TLS, short-lived access tokens, rotate refresh tokens, and validate signature + claims."  
- "Prefer opaque tokens if you need instant revocation; use JWTs for stateless resource servers and validate via JWKS."  
- "For SPAs use PKCE + HttpOnly refresh cookie; avoid localStorage for tokens."  
- "Rotate signing keys and refresh tokens; log auth events but never log full tokens."

## References
- OAuth 2.0 RFCs, OpenID Connect, Spring Security & Spring Authorization Server docs, RFC 7662 (introspection).
