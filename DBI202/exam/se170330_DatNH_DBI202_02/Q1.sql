CREATE TABLE PHONGMAY(
	Maph int PRIMARY KEY,
	Tenph nvarchar(15),
	Tenngql nvarchar(25)
)
GO

CREATE TABLE MONHOC(
	Mamon nchar(4) PRIMARY KEY,
	Tenmon nvarchar(30),
	Sotc int
)
GO

CREATE TABLE DANGKY(
	Id_dk int IDENTITY(1,1) PRIMARY KEY,
	Ca int,
	Ngaydk DATE,
	Maph int FOREIGN KEY REFERENCES PHONGMAY(Maph),
	Mamon nchar(4) FOREIGN KEY REFERENCES MONHOC(Mamon)
)