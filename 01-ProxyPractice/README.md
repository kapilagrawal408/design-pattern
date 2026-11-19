# Example to Demonstrate Proxy Design Pattern

This example is to demonstrate the Proxy Design Pattern

## Prerequisites
- Java 17 or higher.
- Maven is included via the Maven Wrapper; no separate Maven installation is needed.

## Running
- Import this project into the Spring-Tool-Suite (STS) and run as spring boot application (Alt + Shift + X, J)
- or Simply run the commands

```
mvnw.cmd clean compile exec:java
```

## Output
```
CLIENT: Calling proxyInstance.processPayment(100)

[PROXY] Intercepted call to method: processPayment
[PROXY] ---> Opening Database Transaction...
  [REAL OBJECT] Actually processing payment of $100
[PROXY] ---> Committing Database Transaction...
```