# PetCare+ — Pet Care Management System

## Project Overview
PetCare+ is a Java Full Stack web application designed to help pet owners manage their pets' information, healthcare records, and reminders.

## Technologies Used
- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA and Hibernate
- **Build Tool:** Maven
- **API:** REST APIs

## Features
- Add, view, update, and delete pet profiles
- Maintain pet healthcare records
- Create and manage reminders for pet care
- Mark reminders as completed
- Store application data in MySQL

## Backend Structure
- `controller` — Handles REST API requests
- `model` — Defines the application's data entities
- `repository` — Communicates with the database
- `PetCarePlusApplication.java` — Main Spring Boot application class

## API Endpoints
- `/api/pets` — Pet profile operations
- `/api/records` — Healthcare record operations
- `/api/reminders` — Reminder operations

## Running the Project
1. Install Java 17 or a compatible configured JDK and MySQL.
2. Create or configure the `petcare_plus` database.
3. Configure your database credentials in the local application configuration.
4. Run the project using Maven or an IDE such as VS Code or Eclipse.

## Frontend
The frontend is maintained separately in the [PetCarePlus-Frontend repository](https://github.com/sana29-sa/PetCarePlus-Frontend).
