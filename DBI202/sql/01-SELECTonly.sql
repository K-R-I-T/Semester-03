USE Northwind -- Chọn gọi với thùng chứa nào đó
			  -- 1 thùng 1 thời điểm

SELECT * FROM Customers

SELECT * FROM Employees
----------------------------------------------------------------------------------
----- LÝ THUYẾT
-- 1. DBE cung cấp câu lệnh SELECT dùng để
--   in ra màn hình 1 cái gì đó ~~~ printf() sout()
--   in ra dữ liệu có trong table (hàng/cột)
--   dùng cho mục đích nào đó thì kết quả luôn là 1 table
----------------------------------------------------------------------------------

-- 1. Hôm nay ngày bao nhiêu?
SELECT GETDATE()

SELECT GETDATE() as [Hôm nay là ngày]

-- 2. Hôm nay tháng mấy?
SELECT MONTH(GETDATE()) as [Bây giờ tháng mấy?]

SELECT YEAR(GETDATE())

-- 3. Trị tuyệt đối của -5 là mấy?
SELECT ABS(-5) AS [Trị tuyệt đối của -5 là mấy?]

-- 4. 5 + 5 là mấy?
SELECT 5 + 5 AS [5 + 5 là...]

-- 5. In ra tên của mình
SELECT N'Nguyễn Hoàng Đạt' AS [My full name is]
SELECT N'Nguyễn ' + N'Hoàng Đạt' AS [My full name is]

-- 6. In ra tuổi
SELECT YEAR(GETDATE()) - 2003

-- SELECT N'Nguyễn ' + N'Hoàng Đạt ' + (YEAR(GETDATE()) - 2003) + ' years old' LỖI VÌ LỘN XỘN KIỂU DATA
SELECT N'Nguyễn ' + N'Hoàng Đạt ' + CAST(YEAR(GETDATE()) - 2003 AS varchar) + ' years old' as [My profile]

SELECT N'Nguyễn ' + N'Hoàng Đạt ' + CONVERT(varchar, YEAR(GETDATE()) - 2003) + ' years old' as MyProfile

-- 7. Phép nhân 2 số
SELECT 10 * 10 AS [10 x 10 = ]
