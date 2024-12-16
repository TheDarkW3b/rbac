# Role-Based Access Control System

It's a Spring Boot-based Role-Based Access Control (RBAC) system designed for managing user roles and access permissions. The system supports multiple roles, including **User**, **Moderator**, and **Admin**, with varying levels of access to designated endpoints.

## Features

- **User Registration and Login**.
- Secure JWT authentication and hashed passwords.
- Access control for different roles:
  - User Area
  - Moderator Area
  - Admin Area
  - Admin View All Users
- Predefined API endpoints for role-based access (refer to Postman collection for details).
- Centralized authentication and authorization.

---

## Installation and Setup

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure you have Java 21 or later installed.
2. **Maven**: Ensure Maven is installed and available in your PATH.
3. **MySQL Database**:
   * MySQL must be running on port `3306`.
   * Create a database locally named `rbac`.

### Setup Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/TheDarkW3b/rbac
   cd rbac
   ```
2. Configure the database connection:

   * Open the `src/main/resources/application.yml` file.
   * Ensure the following settings are correctly configured:

     ```yml
     spring:
      datasource:
          url: jdbc:mysql://localhost:3306/rbac
          username: <your_mysql_username>
          password: <your_mysql_password>
      jpa:
          hibernate:
              ddl-auto: update
     ```
3. Build and run the project:
    * If the project is imported in Intellij IDEA use the run button or run commands
      ```bash
      mvn clean install
      mvn spring-boot:run
      ```
4. Import the Postman collection:

    * Locate the [VRVSecurity.postman_collection.json](/VRVSecurity.postman_collection.json) file in the repository.
    * Open Postman and import this file to access pre-configured endpoints.

5. Test the endpoints:

    - Refer to the following endpoint structure in Postman:
        * `POST /api/v1/auth/register`
        * `POST /api/v1/auth/login`
        * `GET /api/v1/user`
        * `GET /api/v1/moderator`
        * `GET /api/v1/admin`
        * `GET /api/v1/admin/view-users`

## Testing
Use the Postman collection to interact with the API and test role-based access. The Postman UI should display the endpoints as shown below:

## Notes
* Ensure MySQL is running and the `rbac` database is created before starting the application.
* Update credentials in `application.yml` as per your local database configuration.

## Video Demonstration
Here's the video demonstration on how to run the project through Intellij IDEA or without it
  * https://drive.google.com/file/d/1WpHEpllSWCv4eaIn4JvhxzsXYSzCb4k-/view?usp=sharing
