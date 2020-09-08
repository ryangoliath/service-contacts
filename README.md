
# service-contacts

This is a Spring Boot micro-service, which provides you with a REST API to perform Create/Read/Update/Delete operations on customer and supplier information.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

* Java 1.8
* Git
* Maven
* MySQL

### API Documentation
The API documentation for this project can be found here: [Swagger API](https://app.swaggerhub.com/apis/ryangoliath/service-contacts/1.0.0)

### Installing

1. Clone the project:
```
git clone https://github.com/ryangoliath/service-contacts.git
```
##
2. Build (Maven)
Running the following maven build command will generate a jar file called *service-contacts.jar* in a generated *target* directory. 
```
mvn install
```
##
3. Contacts Database (MySQL)
Before you start the application, ensure that you create a `Contacts` database in your local MySQL instance. You are free to change this database name, as long as you provide custom application properties, as per point 4 below. Tables are auto-generated on start-up, therefore not requiring any additional configuration.
```
create database Contacts;
```
##
4. (Optional) You are welcome to create an *application.properties* file in the directory of the *service-contacts.jar* to configure custom application properties. The default properties are:
```
spring.application.name: Contacts Service
spring.datasource.url: jdbc:mysql://localhost:3306/Contacts
spring.datasource.username: root
spring.datasource.password: root
spring.jpa.hibernate.ddl-auto: update
```
Example file structure:
```
-rw-rw-r-- 1 ryan ryan     0 Sep 9 01:00 application.properties
-rw-rw-r-- 1 ryan ryan 18379 Sep 9 01:00 service-contacts-0.0.1-SNAPSHOT.jar
```
##
5. Run
The maven build would have generated a jar file called *service-contacts-0.0.1-SNAPSHOT.jar* in the *target* directory. Execute the jar using the standard jar exection command:
```
java -jar service-contacts-0.0.1-SNAPSHOT.jar
```

## Built With

* Java 1.8
* Spring Boot
* Maven
* Swagger
* MapStruct

## Author

* **Ryan Goliath** - [GoliathDev](http://goliathdev.com)
