CREATE DATABASE SE170330_ASSIGNMENT
USE SE170330_ASSIGNMENT
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS loan;

CREATE TABLE category(
	categoryID varchar(10) NOT NULL PRIMARY KEY,
	categoryName varchar(255) NOT NULL,
);

CREATE TABLE book(
	bookID varchar(10) NOT NULL PRIMARY KEY,
	bookTitle varchar(50) NOT NULL,
	bookPublisher varchar(50) NOT NULL,
	bookAuthor varchar (50) NOT NULL,
	bookPageNumber int NOT NULL,
	bookCopy int NOT NULL,
	bookPrice REAl NOT NULL,
	categoryID varchar(10) NOT NULL FOREIGN KEY REFERENCES category(categoryID),
	inputDate varchar (10) NOT NULL,
	bookPlacement varchar (255) NOT NULL,
);



CREATE TABLE student(
	studentID varchar(10) NOT NULL PRIMARY KEY,
	studentName varchar(255) NOT NULL,
	expiredDate varchar(10) NOT NULL,
	studentMajor varchar (20) NOT NULL,
	studentEmail varchar (255) NOT NULL,
	studentPhone varchar (30) NOT NULL,
);

CREATE TABLE loan(
	loanID varchar (10) PRIMARY KEY,
	bookID varchar (10) NOT NULL FOREIGN KEY REFERENCES book(bookID),
	studentID varchar(10) NOT NULL FOREIGN KEY REFERENCES student(studentID),
	dateBorrowes varchar (10) NOT NULL,
	dateReturn varchar (10) NOT NULL,
);