
#### Проект тестирования алгоритма вычисления чисел Фибоначчи

```markdown
# Fibonacci Number Calculator

## Description
A Spring Boot application that calculates Fibonacci numbers and includes unit and integration tests.

## Technologies Used
- Java 17
- Spring Boot
- JPA
- JUnit

## Features
- Calculate Fibonacci numbers.
- Unit and integration tests for the application.

## Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/Dimas409/java_basics.git
    cd fibonacci-calculator
    ```
2. Build the project:
    ```sh
    mvn clean install
    ```

## Usage
To run the application:
```sh
java -jar target/fibonacci-calculator-1.0-SNAPSHOT.jar

API Endpoints
Get Fibonacci Number

GET /fibonacci/{index}
Response:
{
  "index": 5,
  "value": 5
}

Running Tests
To run tests, use the following command:
mvn test











