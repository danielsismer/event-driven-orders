# Commit Plan

This project structure supports clean semantic and atomic commits.

## Suggested Commit Sequence

### 1. `docs: add project readme and implementation direction`

Files:

- `README.md`
- `docs/commit-plan.md`

### 2. `chore: fix spring dependencies and local development config`

Files:

- `pom.xml`
- `compose.yaml`
- `src/main/resources/application.yml`

### 3. `feat: add order domain model and persistence layer`

Files:

- `entity/*`
- `repository/*`

### 4. `feat: add order creation endpoint and validation flow`

Files:

- `controller/*`
- `dto/*`
- `service/OrderService.java`
- `exception/*`

### 5. `feat: add kafka event publishing and consumer flow`

Files:

- `event/*`
- `config/*`
- `service/OrderProducer.java`
- `consumer/*`

### 6. `test: add controller and service coverage for order flow`

Files:

- `src/test/java/**`
- `src/test/resources/**`

## Rule of Thumb

Each commit should answer only one main question:

- docs?
- infra?
- domain?
- http flow?
- kafka flow?
- tests?

If a commit mixes two responsibilities, it is probably too big.
