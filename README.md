# Water Management

## Requirement

- Java
- JDK-17

## Running with input files located in resource

input-1

```
ALLOT_WATER 2 3:7
ADD_GUESTS 2
ADD_GUESTS 3
BILL
```

```
./gradlew run --args="input-1"
```

input-2

```
ALLOT_WATER 3 2:1
ADD_GUESTS 4
ADD_GUESTS 1
BILL
```

```
./gradlew run --args="input-2"
```

input-3

```
ALLOT_WATER 2 1:2
BILL
```

```
./gradlew run --args="input-3"
```
