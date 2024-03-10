CREATE DATABASE ASSIGNMENT_SU23
GO

USE ASSIGNMENT_SU23
GO

-- CREATE NEW TABLES
CREATE TABLE Book(
	BookID CHAR(4) PRIMARY KEY,
	BookTitle NVARCHAR(50) NOT NULL UNIQUE,
	BookPublisherID CHAR(5) FOREIGN KEY REFERENCES Book_Publisher(PublisherID),
	BookAuthorID CHAR(4) FOREIGN KEY REFERENCES Book_Author(AuthorID),
	BookPageNum INT CHECK (BookPageNum > 5),
	BookQuantity INT CHECK (BookQuantity > 1),
	BookPrice FLOAT CHECK (BookPrice > 0),
	InputDate DATE,
	BookShelfID CHAR(1) FOREIGN KEY REFERENCES Book_Shelf(ShelfID),
	BookTypeID CHAR(3) FOREIGN KEY REFERENCES Book_Type(TypeID)
)
GO

CREATE TABLE Book_Publisher(
	PublisherID CHAR(5) PRIMARY KEY,
	PulisherName NVARCHAR(50) NOT NULL UNIQUE
)
GO

CREATE TABLE Book_Author(
	AuthorID CHAR(4) PRIMARY KEY,
	AuthorName NVARCHAR(50) NOT NULL UNIQUE
)
GO

CREATE TABLE Book_Shelf(
	ShelfID CHAR(1) PRIMARY KEY,
	ShelfName NVARCHAR(50) NOT NULL UNIQUE
)
GO

CREATE TABLE Book_Type(
	TypeID CHAR(3) PRIMARY KEY,
	TypeName NVARCHAR(50) NOT NULL UNIQUE
)
GO

CREATE TABLE Student(
	StudentID CHAR(4) PRIMARY KEY,
	StudentName NVARCHAR(50) NOT NULL UNIQUE,
	DateValue DATE,
	StudentMajorID CHAR(2) FOREIGN KEY REFERENCES Student_Major(MajorID),
	StudentEmail NVARCHAR(50),
	StudentPhoneNum NVARCHAR(20)
)
GO

CREATE TABLE Student_Major(
	MajorID CHAR(2) PRIMARY KEY,
	MajorName NVARCHAR(50) NOT NULL UNIQUE
)
GO

CREATE TABLE Borrow_Book(
	BorrowID CHAR(5) PRIMARY KEY,
	BookID CHAR(4) FOREIGN KEY REFERENCES Book(BookID),
	StudentID CHAR(4) FOREIGN KEY REFERENCES Student(StudentID),
	DateBorrow DATE,
	DateReturn DATE,
	BorrowStatus NVARCHAR(10) CHECK (BorrowStatus IN ('Borrowing', 'Returned', 'Overdue'))
)
GO

-- INPUT DATA INTO TABLES

-- BOOK
INSERT INTO Book
	VALUES('B001', N'12 Xu Hướng Công Nghệ Trong Thời Đại 4.0', 'PL001', 'A001', '476', '30', '121680', '2012-04-12', 'A', 'IT')
INSERT INTO Book
	VALUES('B002', N'Khoa Học Khám Phá – Dữ Liệu Lớn', 'PL002', 'A002', '344', '25', '112000', '2012-12-09', 'B', 'IT')
INSERT INTO Book
	VALUES('B003', N'Cuộc Rượt Đuổi Ngoạn Mục Trong Mê Lộ Máy Tính', 'PL003', 'A003', '516', '20', '167170', '2013-01-22', 'C', 'IT')
INSERT INTO Book
	VALUES('B004', N'An toàn thông tin - Nghệ thuật ẩn mình', 'PL003', 'A004', '344', '20', '112000', '2013-01-22', 'C', 'IT')
INSERT INTO Book
	VALUES('B005', N'Kinh Điển Về Khởi Nghiệp', 'PL004', 'A005', '367', '35', '265000', '2013-05-29', 'D', 'ECO')
INSERT INTO Book
	VALUES('B006', N'Lược Sử Kinh Tế Học', 'PL005', 'A006', '367', '35', '114750', '2013-04-22', 'D', 'ECO')
INSERT INTO Book
	VALUES('B007', N'Luật du lịch', 'PL004', 'A002', '84', '10', '18000', '2014-01-05', 'E', 'TOU')
