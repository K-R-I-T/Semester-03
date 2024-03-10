USE Northwind

----------------------------------------------------------------------------------
-- LÝ THUYẾT
-- DÙNG SELECT ĐỂ XEM/IN DỮ LIỆU TỪ TABLE, HIỆN THỊ DƯỚI DẠNG TABLE
-- CÚ PHÁP CHUẨN: SELECT * FOMR <TÊN TABLE>
--                       * ĐẠI DIỆN CHO VIỆC TUI MÚN LẤY ALL OF COLUMNS
-- CÚ PHÁP MỞ RỘNG: 
--					SELECT TÊN-CÁC-CỘT-MUỐN-LẤY, CÁCH-NHAU-DẤU-PHẨY FROM <TÊN TABLE>
--					SELECT CÓ THỂ DÙNG CÁC HÀM XỮ LÝ CÁC CỘT ĐỂ ĐỘ LẠI THÔNG TIN HIỂN THỊ FROM <TÊN TABLE>
-- Khi ta SELECT ít cột từ table gốc thì có nguy cơ dữ liệu sẽ bị trùng lại
-- Không phải ta bị sai, không phải người thiết kế table và người nhập liệu sai
-- Do chúng ta có nhiều info trùng nhau, nên nếu chỉ tập trung vào data này trùng nhau chắc chắc xảy ra
-- 100 triệu người dân VN được quản lí info bao gồm: ID, Tên, DOB,... Tỉnh thành sinh sống
--													 <>				  63 tỉnh
-- Lệnh SELECT hỗ trợ lệnh loại trừ trùng nhau 100%
-- SELECT DISTINCT TÊN-CÁC-CỘT FROM <TÊN-TABLE>
----------------------------------------------------------------------------------
SELECT * FROM Employees
-- Phân tích 9 người nhưng chỉ có 4 title.
SELECT DISTINCT TitleOfCourtesy FROM Employees -- Chỉ là 4

SELECT DISTINCT EmployeeID, TitleOfCourtesy FROM Employees -- Nếu DISTINCT đi kèm với key thì vô dụng, key không trùng

-- 2. In ra thông tin khách hàng
SELECT * FROM Customers -- 92 rows

-- 3. Có bao nhiêu quốc gia xuất hiện trong thông tin khách hàng, in ra
SELECT DISTINCT Country FROM Customers -- 22 rows
