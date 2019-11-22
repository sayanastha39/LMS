LMS is a Library Management System application built using java as a programming language.

The application's concern is separated using MVC architecture. It is a design pattern that separates the business logic, presentation logic and data.

1. Entities: Entities package has all the plain old java object classes used in this applications. It has generated constructors, getters, setters, toString, hashCodes methods for increasing the readability and re-usability of a program. 

2. DAO: DAO package has all the dao classes for the application viz. AuthorDAO, PublisherDAO, BookDAO. Methods to read a csv file, write in a file, and convert csv to a string are written in these classes. 

3. Service: Service class package has the service class and controller method that will communicate with both View and DAO. This is where the business logic of the application is written. CRUD operations for different entities are written here. Cacade functionality of SQL is also done in this service class. For example: if we delete an author then the book associated with that author is aloso deleted.

4. UserInterface: This package represents the presenation of the application. Rhe user is able to acess the application only using this part of the java application. In the menu class of this package, the value entered y user is imported and the operation is carried out according to the input and input is verified using multiple switch case statements. 
