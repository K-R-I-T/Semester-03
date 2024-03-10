CREATE DATABASE BOOK_MANAGEMENT
USE BOOK_MANAGEMENT
-- CREATE NEW TABLES
CREATE TABLE Book(
	BookID CHAR(4) PRIMARY KEY,
	BookTitle NVARCHAR(50) NOT NULL UNIQUE,
	BookPublisherID CHAR(6),
	BookAuthorID CHAR(5),
	BookPageNum INT CHECK (BookPageNum > 5),
	BookQuantity INT CHECK (BookQuantity > 1),
	BookPrice FLOAT CHECK (BookPrice > 0),
	InputDate DATETIME2(0),
	BookPlaceID CHAR(1),
	BookTypeID CHAR(3)
)

CREATE TABLE Book_Publisher(
	PublisherID CHAR(6) PRIMARY KEY,
	PulisherName NVARCHAR(50) NOT NULL UNIQUE
)

CREATE TABLE Book_Author(
	AuthorID CHAR(5) PRIMARY KEY,
	AuthorName NVARCHAR(50) NOT NULL UNIQUE
)

CREATE TABLE Book_Shelf(
	ShelfID CHAR(1) PRIMARY KEY,
	ShelfName NVARCHAR(50) NOT NULL UNIQUE
)

CREATE TABLE Book_Type(
	TypeID CHAR(3) PRIMARY KEY,
	TypeName NVARCHAR(50) NOT NULL UNIQUE
)

CREATE TABLE Student(
	StudentID CHAR(4) PRIMARY KEY,
	StudentName NVARCHAR(50) NOT NULL UNIQUE,
	DateValue DATETIME2(0),
	StudentMajorID CHAR(2),
	StudentEmail NVARCHAR(255),
	StudentPhoneNum NVARCHAR(20)
)

CREATE TABLE Student_Major(
	MajorID CHAR(2) PRIMARY KEY,
	MajorName NVARCHAR(50) NOT NULL UNIQUE
)

CREATE TABLE Borrow_Book(
	BorrowID CHAR(5) PRIMARY KEY,
	BookID CHAR(4),
	StudentID CHAR(4),
	DateBorrow DATETIME2(0),
	DateReturn DATETIME2(0),
	BorrowStatus NVARCHAR(10) CHECK (BorrowStatus IN ('Borrowing', 'Returned', 'Overdue'))
)

-- INPUT DATA INTO TABLES

-- BOOK
INSERT INTO Book
	VALUES('B001', N'Cơ sở dữ liệu cơ bản', 'PL0001', 'A0001', '54', '10', '89000', '2015-01-04 07:13:20', '1', 'DBI')
INSERT INTO Book
	VALUES('B002', N'Tiếng Nhật Sơ cấp', 'PL0005', 'A0003', '96', '5', '50000', '2015-05-24 15:24:19', 'G', 'JPD')
INSERT INTO Book
	VALUES('B003', N'Làm chủ kỹ năng lập trình', 'PL0003', 'A0002', '120', '7', '120000', '2015-01-01 20:03:12', '2', 'LAB')
INSERT INTO Book
	VALUES('B004', N'Từ vựng tiếng Nhật', 'PL0002', 'A0003', '60', '5', '40000', '2015-05-24 15:23:53', 'G', 'JPD')
INSERT INTO Book
	VALUES('B005', N'Hệ điều hành máy tính', 'PL0001', 'A0005', '159', '3', '100000', '2015-05-21 21:16:23', '5', 'OSG')
INSERT INTO Book
	VALUES('B006', N'Tìm hiểu về IT', 'PL0004', 'A0004', '140', '7', '120000', '2015-02-14 18:52:31', '3', 'IT')
INSERT INTO Book
	VALUES('B007', N'Thiết kế SQL', 'PL0005', 'A0002', '113', '4', '130000', '2015-01-22 14:33:23', '4', 'DBI')
INSERT INTO Book
	VALUES('B008', N'Ứng dụng SQL với Java', 'PL0003', 'A0001', '75', '2', '99000', '2015-01-23 11:12:39', '4', 'LAB')
INSERT INTO Book
	VALUES('B009', N'Vừa lười vừa bận vẫn giỏi tiếng Anh', 'PL0007', 'A0006', '120', '9', '100000', '2015-01-12 22:31:11', '2', 'ENG')
INSERT INTO Book
	VALUES('B010', N'Làm chủ môn Toán', 'PL0009', 'A0010', '200', '10', '125000', '2015-01-09 09:11:21', '5', 'MAT')

