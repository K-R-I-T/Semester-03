USE Northwind

----------------------------------------------------------------------------------
-- LÝ THUYẾT
-- CÚ PHÁP MỞ RỘNG LỆNH SELECT:
-- TA MUỐN SẮP XẾP DỮ LIỆU/ SORT THEO TIÊU CHÍ NÀO ĐÓ, THƯỜNG LÀ TĂNG DẦN - ASCENDING/ASC
--																 GIẢM DẦN - DESCENDING/DESC
-- MẶC ĐỊNH LÀ SORT TĂNG DẦN
-- TA CÓ THỂ SORT TRÊN NHIỀU CỘT
-- SELECT ... FROM <TÊN-TABLE> ORDER BY TÊN-CỘT MUỐN SORT <KIỂU SORT>
----------------------------------------------------------------------------------
	
-- 1. In ra danh sách nhân viên
SELECT * From Employees

-- 2. In ra ds nv tăng dần theo năm sinh
SELECT * FROM Employees ORDER BY BirthDate ASC

SELECT * FROM Employees ORDER BY BirthDate 

-- 3. In ra ds nv giảm dần theo năm sinh
SELECT * FROM Employees ORDER BY BirthDate DESC

-- 4. Tính tiền chi tiết mua hàng
SELECT *, UnitPrice * Quantity * (1 - Discount) AS SubTotal FROM [Order Details]

-- 5. Tính tiền chi tiết mua hàng, sắp xếp giảm dần theo số tiền
SELECT *, UnitPrice * Quantity * (1 - Discount) AS SubTotal FROM [Order Details] ORDER BY SubTotal DESC

-- 6. In ra ds nv giảm dần theo tuổi
SELECT EmployeeID, LastName, FirstName, BirthDate, YEAR(GETDATE()) - YEAR(BirthDate) AS Age FROM Employees ORDER BY Age DESC
