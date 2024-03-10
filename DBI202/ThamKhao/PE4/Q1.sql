CREATE DATABASE Q1
GO 

USE Q1
GO

CREATE TABLE itemVariants (
	variantID int PRIMARY KEY,
	detail nvarchar(200),
	color nvarchar(50),
	size nvarchar(30)
)
GO

CREATE TABLE itemID (
	itemID int PRIMARY KEY,
	name nvarchar(255),
	price float,
)
GO

CREATE TABLE categories (
	catID int PRIMARY KEY,
	name nvarchar(255)
)
GO