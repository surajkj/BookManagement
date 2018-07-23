# BookManagement

## Run Steps

1. Download project
2. Run Sql script
3. Open project in eclipse & update maven
4. Right click on project -> run as java application
5. Select BookmanagementApplication file if prompted

## User API

GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/user```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Gets all User details

GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/user/{userId}```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Gets User details of given userId

POST &nbsp;&nbsp;&nbsp;&nbsp;```/user```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Add User

POST &nbsp;&nbsp;&nbsp;&nbsp;```/user/validate```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Validate Password of user

PUT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/user```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Update User

PUT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/user/changepassword```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Update User Password

DELETE &nbsp;&nbsp;```/user/{userId}```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Delete given user

## Book API

GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/{userid}/book```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Gets all books of given user

GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/{userid}/book/{bookId}```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Gets book details of given book id

POST &nbsp;&nbsp;&nbsp;```/{userid}/book```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Add Book for given user

PUT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/{userid}/book```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Update book with given Id

DELETE &nbsp;&nbsp;```/{userid}/book/{bookId}```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Delete given book

## Library API

GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/{userid}/library```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Gets all library of given user

GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/{userid}/library/{libraryId}```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Gets given library details and all books in it

POST &nbsp;&nbsp;&nbsp;```/{userid}/library```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Create library for given user

PUT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/{userid}/library```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Update library details with given id

DELETE &nbsp;&nbsp;```/{userid}/library/{libraryId}```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Delete given library id

## Book Library API

GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/{userid}/librarybook/```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Get all Libraries with books in it

GET &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```/{userid}/librarybook/{libraryId}```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Get Books in given Library

POST &nbsp;&nbsp;&nbsp;```/{userid}/librarybook```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Add book to the given library

DELETE &nbsp;&nbsp;```/{userid}/librarybook/{libraryBookId}```&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp; Delete given book from given library