INSERT INTO Book
	VALUES('B008', N'Vui học tiếng Anh cùng trẻ', 'PL002', 'A003', '156', '25', '110000', '2014-05-15', 'F', 'LAN')
INSERT INTO Book
	VALUES('B009', N'Tiếng Nhật cho mọi người', 'PL002', 'A001', '150', '25', '85000', '2014-11-27', 'G', 'LAN')
INSERT INTO Book
	VALUES('B010', N'Tội ác và sự trừng phạt', 'PL005', 'A006', '606', '10', '599000', '2015-03-16', 'H', 'LIT')
INSERT INTO Book
	VALUES('B011', N'Tìm hiểu về SQL', 'PL003', 'A004', '529', '25', '120000', '2015-01-12', 'A', 'IT')
GO

-- BOOK PUBLISHER
INSERT INTO Book_Publisher
	VALUES('PL001', N'Nhà xuất bản Nhà Xuất Bản Đại Học Kinh Tế Quốc Dân')
INSERT INTO Book_Publisher
	VALUES('PL002', N'NXB Trẻ')
INSERT INTO Book_Publisher
	VALUES('PL003', N'NXB Công Thương')
INSERT INTO Book_Publisher
	VALUES('PL004', N'NXB Lao Động')
INSERT INTO Book_Publisher
	VALUES('PL005', N'Nhà Xuất Bản Thế Giới')
GO

-- BOOK AUTHOR
INSERT INTO Book_Author
	VALUES('A001', N'Kevin Kelly')
INSERT INTO Book_Author
	VALUES('A002', N'Nhiều Tác Giả')
INSERT INTO Book_Author
	VALUES('A003', N'Clifford Stoll')
INSERT INTO Book_Author
	VALUES('A004', N'Kevin Mitnick')
INSERT INTO Book_Author
	VALUES('A005', N'Bill Aulet')
INSERT INTO Book_Author
	VALUES('A006', N'Niall Kishtainy')
GO

-- BOOK SHELF
INSERT INTO Book_Shelf
	VALUES('A', N'Dãy A')
INSERT INTO Book_Shelf
	VALUES('B', N'Dãy B')
INSERT INTO Book_Shelf
	VALUES('C', N'Dãy C')
INSERT INTO Book_Shelf
	VALUES('D', N'Dãy D')
INSERT INTO Book_Shelf
	VALUES('E', N'Dãy E')
INSERT INTO Book_Shelf
	VALUES('F', N'Dãy F')
INSERT INTO Book_Shelf
	VALUES('G', N'Dãy G')
INSERT INTO Book_Shelf
	VALUES('H', N'Dãy H')
GO

-- BOOK TYPE
INSERT INTO Book_Type
	VALUES('IT', N'Công nghệ thông tin')
INSERT INTO Book_Type
	VALUES('ECO', N'Kinh tế')
INSERT INTO Book_Type
	VALUES('TOU', N'Du lịch')
INSERT INTO Book_Type
	VALUES('LIT', N'Văn học')
INSERT INTO Book_Type
	VALUES('LAN', N'Ngôn ngữ')
GO

-- STUDENT
INSERT INTO Student
	VALUES('S001', N'Nguyễn Hoàng Đạt', '2025-08-26', 'SE', N'datnhse170330@fpt.edu.vn', N'0966548257')
INSERT INTO Student
	VALUES('S002', N'Đỗ Thế Hiếu', '2025-08-26', 'SE', N'hieudtse170041@fpt.edu.vn', N'0967475325')
INSERT INTO Student
	VALUES('S003', N'Nguyễn Trường Thọ', '2025-08-26', 'SE', N'thontse172700@fpt.edu.vn', N'0866954481')
INSERT INTO Student
	VALUES('S004', N'Lê Ngọc Thanh Trúc', '2026-08-26', 'GD', N'truclntgd184843@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S005', N'Phan Võ Ngọc Phú', '2025-08-26', 'MK', N'phupvnse172810@fpt.edu.vn', N'0966548257')
INSERT INTO Student
	VALUES('S006', N'Nguyễn Trung Trực', '2025-08-26', 'BI', N'trucntse172722@fpt.edu.vn', N'0974050903')
GO

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
GO

