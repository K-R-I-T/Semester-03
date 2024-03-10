drop table if exists Roles

create table Roles(
RoleID int primary key, 
name nvarchar(100)
);

create table Users(
Username varchar(30) primary key, 
Password nvarchar(20), 
Email nvarchar(200),
RoleID int,
foreign key(RoleID) references Roles(RoleID)
);

create table Permissions(
permissionsID int primary key, 
name nvarchar(50)
);

create table hasPermissions(
RoleID int,
permissionsID int,
primary key(RoleID, permissionsID),
foreign key(RoleID) references Roles(RoleID),
foreign key(permissionsID) references Permissions(permissionsID)
);