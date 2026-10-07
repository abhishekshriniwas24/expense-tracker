# Expense Tracker REST API

A backend REST API built with **Java and Spring Boot** for managing personal expenses. The application supports expense CRUD operations, filtering, sorting, total expense calculations, and request validation.

## Features

* Add a new expense
* View all expenses
* View an expense by ID
* Update an expense
* Delete an expense
* Filter expenses by category
* Filter expenses by date
* Calculate total expenses
* Calculate total expenses by category
* Sort expenses by amount
* Input validation
* Global validation error handling

## Technologies Used

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman
* IntelliJ IDEA

## Project Structure

```text
src/main/java/com/example/expensetracker
├── controller
│   └── ExpenseController.java
├── entity
│   └── ExpenseEntity.java
├── exception
│   └── GlobalExceptionHandler.java
├── repository
│   └── ExpenseRepository.java
└── service
    └── ExpenseService.java
```

## API Endpoints

| Method | Endpoint                              | Description                 |
| ------ | ------------------------------------- | --------------------------- |
| POST   | `/expenses`                           | Add an expense              |
| GET    | `/expenses`                           | Get all expenses            |
| GET    | `/expenses/{id}`                      | Get expense by ID           |
| PUT    | `/expenses/{id}`                      | Update an expense           |
| DELETE | `/expenses/{id}`                      | Delete an expense           |
| GET    | `/expenses/category/{category}`       | Filter by category          |
| GET    | `/expenses/date/{date}`               | Filter by date              |
| GET    | `/expenses/total`                     | Calculate total expenses    |
| GET    | `/expenses/total/category/{category}` | Calculate total by category |
| GET    | `/expenses/sort/amount`               | Sort expenses by amount     |

## Sample Expense

```json
{
  "title": "Electricity Bill",
  "amount": 1500.00,
  "category": "UTILITY",
  "date": "2026-10-02T12:30:00"
}
```

## Validation

The API validates incoming expense data.

Examples:

* Title cannot be blank.
* Category cannot be blank.
* Amount must be greater than zero.

Validation errors are returned through a global exception handler with field-specific messages.

## Database

The application uses MySQL.

Create the database with:

```sql
CREATE DATABASE expense_tracker;
```

Database credentials should be configured locally and should **not** be committed to the repository.

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Configure your local MySQL database.
4. Configure the `DB_PASSWORD` environment variable.
5. Run the Spring Boot application.
6. Test the endpoints using Postman.

The application runs by default on:

```text
http://localhost:8080
```

## Future Improvements

* User authentication and authorization
* Monthly expense reports
* Expense statistics and dashboards
* Pagination
* Swagger/OpenAPI documentation