-- BOOK PUBLISHER
INSERT INTO Book_Publisher
	VALUES('PL0001', N'Nhà Xuất Bản Trẻ')
INSERT INTO Book_Publisher
	VALUES('PL0002', N'Nhà Xuất Bản Kim Đồng')
INSERT INTO Book_Publisher
	VALUES('PL0003', N'Nhà Xuất Bản Lao Động')
INSERT INTO Book_Publisher
	VALUES('PL0004', N'Nhã Nam')
INSERT INTO Book_Publisher
	VALUES('PL0005', N'Đông A')
INSERT INTO Book_Publisher
	VALUES('PL0006', N'Nhà xuất bản Phụ nữ Việt Nam')
INSERT INTO Book_Publisher
	VALUES('PL0007', N'Đinh Tị Books')
INSERT INTO Book_Publisher
	VALUES('PL0008', N'Nhà xuất bản Hội Nhà văn')
INSERT INTO Book_Publisher
	VALUES('PL0009', N'Nhà xuất bản Tổng hợp thành phố Hồ Chí Minh')

-- BOOK AUTHOR
INSERT INTO Book_Author
	VALUES('A0001', N'Jonh Willson')
INSERT INTO Book_Author
	VALUES('A0002', N'David Ruly')
INSERT INTO Book_Author
	VALUES('A0003', N'Mazakuni Hasashi')
INSERT INTO Book_Author
	VALUES('A0004', N'Benza Smith')
INSERT INTO Book_Author
	VALUES('A0005', N'Donal Wick')
INSERT INTO Book_Author
	VALUES('A0006', N'Nguyễn Văn Huỳnh')
INSERT INTO Book_Author
	VALUES('A0007', N'Phạm Ngọc Huy')
INSERT INTO Book_Author
	VALUES('A0008', N'Lê Thị Xàm')
INSERT INTO Book_Author
	VALUES('A0009', N'Hồ Thị Xuôi')
INSERT INTO Book_Author
	VALUES('A0010', N'Yasu Ouu')

-- BOOK SHELF
INSERT INTO Book_Shelf
	VALUES('G', N'Tầng Trệt')
INSERT INTO Book_Shelf
	VALUES('1', N'Tầng Một')
INSERT INTO Book_Shelf
	VALUES('2', N'Tầng Hai')
INSERT INTO Book_Shelf
	VALUES('3', N'Tầng Ba')
INSERT INTO Book_Shelf
	VALUES('4', N'Tầng Bốn')
INSERT INTO Book_Shelf
	VALUES('5', N'Tầng Năm')

-- BOOK TYPE
INSERT INTO Book_Type
	VALUES('JPD', N'Sách Tiếng Nhật')
INSERT INTO Book_Type
	VALUES('OSG', N'Sách Máy Tính')
INSERT INTO Book_Type
	VALUES('ECN', N'Sách Kinh Tế')
INSERT INTO Book_Type
	VALUES('LAB', N'Sách Thực Hành Lập Trình')
INSERT INTO Book_Type
	VALUES('DBI', N'Sách Cơ Sở Dữ Liệu')
INSERT INTO Book_Type
	VALUES('IT', N'Sách Lý Thuyết Lập Trình')
INSERT INTO Book_Type
	VALUES('ENG', N'Sách Tiếng Anh')
INSERT INTO Book_Type
	VALUES('MAT', N'Sách Toán')

-- STUDENT
INSERT INTO Student
	VALUES('S001', N'Nguyễn Hoàng Đạt', '2025-08-26 23:59:59', 'SE', N'datnhse170330@fpt.edu.vn', N'0966548257')
INSERT INTO Student
	VALUES('S002', N'Đào Hoài Phương','2025-08-28 23:59:59', 'SE', N'phuongdhse170524@fpt.edu.vn', N'0985457216')
INSERT INTO Student
	VALUES('S003', N'Đỗ Thế Hiếu','2025-08-26 23:59:59', 'SE', N'hieudtse170041@fpt.edu.vn', N'0967475325')
INSERT INTO Student
	VALUES('S004', N'Nguyễn Trường Thọ','2025-09-15 23:59:59', 'SE', N'thontse171441@fpt.edu.vn', N'0967456825')
INSERT INTO Student
	VALUES('S005', N'Lê Ngọc Thanh Trúc','2026-08-26 23:59:59', 'GD', N'truclntse184843@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S006', N'Phan Võ Ngọc Phú','2026-08-26 23:59:59', 'SE', N'phupvnse171231@fpt.edu.vn', N'0398821423')
