# Todo-App

# My First Web App (Spring Boot)
A simple Spring Boot web application that demonstrates a classic MVC stack with authentication and a Todo management flow. It’s suitable for learning and small demos.

## Highlights
- Spring Boot application with MVC controllers and JSP views
- Authentication and basic session-based login flow
- Todo management: list, create, update, delete
- Persistence via Spring Data JPA and a repository layer
- Database schema/data bootstrap using application configuration and SQL seed scripts

## Tech Stack
- Java 17 (JDK 17)
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- JSP views (under WEB-INF for server-side rendering)
- Maven

## Prerequisites
- Java 24 installed and on your PATH
- Maven 3.9+ (or use the provided Maven Wrapper: mvnw/mvnw.cmd)

Verify versions:
``` bash
# Bash
java -version
mvn -v
```
## Getting Started
1. Build
``` bash
# Bash
mvn clean package
```
1. Run (choose one)
``` bash
# Run from sources
mvn spring-boot:run

# Or run the packaged jar
java -jar target/myfirstwebapp-*.jar
```
1. Open in your browser
``` text
http://localhost:8080
```
Note: The default port and other settings can be adjusted in application.properties.
## Authentication
The application is secured using Spring Security. User details and access rules are defined in the security configuration and/or externalized in application.properties. Adjust credentials and roles according to your needs. If you don’t see a login screen, ensure security is enabled and correctly configured.
## Persistence and Data
- The app uses Spring Data JPA for persistence.
- Database settings (dialect, URL, DDL strategy, etc.) are configured in application.properties.
- An optional data.sql file is used to seed initial data on startup (if enabled by your Spring Boot configuration).

If you connect to a different database, update application.properties accordingly and ensure the driver is on the classpath.
## Project Layout (high level)
- Controllers: Web endpoints for login, welcome, and Todo management
- Services: Business logic (e.g., authentication, Todo operations)
- Repositories: Spring Data JPA repository interfaces
- Entities/Models: Domain objects (e.g., Todo)
- Views: JSP pages under META-INF/resources/WEB-INF.jsp (includes shared fragments)

## Configuration
Edit src/main/resources/application.properties to customize:
- Server port and context-path
- Datasource settings (URL, username, password, driver)
- JPA/Hibernate behavior (DDL auto, show SQL)
- Security-related properties

Example commands:
``` bash
# Run with an overridden port
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```
## Common Tasks
- Run unit tests:
``` bash
mvn test
```
- Rebuild and run:
``` bash
mvn clean package
java -jar target/myfirstwebapp-*.jar
```
## Troubleshooting
- JSP-related errors: Ensure JSP support is correctly enabled and that views are under WEB-INF so they aren’t served directly.
- Login issues: Check your security configuration and any in-memory or persistent user setup.
- Database errors: Verify datasource URL/credentials and any schema initialization settings. If using initialization scripts, confirm data.sql compatibility with your database.

## Contributing
Issues and pull requests are welcome. Please:
- Keep changes focused and well-documented.
- Include tests where applicable.
- Follow conventional Spring Boot project structure and code style.

## License
This project is provided as-is for learning and demonstration purposes. If you intend to use it in production, review and add an appropriate license file.