-- BORROW BOOK
INSERT INTO Borrow_Book
	VALUES('BR001', 'B007', 'S001', '2023-01-23', '2023-04-30', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR002', 'B002', 'S002', '2023-01-01', '2023-02-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR003', 'B002', 'S002', '2023-02-01', '2023-03-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR004', 'B002', 'S002', '2023-03-01', '2023-04-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR005', 'B002', 'S002', '2023-04-01', '2023-04-30', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR006', 'B002', 'S003', '2023-01-01', '2023-02-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR007', 'B002', 'S003', '2023-02-01', '2023-03-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR008', 'B002', 'S003', '2023-03-01', '2023-04-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR009', 'B002', 'S003', '2023-04-01', '2023-05-01', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR010', 'B002', 'S004', '2023-01-01', '2023-02-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR011', 'B002', 'S004', '2023-02-01', '2023-03-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR012', 'B002', 'S004', '2023-03-01', '2023-04-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR013', 'B002', 'S004', '2023-04-01', '2023-04-30', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR014', 'B002', 'S004', '2023-05-01', '2023-05-30', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR015', 'B002', 'S005', '2023-01-01', '2023-02-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR016', 'B002', 'S005', '2023-02-01', '2023-03-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR017', 'B002', 'S005', '2023-03-01', '2023-04-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR018', 'B002', 'S005', '2023-04-01', '2023-04-30', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR019', 'B002', 'S006', '2023-01-01', '2023-02-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR020', 'B002', 'S006', '2023-02-01', '2023-03-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR021', 'B002', 'S006', '2023-03-01', '2023-04-30', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR022', 'B003', 'S005', '2023-05-01', '2023-06-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR023', 'B003', 'S005', '2023-06-01', '2023-07-01', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR024', 'B003', 'S002', '2023-08-01', '2023-09-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR025', 'B003', 'S002', '2023-09-01', '2023-10-01', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR026', 'B003', 'S004', '2023-04-01', '2023-04-30', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR027', 'B003', 'S004', '2023-05-01', '2023-06-01', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR028', 'B003', 'S001', '2023-07-01', '2023-08-30', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR029', 'B003', 'S003', '2023-11-01', '2023-12-01', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR030', 'B003', 'S003', '2023-12-01', '2023-12-30', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR031', 'B003', 'S001', '2023-11-01', '2023-12-30', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR032', 'B003', 'S006', '2023-01-23', '2023-04-30', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR033', 'B004', 'S005', '2023-01-01', '2023-04-30', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR034', 'B005', 'S002', '2023-11-01', '2023-12-30', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR035', 'B001', 'S003', '2023-04-01', '2023-04-30', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR036', 'B006', 'S006', '2023-06-01', '2023-10-01', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR037', 'B008', 'S005', '2023-04-01', '2023-08-01', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR038', 'B009', 'S004', '2023-05-01', '2023-06-01', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR039', 'B010', 'S002', '2023-03-01', '2023-04-30', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR040', 'B005', 'S003', '2023-02-01', '2023-03-01', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR041', 'B002', 'S001', '2023-06-01', '2023-07-01', N'Returned')
GO

-- 6.1 Liệt kê tất cả thông tin của các đầu sách gồm tên sách, mã sách, giá tiền , tác giả thuộc loại sách có mã “IT”.
SELECT b.BookTitle, b.BookID, b.BookPrice, a.AuthorName FROM Book b
	LEFT JOIN Book_Author a ON b.BookAuthorID = a.AuthorID
	WHERE BookTypeID = 'IT'
GO

-- 6.2 Liệt kê các phiếu mượn gồm các thông tin mã phiếu mượn, mã sách , ngày mượn, mã sinh viên có ngày mượn trong tháng 01/2023.
SELECT BorrowID, BookID, DateBorrow, StudentID FROM Borrow_Book
	WHERE YEAR(DateBorrow) = '2023' AND MONTH(DateBorrow) = '1'
GO

-- 6.3 Liệt kê các phiếu mượn chưa trả sách cho thư viện theo thứ tự tăng dần của ngày mượn sách.
SELECT * FROM Borrow_Book
	WHERE BorrowStatus = 'Borrowing' OR BorrowStatus = 'Overdue'
	ORDER BY DateBorrow ASC
GO

-- 6.4 Liệt kê tổng số đầu sách của mỗi loại sách (gồm mã loại sách, tên loại sách, tổng số lượng sách mỗi loại).
SELECT t.TypeID, t.TypeName, SUM(b.BookQuantity) AS Total_Book FROM Book_Type t
	JOIN Book b ON t.TypeID = b.BookTypeID
	GROUP BY t.TypeID, t.TypeName
GO

