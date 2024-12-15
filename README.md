# Taskify - Task Management System

*Taskify is a Java application built with Spring Boot as part of a programming test for a company. The application allows users to manage tasks through a RESTful API, implementing CRUD operations with validation and database integration.*

***

## Requirements

#### To run and develop this project, ensure you have the following installed:

- *Java 23*
- *Maven 4.0.0*
- *Spring Boot 3.4.0*
- 
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

Run the app: **mvn spring-boot:run**

Test the endpoint: http://localhost:8080/health

***

## API Endpoints

GET */api/tasks* - Retrieve all Task

GET */api/tasks/{id}* - Retrieve a Task by id

POST */api/tasks* - Create a Task

**Request Body**

    {
    "title": "Generic title",
    "description": "This is a generic description....",
    "status": "Pending"
    }

PUT */api/tasks/{id}* - Update a Task

DELETE */api/tasks/{id}* - Delete a Task

***

## Validations

**Title** - Must not be empty or null.

**Description** - Optional.

**Status** - Must not be empty or null.

## Taskify Collection tested in Postman

URL: https://documenter.getpostman.com/view/38917051/2sAYHzFht8