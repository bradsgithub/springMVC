This project contains a Spring-based RESTful web application that manages user registrations.  A user registration consists of a username, an email address, and the date the user registered.  There are REST endpoints to add, delete, and get registered users.  This version of the project stores the users in a simple in-memory data store (in an object).  A future version may utilize Hibernate or JdbcTemplate to write to a data store such as mysql.  Unit tests are included but not integration tests in this version of the project as no persistent store is used.

The assumption is that the username, email address, and the date the user registered are all stored as a Java String for simplicity.

This project was written in Java 7 and using the Spring framework in conjunction with REST and the associated annotations (@RestController etc ...). JUnit 4 and Mockito were used for the unit tests.  Maven was used as the build and dependency management tool.

A future version of this project could utilize other maven plugins like Cobertura to display graphically the code coverage and branch coverage from the Junit tests.