-- 6.5 Đếm xem có bao nhiêu lượt sinh viên đã mượn sách.
SELECT COUNT(*) AS Total_Borrow FROM Borrow_Book
GO

-- 6.6 Hiển thị tất cả các quyển sách có tiêu đề chứa từ khoá “SQL”.
SELECT * FROM Book
	WHERE BookTitle LIKE '%SQL%'
GO

-- 6.7 Hiển thị thông tin mượn sách gồm các thông tin: mã sinh viên, tên sinh viên, mã phiếu mượn, tiêu đề sách, ngày mượn, ngày trả.
-- Sắp xếp thứ tự theo ngày mượn sách.
SELECT br.StudentID, s.StudentName, br.BorrowID, b.BookTitle, br.DateBorrow, br.DateReturn FROM Borrow_Book br
	JOIN Student s ON br.StudentID = s.StudentID
	JOIN Book b ON br.BookID = b.BookID
	ORDER BY br.DateBorrow
GO

-- 6.8 Liệt kê các đầu sách có lượt mượn lớn hơn 20 lần.
SELECT b.BookID, b.BookTitle FROM Book b
	JOIN Borrow_Book br ON b.BookID = br.BookID
	GROUP BY b.BookID, b.BookTitle HAVING COUNT(*) > 20
GO

-- 6.9 Viết câu lệnh cập nhật lại giá tiền của các quyển sách có ngày nhập kho trước năm 2014 giảm 30%.
UPDATE Book
	SET BookPrice = BookPrice * 0.7
	WHERE YEAR(InputDate) < '2014'
GO

-- 6.10 Viết câu lệnh cập nhật lại trạng thái đã trả sách cho phiếu mượn của sinh viên có mã sinh viên PD12301 (ví dụ).
UPDATE Borrow_Book
	SET BorrowStatus = 'Returned'
	WHERE StudentID = 'S001'
GO

-- 6.11 Lập danh sách các phiếu mượn quá hạn chưa trả gồm các thông tin: mã phiếu mượn,
-- tên sinh viên, email, danh sách các sách đã mượn, ngày mượn.
SELECT br.BorrowID, s.StudentName, s.StudentEmail, b.BookTitle, br.DateBorrow FROM Borrow_Book br
	JOIN Student s ON br.StudentID = s.StudentID
	JOIN Book b ON br.BookID = b.BookID
	WHERE br.BorrowStatus = 'Overdue'
GO

-- 6.12 Viết câu lệnh cập nhật lại số lượng bản sao tăng lên 5 đơn vị đối với các đầu sách có lượt mượn lớn hơn 10
UPDATE Book
	SET BookQuantity = BookQuantity + 5
	WHERE BookID IN (
		SELECT b.BookID FROM Book b
		JOIN Borrow_Book br ON b.BookID = br.BookID
		GROUP BY b.BookID HAVING COUNT(*) > 10
	)
GO

-- 6.13 Viết câu lệnh xoá các phiếu mượn có ngày mượn và ngày trả trước ‘1/1/2023’
DELETE FROM Borrow_Book
	WHERE DateBorrow < '2023-01-01'
	OR DateReturn <'2023-01-01'
GO

-- 6.14. Tạo một Trigger cập nhật số lượng sách khi có sinh viên mượn hoặc trả sách
CREATE TRIGGER TR_Update_Quantity_Book ON Borrow_Book
	AFTER INSERT, UPDATE, DELETE
	AS
		BEGIN
			UPDATE Book
				SET BookQuantity = BookQuantity - 1
				FROM Book b
				JOIN inserted ON b.BookID = inserted.BookID
				WHERE b.BookID = inserted.BookID
					AND (inserted.BorrowStatus = 'Borrowing' OR inserted.BorrowStatus = 'Overdue')
			UPDATE Book
				SET BookQuantity = BookQuantity + 1
				FROM Book b
				JOIN deleted ON b.BookID = deleted.BookID
				WHERE b.BookID = deleted.BookID
					AND (deleted.BorrowStatus = 'Borrowing' OR deleted.BorrowStatus = 'Overdue')
		END
GO

-- SHOW ALL TABLE
SELECT * FROM Book
GO
SELECT * FROM Book_Publisher
GO
SELECT * FROM Book_Author
GO
SELECT * FROM Book_Shelf
GO
SELECT * FROM Book_Type
GO
SELECT * FROM Student
GO
SELECT * FROM Student_Major
GO
SELECT * FROM Borrow_Book
GO