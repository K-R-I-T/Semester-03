USE Northwind

----------------------------------------------------------------------------------
-- LÝ THUYẾT
-- MỘT DATABASE SẼ CÓ NHIỀU TABLE (NƠI CHỨA DATA) (BÁN HÀNG, QUẢN LÝ SV,...)
-- DATA ĐƯỢC LƯU DƯỚI DẠNG TABLE, TÁCH THÀNH NHIỀU TABLE (NGHỆ THUẬT DESIGN DB, NF)
-- DÙNG SELECT ĐỂ XEM/IN DỮ LIỆU TỪ TABLE, HIỆN THỊ DƯỚI DẠNG TABLE
-- CÚ PHÁP CHUẨN: SELECT * FOMR <TÊN TABLE>
--                       * ĐẠI DIỆN CHO VIỆC TUI MÚN LẤY ALL OF COLUMNS
-- CÚ PHÁP MỞ RỘNG: 
--					SELECT TÊN-CÁC-CỘT-MUỐN-LẤY, CÁCH-NHAU-DẤU-PHẨY FROM <TÊN TABLE>
--					SELECT CÓ THỂ DÙNG CÁC HÀM XỮ LÝ CÁC CỘT ĐỂ ĐỘ LẠI THÔNG TIN HIỂN THỊ FROM <TÊN TABLE>

-- DATA TRẢ VỀ CÓ CELL/Ô CÓ NULL, CHƯA XÁC ĐỊNH VALUE/GIÁ TRỊ, CHƯA CÓ, CHƯA BIẾT TỪ TỪ CẬP NHẬT SAU. 
-- VÍ DỤ SV KÝ TÊN DS THI, CỘT ĐIỂM LÚC KÝ GỌI LÀ NULL, MANG TRẠNG THÁI CHƯA XÁC ĐỊNH
----------------------------------------------------------------------------------

-- 1. XEM THÔNG TIN CỦA TẤT CẢ CÁC KHÁCH HÀNG ĐANG GIAO DỊCH
SELECT * FROM Customers
INSERT INTO Customers(CustomerID, CompanyName, ContactName) 
				VALUES('ALFKI', 'FPT University', 'Thanh Nguyen Khac')
				-- BỊ CHỬI VÌ TRÙNG PK
INSERT INTO Customers(CustomerID, CompanyName, ContactName) 
				VALUES('FPTU', 'FPT University', 'Thanh Nguyen Khac')
				-- NGON LÀNH CÀNH ĐÀO

-- 2. XEM THÔNG TIN NHÂN VIÊN, XEM HẾT CÁC CỘT
SELECT * FROM Employees

-- 3. XEM CÁC SẢN PHẨM CÓ TRONG KHO
SELECT * FROM Products

-- 4. MUA HÀNG, THÌ THÔNG TIN SẼ NẰM Ở TABLE ORDERS VÀ ORDERDETAILS
SELECT * FROM Orders -- 830 BILL

-- 5. XEM THÔNG TIN CÔNG TY GIAO HÀNG
SELECT * FROM Shippers
INSERT INTO Shippers(CompanyName, Phone) VALUES ('Fedex Vietnam', '(084)90...')

-- 6. XEM CHI TIẾT MUA HÀNG
SELECT * FROM Orders             -- PHẦN TRÊN CỦA BILL SIÊU THỊ
SELECT * FROM [Order Details]    -- PHẦN TABLE KẺ GIÓNG LỀ NHỮNG MÓN HÀNG ĐÃ MUA

-- 7. IN RA THÔNG TIN KHÁCH HÀNG CHỈ GỒM CÁC CỘT ID, COMNAME, CONTACTNAME, COUNTRY
SELECT CustomerID,CompanyName,ContactName,Country FROM Customers

-- 8. In ra thông tin của nhân viên, chỉ cần id, Last, First, Title, DoB
-- Tên người tách thành Last & First: dành cho mục tiêu sort theo tiêu chí tên, họ. In ra tên theo quy ước của mỗi quốc gia
SELECT * FROM Employees

SELECT EmployeeID, LastName, FirstName, Title, BirthDate FROM Employees

-- 9. In ra thông tin nhân viên, ghép tên/ gộp cột, tính tuổi
SELECT EmployeeID, LastName + ' ' + FirstName AS FullName, Title, BirthDate FROM Employees

SELECT EmployeeID, LastName + ' ' + FirstName AS FullName, Title, BirthDate, Year(BirthDate) FROM Employees

SELECT EmployeeID, LastName + ' ' + FirstName AS FullName, Title, BirthDate, YEAR(GETDATE()) - Year(BirthDate) AS Age FROM Employees

-- 10. In ra thông tin chi tiết mua hàng
SELECT * FROM [Order Details]
SELECT * , UnitPrice * Quantity FROM [Order Details]
-- Công thức tính tổng tiền phải trả từng món, có trừ đi giảm giá, phần trăm
-- SL * DG - TIỀN GIẢM GIÁ ==> PHẢI TRẢ
-- SL * DG - SL * DG * DISCOUNT (%) ==> PHẢI TRẢ
-- SL * DG * (1 - DISCOUNT %) ==> PHẢI TRẢ
SELECT *, UnitPrice * Quantity * (1 - Discount) AS SubTotal FROM [Order Details]
