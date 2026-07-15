## Project Name
Visitor Log API

## Description

Visitor Log API is a Spring Boot REST API that manages visitor information.

The application allows users to:
- Add new visitors
- View all visitors
- Search for a visitor by ID
- Update visitor information
- Delete visitors
- Count total visitors
- Filter visitors by visit purpose

The project uses an in-memory list to store visitor data while the application is running.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- REST API
- Maven

## API Endpoints

### Get all visitors

**GET**

/api/visitors


Returns a list of all visitors.

---

### Get visitor by ID

**GET**

/api/visitors/{id}


Example:

GET /api/visitors/1


Returns a visitor with the specified ID.

---

### Add a new visitor

**POST**

/api/visitors


Request Body example:

```json
{
    "name": "Walaa",
    "company": "Google",
    "purpose": "Meeting"
}

Creates a new visitor.

Update visitor

PUT

/api/visitors/{id}

Example:

PUT /api/visitors/1

Request Body example:

{
    "name": "Walaa",
    "company": "Microsoft",
    "purpose": "Interview"
}

Updates an existing visitor.

Delete visitor

DELETE

/api/visitors/{id}

Example:

DELETE /api/visitors/1

Deletes a visitor by ID.

Count visitors

GET

/api/visitors/count

Returns the total number of current visitors.

Example response:

{
    "total": 5
}
Filter visitors by purpose

GET

/api/visitors?purpose={purpose}

Example:

GET /api/visitors?purpose=Meeting

Returns visitors matching the given purpose.

How to Run the Project
Requirements

Make sure you have:

Java 17 or higher
Maven installed
IDE such as IntelliJ IDEA or Eclipse
Run using Maven

Open the project folder and run:

mvn spring-boot:run

The application will start on:

http://localhost:8080
Testing

The API can be tested using:

Postman
Browser (for GET requests)

Example:

GET http://localhost:8080/api/visitors
Project Structure
src
 └── main
     └── java
         └── com.example.visitorlog
             ├── controller
             │   └── VisitorController.java
             └── model
                 └── Visitor.java
