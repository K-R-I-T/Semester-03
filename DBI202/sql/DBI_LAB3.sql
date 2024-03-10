CREATE DATABASE DBI202_LAB3
USE DBI202_LAB3

-- 1. Write a SQL statement to create a table product including columns pro_id, pro_name, pro_price.
CREATE TABLE products(
pro_id VARCHAR(4) PRIMARY KEY,
pro_name VARCHAR(40),
pro_price FLOAT(10),
cate_id VARCHAR(4)
);
-- 2. Write a SQL statement to create a table category including columns cate_id, cate_name.
CREATE TABLE category (
cate_id VARCHAR(4) PRIMARY KEY,
cate_name VARCHAR(40)
);
-- 3. Implementation a relationship between product table and category.
ALTER TABLE products
	add CONSTRAINT PK_PRODUCT_cateID_CATEGORY
		FOREIGN KEY (cate_id) REFERENCES category(cate_id)
-- 4. Using SQL statement to insert 7 rows for every table.
INSERT INTO [products] VALUES('P001', N'Điều hòa', '1000000', 'C001')
INSERT INTO [products] VALUES('P002', N'Máy sấy', '300000', 'C002')
INSERT INTO [products] VALUES('P003', N'Quạt', '300000', 'C003')
INSERT INTO [products] VALUES('P004', N'Máy giặt', '500000', 'C003')
INSERT INTO [products] VALUES('P005', N'Ti vi', '1500000', 'C004')
INSERT INTO [products] VALUES('P006', N'Máy Tính', '2000000', 'C005')
INSERT INTO [products] VALUES('P007', N'Wifi', '700000', 'C006')

INSERT INTO [category] VALUES('C001', 'A')
INSERT INTO [category] VALUES('C002', 'B')
INSERT INTO [category] VALUES('C003', 'C')
INSERT INTO [category] VALUES('C004', 'D')
INSERT INTO [category] VALUES('C005', 'E')
INSERT INTO [category] VALUES('C006', 'F')
INSERT INTO [category] VALUES('C007', 'G')
-- 5. Using SQL statement to select all product that the price is 700.000$
SELECT * FROM products
WHERE pro_price = 700000;