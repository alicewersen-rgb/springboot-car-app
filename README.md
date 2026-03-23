# Car Management App

This is a simple web application built with Spring Boot and Thymeleaf, that allows users to manage a collection of cars.

## Features
- List all cars
- Create a new car
- Update an existing car
- Delete a car
- Validation for input fields (name, brand, horsepower, manufacture date, description)

## Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Thymeleaf
- Maven
- H2 Database

## Project Structure
This project uses a standard Spring Boot layered architecture.

### DTO Classes Explanation 
This project follows the **DTO (Data Transfer Object) pattern** to separate the data used in forms from the data displayed in views:
- **CreateCarDTO** – used when creating a new car via the form. Contains validation for required fields.
- **UpdateCarDTO** – used when updating an existing car via the form. Also includes validation rules.
- **CarDTO** – used to display car data in lists and detail views.

Using these DTO classes ensures that the **Entity (CarEntity)** is not directly exposed to the web layer, making the application safer and easier to maintain.