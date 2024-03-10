USE SE172950_ASSIGNMENT
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS loan;

CREATE TABLE category(
	categoryID varchar(255) NOT NULL PRIMARY KEY,
	categoryName varchar(255) NOT NULL,
);

CREATE TABLE book(
	bookID varchar(255) NOT NULL PRIMARY KEY,
	bookTitle nvarchar(255) NOT NULL,
	bookPublisher nvarchar(255) NOT NULL,
	bookAuthor nvarchar (255) NOT NULL,
	bookPageNumber int NOT NULL,
	bookCopy int NOT NULL,
	bookPrice FLOAT NOT NULL,
	categoryID varchar(255) NOT NULL FOREIGN KEY REFERENCES category(categoryID),
	importDate DATETIME NOT NULL,
	bookPlacement varchar(255) NOT NULL,
);

CREATE TABLE student(
	studentID varchar(255) NOT NULL PRIMARY KEY,
	studentName nvarchar(255) NOT NULL,
	expiredDate DATETIME NOT NULL,
	studentMajor varchar (255) NOT NULL,
	studentEmail varchar (255) NOT NULL,
	studentPhone varchar (255) NOT NULL,
);

CREATE TABLE loan(
	loanID varchar (255) PRIMARY KEY,
	bookID varchar (255) NOT NULL FOREIGN KEY REFERENCES book(bookID),
	studentID varchar(255) NOT NULL FOREIGN KEY REFERENCES student(studentID),
	dateBorrowes DATETIME NOT NULL,
	dateReturn DATETIME NOT NULL,
	quantity int NOT NULL,
);

--Y5. Nhập dữ liệu vào cho các bảng (ít nhất 5 bản ghỉ trên mỗi bảng)
USE SE172950_ASSIGNMENT
INSERT INTO category VALUES
('IT','Information Technology'),
('ECO','Economic'),
('LAW','Law'),
('MC','Multimedia Communication'),
('LAN','Language'),
('NOV', 'Novel');

INSERT INTO student VALUES 
('SE172950',N'Đào Hoài Phương','2025-09-13','Software Engineer','phuongdhse172950@fpt.edu.vn','0961977302'),
('SS171018',N'Huỳnh Thị Ngọc Ngân','2025-04-23','Multimedia Communication','nganhtnss171018@fpt.edu.vn','0198467289'),
('SE172700',N'Nguyễn Trường Thọ','2025-09-13','Software Engineer','thontse172700@fpt.edu.vn','0866954481'),
('SE170041',N'Đỗ Thế Hiếu','2025-09-13','Software Engineer','hieudtse170041@fpt.edu.vn','0967475325'),
('SE170330',N'Nguyễn Hoàng Đạt','2025-09-13','Software Engineer','dathnse170330@fpt.edu.vn','0987654321'),
('SE172809',N'Trần Đăng Dũng','2025-09-13','Software Engineer','dungtd172809@fpt.edu.vn','0786424052'),
('SE172810',N'Phan Võ Ngọc Phú','2025-09-13','Software Engineer','phupvnse172810@fpt.edu.vn','0784233103'),
('SE184842',N'Lê Ngọc Thanh Trúc','2026-04-13','Graphic Designer','truclntse184842@fpt.edu.vn','0387774541'),
('SE171089',N'Hoàng Ngọc Thức','2025-09-13','Software Engineer','thuchnse171089@fpt.edu.vn','0244236903'),
('SE172561',N'Phạm Quốc Trung','2025-09-13','Software Engineer','trungpqse172561@fpt.edu.vn','0714243189'),
('SE172806',N'Phạm Hoàng Minh Khôi','2025-09-13','Software Engineer','khoiphmse172806@fpt.edu.vn','0714335189'),
('SE170234',N'Trần Ánh Tuyết','2025-09-13','Software Engineer','tuyettase170234@fpt.edu.vn','0587614214');

