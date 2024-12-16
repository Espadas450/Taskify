# Taskify - Task Management System

*Taskify is a Java application built with Spring Boot as part of a programming test for a company. The application allows users to manage tasks through a RESTful API, implementing CRUD operations with validation and database integration.*

***

## Requirements

#### To run and develop this project, ensure you have the following installed:

- *Java 23*
- *Maven 4.0.0*
- *Spring Boot 3.4.0*
***

## Features

- *RESTful API for task management*
- *CRUD operations for tasks (Create, Read, Update and Delete)*
- *Validation using @Valid*

***

## Dependencies

- *Spring Boot DevTools*
- *Spring Web*
- *Spring Data JPA*
- *PostgreSQL Driver*
- *Validation*
- *Lombok*

***

## Installation

Clone the repository: https://github.com/Espadas450/Taskify.git

Run the app: ``mvn spring-boot:run``

Test the endpoint: http://localhost:8080/health

***

## API Endpoints

GET ```/api/tasks``` - Retrieve all Task

GET ```/api/tasks/{id}``` - Retrieve a Task by id

POST ```/api/tasks``` - Create a Task

**Request Body**

    {
    "title": "Generic title",
    "description": "This is a generic description....",
    "status": "Pending"
    }

PUT ```/api/tasks/{id}``` - Update a Task

DELETE ```/api/tasks/{id}``` - Delete a Task

***

## Validations

**Title** - Must not be empty or null.

**Description** - Optional.

**Status** - Must not be empty or null.

## Taskify Collection tested in Postman

URL: https://documenter.getpostman.com/view/38917051/2sAYHzFht8

***

# Data base integration

## Configuration

This project uses PostgreSQL as the database to store task information. Make sure you have PostgreSQL installed and running before starting the application.

## Connection Credentials

The database connection is configured in the ```application.properties``` file located in ```src/main/resources.``` These are the properties used:

```spring.datasource.url=jdbc:postgresql://localhost:5432/taskify
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=123qweasdzxc

spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
```

URL: ```jdbc:postgresql://localhost:5432/taskify``` Make sure the database name is ``taskify``.

Username: ```postgres``` (you can change it according to your configuration).

Password: ```123qweasdzxc``` (change it according to your PostgreSQL configuration).

## Schema.sql file:

The ``schema.sql`` file, located in ``src/main/resources``, defines the schema of the table used in the application. This file ensures that the database schema is consistent:

```
CREATE TABLE IF NOT EXISTS task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL
);
```

``id``: Automatically generated primary key.

``title``: Title of the task, **required**.

``description``: Description of the task.

``status``: Status of the taskn **required** (Example: **Pending**, **Completed**).

## How to Initialize the Database

Clone the repository and navigate to the project root directory.

Verify that PostgreSQL is running and that the credentials in application.properties are correct.

Run the application with:

``mvn spring-boot:run``

## Checking

You can check the table in your database using tools such as PgAdmin or the PostgreSQL command line with:

``SELECT * FROM task;``

***

# Author

**Sajid Arturo Espadas Rodríguez**