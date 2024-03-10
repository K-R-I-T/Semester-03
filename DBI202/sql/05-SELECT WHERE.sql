USE Northwind

--------------------------------------------------------------------------------------
-- LÍ THUYẾT
-- CÚ PHÁP MỞ RỘNG LỆNH SELECT
-- MỆNH ĐỀ WHERE: DÙNG LÀM BỘ LỌC/FILTER/NHẶT RA DỮ LIỆU TA CẦN THEO 1 TIÊU CHÍ NÀO ĐÓ
-- VD: Lọc ra những sv có quê ở Bình Dương
--     Lọc ra những sv có quê ở Tiền Giang và điểm tb >= 8

-- CÚ PHÁP DÙNG BỘ LỌC:
-- SECLECT * (cột bạn muốn lọc) FROM <TÊN-TABLE> WHERE <ĐIỀU-KIỆN-LỌC>
-- * ĐIỀU KIỆN LỌC: TÌM TỪNG DÒNG, VỚI CÁI CỘT CÓ GIÁ TRỊ CẦN LỌC
--					LỌC THEO TÊN CỘT VỚI VALUE THẾ NÀO, LẤY TÊN CỘT, XEM VALUE TRONG CELL
--				    CÓ THỎA ĐIỀU KIỆN LỌC HAY K?
-- ĐỂ VIẾT ĐƯỢC ĐIỀU KIỆN LỌC CẦN:
--    > TÊN CỘT
--      VALUE CỦA CỘT (CELL)
--      TOÁN TỬ (OPERATOR) >, >=, !=, < (!= VÀ <> CÙNG Ý NGHĨA)
--		NHIỀU ĐIỀU KIỆN LỌC ĐI KÈM, DÙNG THÊM LOGIC OPERATORS, AND, OR, NOT
-- VD: WHERE City = N'Bình Dương'
--	   WHERE City = N'Tiền Giang' AND Gpa >= 8

-- LỌC LIÊN QUAN ĐẾN GIÁ TRỊ/VALUE/CELL CHỨA GÌ, TA PHẢI QUAN TÂM ĐẾN DATA TYPES
-- Số: nguyên/thực, ghi số ra như truyền thống
-- Chuỗi/ký tự: 'A', 'Ahaha'
-- Ngày tháng: '2023-01-01 ...'
--------------------------------------------------------------------------------------
-- THỰC HÀNH

-- 1. In ra ds các khách hàng
SELECT * FROM Customers -- 92

-- 2. In ra ds kh đến từ Ý
SELECT * FROM Customers WHERE Country = 'Italy' -- 3

-- 3. In ra ds kh đến từ Mỹ
SELECT * FROM Customers WHERE Country = 'USA' -- 13

-- 4. In ra những khách hàng đến từ Mỹ, Ý
-- đời thường có thể nói: những kh đến từ Ý và Mĩ, Ý hoặc Mĩ

-- SELECT * FROM Customers WHERE Country = 'USA' OR 'Italy' -- ERROR, thiếu toán tử

SELECT * FROM Customers WHERE Country = 'USA' AND Country = 'Italy' -- 0
SELECT * FROM Customers WHERE Country = 'USA' OR Country = 'Italy' -- hiểu nghĩa logic, hơn hiểu nghĩa tiếng Việt

-- sort theo Ý, Mĩ để gom cụm cho dễ theo dõi
SELECT * FROM Customers WHERE Country = 'USA' OR Country = 'Italy' ORDER BY Country

-- 5. In ra kh đến từ thủ đô nước Đức
SELECT * FROM Customers WHERE Country = 'Germany' AND City = 'Berlin'

-- 6. In ra các thông tin của nv
SELECT * FROM Employees

-- 7. In ra thông tin của nv có năm sinh từ 1960 trở lại gần đây
SELECT * FROM Employees WHERE YEAR(BirthDate) >= 1960

-- 8. In ra thông tin nv có tuổi từ 60 trở lên
SELECT YEAR(GETDATE()) - YEAR(BirthDate) AS Age, * FROM Employees WHERE YEAR(GETDATE()) - YEAR(BirthDate) >= 60

-- 9. Những nv nào ở London
SELECT * FROM Employees WHERE City = 'London'

-- 10. Những nv không ở London
SELECT * FROM Employees WHERE City != 'London'
SELECT * FROM Employees WHERE City <> 'London'
SELECT * FROM Employees WHERE NOT City = 'London'

-- 11. In ra hồ sơ nv có mã số là 1
SELECT * FROM Employees WHERE EmployeeID = 1
-- WHERE TRÊN KEY CHỈ RA 1 MÀ THÔI
-- SELECT MÀ CÓ WHERE KEY CHỈ 1 DÒNG TRẢ VỀ, DISTINCT LÀ VÔ NGHĨA
SELECT DISTINCT EmployeeID, City FROM Employees WHERE EmployeeID = 1 ORDER BY EmployeeID

-- CÔNG THỨC FULL K CHE CỦA SELECT
-- SELECT ...      FROM ...       WHERE ... GROUP ... HAVING ... ORDER BY ...
--        DISTINCT     1, N TABLE
--           HÀM()
--          NESTED QUERY/SUB QUERY

-- 12. Xem thông tin đơn hàng
SELECT * FROM Orders -- 830

-- 13. Xem thông tin đơn hàng, sắp xếp giảm dần theo trọng lượng
SELECT * FROM Orders ORDER BY Freight DESC

-- 14. Xem thông tin đơn hàng, sắp xếp giảm dần theo trọng lượng, trọng lượng >= 500kg
SELECT * FROM Orders WHERE Freight >= 500 ORDER BY Freight DESC

-- 15. Xem thông tin đơn hàng, sắp xếp giảm dần theo trọng lượng, trọng lượng từ 100 đến 500 và ship bởi city
-- giao vận tải số 1
SELECT * FROM Orders WHERE Freight <= 500 AND Freight >= 100 AND ShipVia = 1 ORDER BY Freight DESC
