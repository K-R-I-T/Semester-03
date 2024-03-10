CREATE DATABASE OnlineShop3;

GO

USE OnlineShop3;

GO

CREATE TABLE Users (
  user_id int PRIMARY KEY IDENTITY (1, 1),
  first_name nvarchar(50) NOT NULL,
  last_name nvarchar(50) NOT NULL,
  email varchar(100) NOT NULL UNIQUE,
  password varchar(100) NOT NULL,
  phone varchar(20) NOT NULL UNIQUE,
  address nvarchar(200) NOT NULL,
  date_created datetime NOT NULL DEFAULT GETDATE(),
);

CREATE TABLE Categories (
  category_id int PRIMARY KEY IDENTITY (1, 1),
  name nvarchar(50) NOT NULL,
  description ntext NOT NULL
);

CREATE TABLE Product (
  product_id int PRIMARY KEY IDENTITY (1, 1),
  name nvarchar(100) NOT NULL,
  description ntext NOT NULL,
  price int NOT NULL,
  image nvarchar(200) NOT NULL,
  SIZE nvarchar(50) NOT NULL,
  color nvarchar(50) NOT NULL,
  stock int NOT NULL,
  category_id int NOT NULL,
  FOREIGN KEY (category_id) REFERENCES Categories (category_id)
);

CREATE TABLE [Order] (
  order_id int PRIMARY KEY IDENTITY (1, 1),
  user_id int NOT NULL,
  total_price int NOT NULL,
  shipping_address nvarchar(200) NOT NULL,
  status nvarchar(50) NOT NULL,
  date_created datetime NOT NULL DEFAULT GETDATE(),
  FOREIGN KEY (user_id) REFERENCES Users (user_id),
);

CREATE TABLE Order_item (
  order_item_id int PRIMARY KEY IDENTITY (1, 1),
  order_id int NOT NULL,
  product_id int NOT NULL,
  quantity int NOT NULL,
  FOREIGN KEY (order_id) REFERENCES [Order] (order_id),
  FOREIGN KEY (product_id) REFERENCES Product (product_id)
);

CREATE TABLE Payment (
  payment_id int PRIMARY KEY IDENTITY (1, 1),
  order_id int NOT NULL,
  payment_method varchar(50) NOT NULL,
  total_amount int NOT NULL,
  status nvarchar(50) NOT NULL,
  date_created datetime NOT NULL DEFAULT GETDATE(),
  FOREIGN KEY (order_id) REFERENCES [Order] (order_id)
);

INSERT INTO Users (first_name, last_name, email, password, phone, address)
  VALUES (N'Nguyễn', N'Văn A', 'nguyenvana@example.com', HASHBYTES('SHA1', 'nguyenvana'), '0987654321', N'123 Đường 1'),
  (N'Trần', N'Thị B', 'tranthib@example.com', HASHBYTES('SHA1', 'tranthib'), '0987654322', N'123 Đường 2'),
  (N'Lê', N'Văn C', 'levanc@example.com', HASHBYTES('SHA1', 'levanc'), '0987654323', N'123 Đường 3'),
  (N'Phạm', N'Thị D', 'phamthid@example.com', HASHBYTES('SHA1', 'phamthid'), '0987654324', N'123 Đường 4'),
  (N'Hoàng', N'Văn E', 'hoangvane@example.com', HASHBYTES('SHA1', 'hoangvane'), '0987654325', N'123 Đường 5'),
  (N'Nguyễn', N'Thị F', 'nguyenthif@example.com', HASHBYTES('SHA1', 'nguyenthif'), '0987654326', N'123 Đường 6'),
  (N'Trần', N'Văn G', 'tranvang@example.com', HASHBYTES('SHA1', 'tranvang'), '0987654327', N'123 Đường 7'),
  (N'Lê', N'Thị H', 'lethih@example.com', HASHBYTES('SHA1', 'lethih'), '0987654328', N'123 Đường 8'),
  (N'Phạm', N'Văn I', 'phamvani@example.com', HASHBYTES('SHA1', 'phamvani'), '0987654329', N'123 Đường 9'),
  (N'Hoàng', N'Thị K', 'hoangthik@example.com', HASHBYTES('SHA1', 'hoangthik'), '0987654330', N'123 Đường 10');

INSERT INTO Categories (name, description)
  VALUES (N'Quần jean', N'Rất đẹp'),
  (N'Áo khoác', N'Sản phẩm mới'),
  (N'Áo thun', N'Sản phẩm mới'),
  (N'Áo sơ mi', N'Sản phẩm mới'),
  (N'Quần thể thao', N'Sản phẩm mới'),
  (N'Váy', N'Sản phẩm mới'),
  (N'Chân váy', N'Sản phẩm mới'),
  (N'Phụ kiện', N'Sản phẩm mới'),
  (N'Mũ', N'Sản phẩm mới');

