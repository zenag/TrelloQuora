Database Schema
The database schema required for the project is designed and provided, as shown in the following image.

<img src="images/upgrad.jpg"/>

You need to manually create a database named "quora" in your PostgreSQL and run the SQL queries against the database provided in the stub file by activating the profile setup.
You need to update the environment variables such as server port, database name, database password in localhost.properties file in the folder located in quora-db/src/main/resources/config to integrate the database into your system with the project.
Let us recall the concept of the foreign key when a column in a table references the primary key of some other table for its reference. The table containing the primary key is a parent table and the child table contains a foreign key. When a table is related by some other table in the database and you try to delete a record from the parent table, what will happen? PostgreSQL gives the following option:
DELETE CASCADE - In this case, all the referenced records in the child table will be deleted first and then the parent record will be deleted.



In the Quora project, we have used DELETE CASCADE option to delete all the referenced records in the child table first and then the record in the parent table. You can use @OnDelete(action = OnDeleteAction.CASCADE) annotation in JPA to specify the foreign key attribute in the Java class for DELETE CASCADE option.



Project Structure
The project must follow a definite structure in order to help the co-developers and reviewers for easy understanding. Also, the better project structure makes your code modular and it becomes easier to implement any new features on the existing application. Follow the directory structure given in the project stub file. The main module is divided into three sub-modules —  quora-api, quora-db, and quora-service.



1. quora-api

config - This directory must consist of all the required configuration files of the project (if any). We have already provided swagger config file in the stub.
controller - This directory must consist of all the controller classes required for the project (the list of required controllers along with the API endpoints are listed in the next segment).

exception - This directory must consist of the exception handlers for all the exceptions. You have to implement the code for exception handler for all the exceptions to be implemented in the project.

endpoints - This directory consists of the JSON files which are used to generate the Request and Response models.

test - This directory consists of tests for all the controller classes. You need to uncomment all the given test cases to run these test cases after implementing the project.



2. quora-db

config - This directory consists of the database properties and environment properties for local development.
sql - This directory consists of all the SQL queries to create database schema tables.


3. quora-service

business - This directory must consist of all the implementations of the business logic of the application.
dao - This directory allows us to isolate the application/business layer from the persistence layer and must consist of the implementation of all the data access object classes.
entity - This directory must consist of all the entity classes related to the project to map these class objects with the database. You need to observe the database schema and all the constraints given in SQL files carefully to map Java objects with the database.
exception - This directory consists of all the exceptions related to the project. All the exceptions required for the project have been implemented in the stub file.


Authentication and Authorization
The authentication functionality should be implemented in such a way that the API endpoints are accessible only when a user successfully logs in to the endpoint '/user/signin'. In such a case, the user should be able to subsequently access the endpoints by providing only the access token to each endpoint. Also, the user will have access to the endpoints defined in the 'AdminController' class based on the role information provided in the database, as defined below:

If the role of a user is 'admin', the user will be able to access all the API endpoints in the web application.

If the role of a user is 'nonadmin', the user cannot access the API endpoints defined in the AdminController class; he/she can, however, access the rest of the API endpoints defined in the other controller classes.