INSERT INTO book VALUES
('FPTIT1102','Data Structures and Algorithms in Python','Addison-Wesley Professional','John Canning, Alan Broder, Robert Lafore','768','100','283','IT','2013-03-18','A1'),
('FPTIT1231',N'Ký Sự BrSE',N'NXB Thế Giới',N'Nguyễn Văn Trọng, Triệu Anh Tuấn','282','100','168','IT','2013-03-18','A1'),
('FPTIT1202','Clean Code',N'NXB Dân Trí','Robert Cecil Martin','596','200','290','IT','2013-01-18','A1'),
('FPTNOV6002','All In Love',N'NXB Phụ Nữ',N'Cố Tây Tước','416','30','100','NOV','2020-07-20','B1'),
('FPTMC4302',N'Truyền Sao Cho Thông',N'NXB Phụ Nữ Việt Nam','Andrew Macarthy','400','50','144','MC','2022-03-23','C2'),
('FPTLAN5205','Kanji Look and Learn',N'NXB Hồng Đức','Eri Banno, Yoko Ikeda, Chikako Shinagawa, Kaori Tajima, Kyoko Tokashiki','272','30','160','LAN','2022-03-21','A2'),
('FPTIT1105',N'Lập Trình Với Vi Điều Khiển PIC - Lý Thuyết - Thực Hành',N'NXB Thanh Niên',N'Nguyễn Đình Phú, Trương Ngọc Anh, Phan Văn Hoàn','368','9','141','IT','2022-04-21','A3'),
('FPTIT1195',N'Lập Trình Quỹ Đạo Cuộc Đời',N'NXB Hồng Đức',N'Kiên Trần','280','10','98','IT','2022-04-11','A3'),
('FPTIT1111',N'Lập Trình Với C#',N'NXB Thanh Niên',N'Phạm Quang Huy, Vũ Trọng Luật,...','382','100','106','IT','2022-02-21','A3'),
('FPTECO2203','StrengthsFinder 2.0','Gallup Press','Tom Rath','175','10','567','ECO','2021-04-21','B1'),
('FPTECO2001','Predictably Irrational: The Hidden Forces That Shape Our Decisions','Harper','Dan Ariely','400','15','143','ECO','2020-04-21','B1'),
('FPTECO2204','Dont Trust Your Gut','HarperCollins','Seth Stephens-Davidowitz','307','20','261','ECO','2021-04-11','B1'),
('FPTECO2205','Thank You for Being Late','Penguin Books Ltd','Thomas L. Friedman','560','32','333','ECO','2022-05-21','B1'),
('FPTLAN5001',N'Luyện Thi Năng Lực Tiếng Nhật JLPT 1000 Chữ Hán N2',N'NXB Hồng Đức',N'Nhiều Tác Giả','240','18','83','LAN','2021-12-21','E1'),
('FPTLAN5002',N'500 Câu Hỏi Luyện Thi Năng Lực Nhật Ngữ Trình Độ N1',N'NXB Trẻ','Matsumoto, Sasaki Hitoko','294','12','66','LAN','2022-12-21','E1'),
('FPTLAN5003',N'Quick Japanese - Nói Tiếng Nhật Cấp Tốc (Kèm CD)',N'NXB Tổng Hợp TP.HCM','Ebidora','144','10','156','LAN','2022-10-21','E1'),
('FPTLAN5004','Cambridge Ielts 15 Academic With Answers (Savina)',N'NXB Cambridge University','Cambridge','142','12','133','LAN','2019-10-21','E1'),
('FPTLAN5005','Basic Ielts Reading',N'Tổng Hợp TPHCM','Zhang Juan','187','13','140','LAN','2021-09-21','E1'),
('FPTLAN5006',N'30 Chủ Đề Từ Vựng Tiếng Anh (Tập 2)',N'Đại Học Quốc Gia Hà Nội',N'Trang Anh','472','14','152','LAN','2021-08-21','E1'),
('FPTLAN5007',N'Luyện Viết Chữ Nhớ Từ Vựng - English Writing Family & Friend 3',N'NXB Thanh Niên',N'Little Rainbow','54','19','35','LAN','2022-03-21','E1'),
('FPTMC4001',N'Giáo trình nhập môn Truyền thông đa phương tiện',N'NXB Thông Tin & Truyền Thông',N'Đỗ Thu Hằng','202','13','94','MC','2021-07-21','D1'),
('FPTIT1122','SQL For Dummies',N'NXB Công Thương','Lynn Beighley','408','20','139','IT','2023-02-21','A3');

INSERT INTO loan VALUES
('LOAN0001','FPTIT1102','SE172700','2023-01-12','2023-01-23',1),
('LOAN0002','FPTIT1231','SE172950','2023-01-21','',1),
('LOAN0003','FPTNOV6002','SE170041','2023-01-21','2023-02-02',2),
('LOAN0004','FPTIT1202','SE171089','2023-02-23','',3),
('LOAN0005','FPTLAN5205','SE172950','2023-01-15','2023-01-29',1),
('LOAN0006','FPTMC4302','SS171018','2023-03-12','2023-03-23',2),
('LOAN0007','FPTIT1202','SE170330','2023-03-04','',1),
('LOAN0008','FPTIT1102','SE172700','2023-01-11','2023-01-22',1),
('LOAN0009','FPTLAN5002','SE171089','2023-02-20','',1),
('LOAN0010','FPTECO2205','SS171018','2023-04-21','2023-05-02',2),
('LOAN0011','FPTECO2204','SS171018','2023-02-11','',3),
('LOAN0012','FPTLAN5006','SE172810','2023-04-15','2023-04-29',1),
('LOAN0013','FPTMC4001','SS171018','2023-03-12','2023-03-23',2),
('LOAN0014','FPTIT1111','SE172809','2023-03-02','',1),
('LOAN0015','FPTLAN5006','SE184842','2023-01-28','2023-02-12',2),
('LOAN0016','FPTMC4302','SE184842','2023-01-15','2023-01-29',1),
('LOAN0017','FPTIT1105','SE172561','2023-03-12','2023-03-23',2),
('LOAN0018','FPTIT1195','SE170330','2023-03-04','',1),
('LOAN0019','FPTECO2001','SS171018','2023-01-28','2023-02-12',2),
('LOAN0020','FPTLAN5004','SE170234','2023-01-28','2023-02-12',2);