INSERT INTO Student
	VALUES('S007', N'Trần Đăng Dũng','2026-08-26 23:59:59', 'SE', N'dungtdse173412@fpt.edu.vn', N'0316276271')
INSERT INTO Student
	VALUES('S008', N'Phạm Quốc Trung','2026-08-26 23:59:59', 'SE', N'trungpqse175123@fpt.edu.vn', N'0326176583')

-- STUDENT MAJOR
INSERT INTO Student_Major
	VALUES('GD', N'Thiết Kế Mỹ Thuật Số')
INSERT INTO Student_Major
	VALUES('SE', N'Kỹ Thuật Phần Mềm')
INSERT INTO Student_Major
	VALUES('BI', N'Kinh Doanh Quốc Tế')
INSERT INTO Student_Major
	VALUES('MK', N'Marketing')
INSERT INTO Student_Major
	VALUES('SA', N'Ngôn Ngữ')

-- BORROW BOOK
INSERT INTO Borrow_Book
	VALUES('BR001', 'B003', 'S002', '2023-05-23 15:23:12', '2023-06-30 23:59:59', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR002', 'B004', 'S004', '2023-07-01 10:22:47', '2023-08-01 23:59:59', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR003', 'B005', 'S003', '2023-04-25 11:50:44', '2023-05-30 23:59:59', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR004', 'B001', 'S005', '2023-03-01 13:11:51', '2023-04-01 23:59:59', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR005', 'B002', 'S001', '2023-06-01 16:02:32', '2023-06-30 23:59:59', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR006', 'B003', 'S001', '2023-01-23 11:39:42', '2023-02-12 23:59:59', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR007', 'B001', 'S004', '2023-01-12 15:31:14', '2023-02-10 23:59:59', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR008', 'B005', 'S005', '2023-02-01 12:32:51', '2023-02-28 23:59:59', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR009', 'B004', 'S002', '2023-01-31 14:51:16', '2023-03-12 23:59:59', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR010', 'B010', 'S007', '2023-04-11 12:11:12', '2023-05-15 23:59:59', N'Borrowing')

-- CREATE RELATIONSHIP
ALTER TABLE Book
	ADD CONSTRAINT FK_Book_BookPublisherID_Book_Publisher_PublisherID
		FOREIGN KEY (BookPublisherID) REFERENCES Book_Publisher(PublisherID)

ALTER TABLE Book
	ADD CONSTRAINT FK_Book_BookAuthorID_Book_Author_AuthorID
		FOREIGN KEY (BookAuthorID) REFERENCES Book_Author(AuthorID)

ALTER TABLE Book
	ADD CONSTRAINT FK_Book_BookPlaceID_Book_Shelf_ShelfID
		FOREIGN KEY (BookPlaceID) REFERENCES Book_Shelf(ShelfID)
		
ALTER TABLE Book
	ADD CONSTRAINT FK_Book_BookTypeID_Book_Type_TypeID
		FOREIGN KEY (BookTypeID) REFERENCES Book_Type(TypeID)
		
ALTER TABLE Student
	ADD CONSTRAINT FK_Student_StudentMajorID_Student_Major_MajorID
		FOREIGN KEY (StudentMajorID) REFERENCES Student_Major(MajorID)

ALTER TABLE Borrow_Book
	ADD CONSTRAINT FK_Borrow_Book_BookID_Book_BookID
		FOREIGN KEY (BookID) REFERENCES Book(BookID)

ALTER TABLE Borrow_Book
	ADD CONSTRAINT FK_Borrow_Book_StudentID_Student_StudentID
		FOREIGN KEY (StudentID) REFERENCES Student(StudentID)

-- 6.1 Liệt kê tất cả thông tin của các đầu sách gồm tên sách, mã sách, giá tiền , tác giả thuộc loại sách có mã “IT”.

SELECT b.BookTitle, b.BookID, b.BookPrice, a.AuthorName
	FROM Book b
	LEFT JOIN Book_Author a ON b.BookAuthorID = a.AuthorID
	WHERE BookTypeID = 'IT'

-- 6.2 Liệt kê các phiếu mượn gồm các thông tin mã phiếu mượn, mã sách , ngày mượn, mã sinh viên có ngày mượn trong tháng 01/2023.

SELECT BorrowID, BookID, DateBorrow, StudentID
	FROM Borrow_Book
	WHERE DateBorrow >= '2023-01-01 00:00:00' AND DateBorrow < '2023-02-01 00:00:00'

-- 6.3 Liệt kê các phiếu mượn chưa trả sách cho thư viện theo thứ tự tăng dần của ngày mượn sách.

SELECT *
	FROM Borrow_Book
	WHERE BorrowStatus = 'Borrowing'
	ORDER BY DateBorrow ASC

-- 6.4 Liệt kê tổng số đầu sách của mỗi loại sách (gồm mã loại sách, tên loại sách, tổng số lượng sách mỗi loại).

SELECT t.TypeID, t.TypeName, SUM(b.BookQuantity) AS TotalBook
	FROM Book_Type t
	LEFT JOIN Book b ON t.TypeID = b.BookTypeID
	GROUP BY t.TypeID, t.TypeName

-- 6.5 Đếm xem có bao nhiêu lượt sinh viên đã mượn sách.

SELECT COUNT(*) AS [Students Borrowed Books]
	FROM Borrow_Book

-- 6.6 Hiển thị tất cả các quyển sách có tiêu đề chứa từ khoá “SQL”.

SELECT *
	FROM Book
	WHERE BookTitle LIKE '%SQL%'

-- 6.7 Hiển thị thông tin mượn sách gồm các thông tin: mã sinh viên, tên sinh viên, mã phiếu mượn, tiêu đề sách, ngày mượn, ngày trả.
-- Sắp xếp thứ tự theo ngày mượn sách.

SELECT s.StudentID, s.StudentName, br.BorrowID, b.BookTitle, br.DateBorrow, br.DateReturn
	FROM Borrow_Book br
	LEFT JOIN Student s ON br.StudentID = s.StudentID
	LEFT JOIN Book b ON br.BookID = b.BookID
	ORDER BY DateBorrow

-- 6.8 Liệt kê các đầu sách có lượt mượn lớn hơn 20 lần.

SELECT b.BookID, b.BookTitle, COUNT(*) AS Total
	FROM Book b
	LEFT JOIN Borrow_Book br ON b.BookID = br.BookID
	GROUP BY b.BookID, b.BookTitle HAVING COUNT(*) > 20

-- 6.9 Viết câu lệnh cập nhật lại giá tiền của các quyển sách có ngày nhập kho trước năm 2014 giảm 30%.

UPDATE Book
	SET BookPrice = BookPrice * 0.7
	WHERE YEAR(InputDate) < 2014

-- 6.10 Viết câu lệnh cập nhật lại trạng thái đã trả sách cho phiếu mượn của sinh viên có mã sinh viên PD12301 (ví dụ).

UPDATE Borrow_Book
	SET BorrowStatus = 'Returned'
	WHERE StudentID = 'S003'

-- 6.11 Lập danh sách các phiếu mượn quá hạn chưa trả gồm các thông tin: mã phiếu mượn,
-- tên sinh viên, email, danh sách các sách đã mượn, ngày mượn.

SELECT br.BorrowID, s.StudentName, s.StudentEmail, CONCAT(b.BookTitle, ', ') AS BookTitles, br.DateBorrow
	FROM Borrow_Book br
	LEFT JOIN Student s ON br.StudentID = s.StudentID
	LEFT JOIN Book b ON br.BookID = b.BookID
	WHERE br.BorrowStatus = 'Overdue'

-- 6.12 Viết câu lệnh cập nhật lại số lượng bản sao tăng lên 5 đơn vị đối với các đầu sách có lượt mượn lớn hơn 10

UPDATE Book
	SET BookQuantity = BookQuantity + 5
	WHERE BookID IN (
		SELECT b.BookID
			FROM Book b
			LEFT JOIN Borrow_Book br ON b.BookID = br.BookID
			GROUP BY b.BookID HAVING COUNT(*) > 10
	)

-- 6.13 Viết câu lệnh xoá các phiếu mượn có ngày mượn và ngày trả trước ‘1/1/2023’

DELETE FROM Borrow_Book
	WHERE DateBorrow < '2023-01-01 00:00:00'
	OR DateReturn < '2023-01-01 00:00:00'

-- 6.14. Tạo một Trigger cập nhật số lượng sách khi có sinh viên mượn hoặc trả sách



-- SHOW ALL TABLE
SELECT * FROM Book
SELECT * FROM Book_Publisher
SELECT * FROM Book_Author
SELECT * FROM Book_Shelf
SELECT * FROM Book_Type
SELECT * FROM Student
SELECT * FROM Student_Major
SELECT * FROM Borrow_Book

DROP TABLE Book
DROP TABLE Book_Publisher
DROP TABLE Book_Author
DROP TABLE Book_Shelf
DROP TABLE Book_Type
DROP TABLE Student
DROP TABLE Student_Major
DROP TABLE Borrow_Book