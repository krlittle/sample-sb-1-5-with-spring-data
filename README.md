# sample-sb-1-5-with-spring-data

Saves, reads and deletes notes over REST.

## Stack

- Spring Boot 1.5.22.RELEASE
- Java 8
- Gradle 3.5.1

## Build

```
./gradlew build
```

## Run

```
./gradlew bootRun
```

```
curl -X POST localhost:8080/notes -H 'Content-Type: application/json' -d '{"text":"buy milk"}'
curl localhost:8080/notes/1
curl -X DELETE localhost:8080/notes/1
```