--Y6. Viết các câu truy vấn sau:
--6.1 Liệt kê tất cả thông tin của các đầu sách gồm tên sách, mã sách, giá tiền , tác giả thuộc loại sách có mã “IT”.
SELECT bookID as[ID], bookTitle as[Title], bookAuthor as[Author], bookPrice as[Price]
FROM book
WHERE categoryID = 'IT'

--6.2 Liệt kê các phiếu mượn gồm các thông tin mã phiếu mượn, mã sách , ngày mượn, mã sinh viên có ngày mượn trong tháng 01/2023.
SELECT loanID as [Loan ID], bookID as[Book ID], day(dateBorrowes) as [Borrow Date], studentID as [Student ID]
FROM loan
WHERE YEAR(dateBorrowes) = 2023 and MONTH(dateBorrowes) = 1

--6.3 Liệt kê các phiếu mượn chưa trả sách cho thư viên theo thứ tự tăng dần của ngày mượn sách.
SELECT *
FROM loan
WHERE DATEDIFF(DAY, dateBorrowes, GETDATE())>7
ORDER BY dateBorrowes

--6.4 Liệt kê tổng số đầu sách của mỗi loại sách ( gồm mã loại sách, tên loại sách, tổng số lượng sách mỗi loại).
SELECT c.categoryID as [Category ID], c.categoryName as [Category Name], COUNT(b.bookID) as [Total Books]
FROM category c
LEFT JOIN book b ON c.categoryID = b.categoryID
GROUP BY c.categoryID, c.categoryName

--SELECT b.categoryID as [Category ID], c.categoryName as[Category Name], count(b.bookID) as [Total book]
--FROM 
	--book b
	--right join category c on c.categoryID = b.categoryID
--GROUP BY b.categoryID, c.categoryName

--6.5 Đếm xem có bao nhiêu lượt sinh viên đã mượn sách.
SELECT count(*) as [Total Borrow]
FROM loan

--6.6 Hiển thị tất cả các quyển sách có tiêu đề chứa từ khoá “SQL”.
SELECT *
FROM book
WHERE bookTitle like '%SQL%'

--6.7 Hiển thị thông tin mượn sách gồm các thông tin: mã sinh viên, tên sinh viên, mã phiếu mượn, tiêu đề sách, ngày mượn, ngày trả. Sắp xếp thứ tự theo ngày mượn sách.
SELECT student.studentID as [Student ID], studentName as [Student Name], loan.loanID as [Loan ID], book.bookTitle as [Title], loan.dateBorrowes as [Borrow Date], dateReturn as [Return Date]
FROM loan 
join student 
ON loan.studentID = student.studentID
join book
ON loan.bookID = book.bookID
ORDER BY loan.dateBorrowes

--6.8 Liệt kê các đầu sách có lượt mượn lớn hơn 20 lần.


--6.9 Viết câu lệnh cập nhật lại giá tiền của các quyển sách có ngày nhập kho trước năm 2014 giảm 30%.
UPDATE book
SET bookPrice = bookPrice * 0.3
WHERE importDate < '2014-01-01'

--6.10 Viết câu lệnh cập nhật lại trạng thái đã trả sách cho phiếu mượn của sinh viên có mã sinh viên PD12301 (ví dụ).
ALTER TABLE loan
ADD loanStatus varchar(255);
GO
UPDATE loan
SET loanStatus = 'returned'
WHERE studentID = 'SE172950'

--6.11 Lập danh sách các phiếu mượn quá hạn chưa trả gồm các thông tin: mã phiếu mượn, tên sinh viên, email, danh sách các sách đã mượn, ngày mượn.
SELECT l.loanID, s.studentName, s.studentEmail, GROUP_CONCAT(b.bookName), l.dateBorrowes
FROM loan l
JOIN student s ON l.studentID = s.studentID
JOIN book b ON l.bookID = b.bookID
WHERE l.status = 'overdue'
GROUP BY l.loanID

--6.12 Viết câu lệnh cập nhật lại số lượng bản sao tăng lên 5 đơn vị đối với các đầu sách có lượt mượn lớn hơn 10


--6.13 Viết câu lệnh xoá các phiếu mượn có ngày mượn và ngày trả trước ‘1/1/2023’
DELETE FROM loan
WHERE dateBorrowes < '2023-01-01' AND dateReturn > '2023-01-01'

--6.14. Tạo một Trigger cập nhật số lượng sách khi có sinh viên mượn hoặc trả sách


SELECT*
FROM loan

ALTER TABLE loan DROP Status;
