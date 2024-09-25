# TodoCRUDappJava
A basic CRUD app made using Spring Boot in Java REST API with h2 memory.

API Endpoints.

1. GET - /users/{userId} - return user info for the specific userId.

2. POST - /users - add the user to the database.

3. POST - /users/{userId}/{todos} - add TODO to the specific user with the given userId.

4. POST - /users/{todos}/{todoId} - toggle the status of Todo. (completed or Not completed).

5. DELETE - /users/{userId} - delete the user with specific userId.

6. DELETE - /users/{userId}/todos/{todoId} - delete the Todo with specific todo Id and userId.

The app is made using Spring Boot, H2 Database, Hibernate and Junit. It is based on MVC architecture, which consists of Model, View and Controller.

The Entities are Users and Todo. The User has a One to Many Mapping with Todo, as a single user can have multiple Todos.

The Service layers is responsible for handling logic.

It makes use of JPA repository to handle CRUD operations.

The App architecture can be understood by this flowchart below.

![alt text](https://i.pinimg.com/originals/69/1c/65/691c65ed531fdbb0037ed5f8192abdd5.jpg)
