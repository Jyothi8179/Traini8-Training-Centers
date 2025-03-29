# Traini8-Training-Centers

## Overview
The **Training Center Management System** is a Spring Boot application that provides REST APIs for managing training centers. It includes functionalities for creating, filtering, and retrieving training centers with validation and exception handling.

## Features
- **Create Training Centers**: Add new training centers with details like name, code, address, capacity, and contact information.
- **Filter Training Centers**: Search and filter training centers based on multiple criteria.
- **Retrieve All Training Centers**: Get a list of all training centers.
- **Exception Handling**: Global exception handling for validation and runtime errors.

## Tech Stack
- **Backend**: Java, Spring Boot, Spring Data JPA
- **Database**: PostgreSQL/MySQL
- **Build Tool**: Maven
- **Validation**: Jakarta Validation API

## Project Structure
```
├── src/main/java/com/traning/center/traini8
│   ├── controller
│   │   ├── TrainingCenterController.java
│   ├── dto
│   │   ├── TrainingCenterFilterDTO.java
│   │   ├── TrainingCenterRequestDTO.java
│   ├── entity
│   │   ├── TrainingCenter.java
│   ├── exception
│   │   ├── GlobalExceptionHandler.java
│   ├── repository
│   │   ├── TrainingCenterRepository.java
│   ├── service
│   │   ├── TrainingCenterService.java
│   ├── specification
│   │   ├── TrainingCenterSpecification.java
│   ├── TrainingCenterApplication.java
├── src/main/resources
│   ├── application.properties
```

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone [<repo-url>](https://github.com/Jyothi8179/Traini8-Training-Centers.git)
   cd training-center-management
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/training_center_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the application:
   ```sh
   mvn clean install&&docker-compose up --build
   ```

## API Endpoints
### 1. Create a Training Center
**POST** `/api/v1/training-center`
```json
{
  "centerName": "ABC Training Center",
  "centerCode": "TC123",
  "address": {
    "city": "New York",
    "state": "NY"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Python"],
  "contactEmail": "contact@abctraining.com",
  "contactPhone": "1234567890"
}
```

### 2. Retrieve All Training Centers
**GET** `/api/v1/training-center`

### 3. Filter Training Centers
**POST** `/api/v1/training-center/filter`
```json
{
  "centerName": "ABC",
  "studentCapacity": 100
}
```

## Exception Handling
- **Validation Errors**: Returns a `400 Bad Request` with error details.
- **General Errors**: Returns a `500 Internal Server Error` with a message.