INSERT INTO Product (name, description, price, image, size, color, stock, category_id)
  VALUES (N'Áo thun tay lỡ trơn', N'Cơ bản, Hàn Quốc, Tối giản', 150000, 'https://bizweb.dktcdn.net/thumb/large/100/415/697/products/den2-1663927933961.jpg', 'M', N'Trắng', 10, 3),
  (N'Áo sơ mi tay ngắn', N'Cơ bản, Hàn Quốc, Tối giản', 200000, 'https://bizweb.dktcdn.net/thumb/large/100/415/697/products/den2-1663927933961.jpg', 'M', N'Đen', 10, 4),
  (N'Áo Croptop dáng rộng', N'Cơ bản, Hàn Quốc, Tối giản', 150000, 'https://bizweb.dktcdn.net/thumb/large/100/415/697/products/den2-1663927933961.jpg', 'M', N'Trắng', 10, 3),
  (N'Quần thể thao dài', N'Tối giản', 300000, 'https://bizweb.dktcdn.net/thumb/large/100/415/697/products/den2-1663927933961.jpg', 'M', N'Đen', 10, 5),
  (N'Băng đô cài đầu hình gấu', N'Đơn giản,  Dễ thương', 15000, 'https://bizweb.dktcdn.net/thumb/large/100/415/697/products/den2-1663927933961.jpg', 'M', N'Trắng', 10, 8),
  (N'Mũ đi biển rộng vành', N'Tối giản', 75000, 'https://bizweb.dktcdn.net/thumb/large/100/415/697/products/den2-1663927933961.jpg', 'M', N'Trắng', 10, 9);

INSERT INTO [Order] (user_id, total_price, shipping_address, status)
  VALUES (1, 500000, N'123 Đường 1', N'Hoàn tất'),
  (2, 1200000, N'123 Đường 2', N'Đang vận chuyển'),
  (3, 75000, N'123 Đường 3', N'Hoàn tất');

INSERT INTO Payment (order_id, payment_method, total_amount, status)
  VALUES (1, 'Cash', 500000, N'Hoàn tất'),
  (2, 'Banking', 1200000, N'Hoàn tất'),
  (3, 'Banking', 75000, N'Hoàn tất');

INSERT INTO Order_item (order_id, product_id, quantity)
  VALUES (1, 1, 2),
  (1, 2, 1),
  (2, 3, 5),
  (2, 1, 3),
  (3, 6, 1);

GO

-- Create trigger when input product price < 0
CREATE TRIGGER Check_price
ON Product
AFTER INSERT, UPDATE
AS
	DECLARE @price int
		SELECT @price = price FROM INSERTED
	IF (@price < 1)
	BEGIN
		PRINT 'Price must be greater than 1'
		ROLLBACK TRANSACTION
	END

GO

-- Create trigger when input category is not found
CREATE TRIGGER Check_category
ON Product
AFTER INSERT, UPDATE
AS
	DECLARE @category int
		SELECT @category = category_id FROM INSERTED
	IF NOT EXISTS (SELECT 1 FROM Categories WHERE category_id = @category)
	BEGIN
		PRINT 'This product category is not found'
		ROLLBACK TRANSACTION
	END

GO

-- Create trigger when input user email is not valid
CREATE TRIGGER Check_email
ON Users
AFTER INSERT, UPDATE
AS
	DECLARE @email nvarchar
		SELECT @email = email FROM INSERTED
	IF (@email <> '' AND @email NOT LIKE '_%@__%.__%')
	BEGIN
		PRINT 'This email is not valid'
		ROLLBACK TRANSACTION
	END

GO

-- Create procedure update price
CREATE PROCEDURE Update_price @product_id int, @new_price int
AS
	BEGIN
		UPDATE Product SET price = @new_price WHERE product_id = @product_id
	END

GO

-- Create procedure delete product
CREATE PROCEDURE Delete_product @product_id int
AS
	BEGIN
		IF EXISTS (SELECT 1 FROM Product WHERE product_id = @product_id)
			DELETE FROM Product WHERE product_id = @product_id
		ELSE
			PRINT 'Delete failed'
	END

GO

-- Create function view order of a customer
CREATE FUNCTION View_customer_orders (@user_id int)
RETURNS TABLE
AS
RETURN
	SELECT u.user_id, u.first_name, u.last_name, o.order_id, o.total_price, o.status, o.date_created
	FROM Users u, [Order] o
	WHERE u.user_id = @user_id AND u.user_id = o.user_id

GO

-- Create procedure update product stock
CREATE PROCEDURE Update_product_stock @product_id int, @quantity_sold int
AS
	BEGIN
		UPDATE Product SET stock = stock - @quantity_sold WHERE product_id = @product_id
	END

GO

-- Create function to calculate revenue of category
CREATE FUNCTION calculate_category_revenue (@category_id INT)
RETURNS DECIMAL(10,2)
AS
BEGIN
    DECLARE @total_revenue DECIMAL(10,2)
    SELECT @total_revenue = SUM(total_price)
    FROM (
        SELECT oi.quantity * p.price AS total_price FROM order_item oi
        JOIN Product p ON oi.product_id = p.product_id
        WHERE p.category_id = @category_id
    ) AS revenue_table
    RETURN @total_revenue
END