USE master;
IF EXISTS(SELECT * FROM sys.databases WHERE name = 'FlightBookingDB')
BEGIN
    ALTER DATABASE FlightBookingDB SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE FlightBookingDB;
END
GO

CREATE DATABASE FlightBookingDB;
GO

USE FlightBookingDB;
GO

CREATE TABLE [User] (
  UserID INT PRIMARY KEY IDENTITY(1,1),
  Username VARCHAR(50) NOT NULL,
  Password VARCHAR(50) NOT NULL,
  FullName NVARCHAR(255) NOT NULL,
  Email NVARCHAR(255) NOT NULL,
  PhoneNumber NVARCHAR(20) NOT NULL,
  Address NVARCHAR(255) NOT NULL,
  Role BIT NOT NULL, -- 0 = admin, 1 = user
  CONSTRAINT CHK_User_PhoneNumber CHECK (PhoneNumber LIKE '[0-9]%')
);

CREATE TABLE City (
  CityID INT PRIMARY KEY IDENTITY(1,1),
  CityName NVARCHAR(255) NOT NULL
);

CREATE TABLE TicketType (
  TicketTypeID INT PRIMARY KEY IDENTITY(1,1),
  TicketTypeName NVARCHAR(255) NOT NULL
);

CREATE TABLE Route (
  RouteID INT PRIMARY KEY IDENTITY(1,1),
  DepartureCityID INT NOT NULL,
  ArrivalCityID INT NOT NULL,
  Distance INT NOT NULL,
  FOREIGN KEY (DepartureCityID) REFERENCES City(CityID),
  FOREIGN KEY (ArrivalCityID) REFERENCES City(CityID)
);

CREATE TABLE RoutePrice (
  RoutePriceID INT PRIMARY KEY IDENTITY(1,1),
  RouteID INT NOT NULL,
  TicketTypeID INT NOT NULL,
  Price FLOAT NOT NULL,
  FOREIGN KEY (RouteID) REFERENCES Route(RouteID),
  FOREIGN KEY (TicketTypeID) REFERENCES TicketType(TicketTypeID)
);

CREATE TABLE Flight (
  FlightID INT PRIMARY KEY IDENTITY(1,1),
  RouteID INT NOT NULL,
  DepartureTime DATETIME NOT NULL,
  Duration INT NOT NULL,
  Capacity INT NOT NULL,
  FOREIGN KEY (RouteID) REFERENCES Route(RouteID),
  CONSTRAINT CHK_Flight_Duration CHECK (Duration > 0)
);

CREATE TABLE Booking (
  BookingID INT PRIMARY KEY IDENTITY(1,1),
  UserID INT NOT NULL,
  FlightID INT NOT NULL,
  BookingTime DATETIME NOT NULL,
  IsPaid BIT NOT NULL, -- 0 = Postpaid(Trả sau), 1 = Paid(Trả trước)
  FOREIGN KEY (UserID) REFERENCES [User](UserID),
  FOREIGN KEY (FlightID) REFERENCES Flight(FlightID)
);


-------------- INSERT DATA -----------------
GO
INSERT INTO [User] (Username, Password, FullName, Email, PhoneNumber, Address, Role)
VALUES ('admin', '123456', N'Nguyễn Văn A', 'admin@gmail.com', '0987654321', N'Hà Nội', 0),
('tranthiB', '123456', N'Trần Thị B', 'tranthib@gmail.com', '0123456789', N'Hồ Chí Minh', 1),
('user1', 'password1', N'Huỳnh Văn A', 'user1@example.com', '0901234567', N'123 Đường Lê Lợi, Quận 1, TP.HCM', 1),
('user2', 'password2', N'Nguyễn Thị B', 'user2@example.com', '0902345678', N'456 Đường Nguyễn Huệ, Quận 3, TP.HCM', 1),
('user3', 'password3', N'Trần Văn C', 'user3@example.com', '0903456789', N'789 Đường Tôn Thất Tùng, Quận 1, TP.HCM', 1),
('user4', 'password4', N'Lê Thị D', 'user4@example.com', '0904567890', N'0123 Đường Hàm Nghi, Quận 1, TP.HCM', 1),
('user5', 'password5', N'Phạm Văn E', 'user5@example.com', '0905678901', N'456 Đường Bùi Thị Xuân, Quận 1, TP.HCM', 1),
('user6', 'password6', N'Hoàng Thị F', 'user6@example.com', '0906789012', N'789 Đường Điện Biên Phủ, Quận 3, TP.HCM', 1),
('user7', 'password7', N'Vũ Văn G', 'user7@example.com', '0907890123', N'0123 Đường Trần Phú, Quận 5, TP.HCM', 1),
('user8', 'password8', N'Đinh Thị H', 'user8@example.com', '0908901234', N'456 Đường Nguyễn Văn Cừ, Quận 4, TP.HCM', 1),
('user9', 'password9', N'Ngô Văn I', 'user9@example.com', '0909012345', N'789 Đường Trương Định, Quận 3, TP.HCM', 1),
('user10', 'password10', N'Lương Thị K', 'user10@example.com', '0900123456', N'0123 Đường Cách Mạng Tháng 8, Quận 1, TP.HCM', 1),
('user11', 'password11', N'Nguyễn Văn L', 'user11@example.com', '0901234567', N'456 Đường Nguyễn Thị Minh Khai, Quận 3, TP.HCM', 1),
('user12', 'password12', N'Lê Thị M', 'user12@example.com', '0902345678', N'789 Đường Phan Văn Trị, Quận Gò Vấp, TP.HCM', 1);

INSERT INTO City (CityName) VALUES
(N'Hồ Chí Minh'),
(N'Hà Nội'),
(N'Đà Nẵng'),
(N'Nha Trang'),
(N'Đà Lạt');

INSERT INTO TicketType (TicketTypeName) VALUES
(N'Economy'),
(N'Business'),
(N'First Class');

INSERT INTO Route (DepartureCityID, ArrivalCityID, Distance) VALUES
(1, 2, 1167),
(2, 1, 1167),
(1, 3, 518),
(3, 1, 518),
(1, 4, 411),
(4, 1, 411),
(1, 5, 308),
(5, 1, 308);

INSERT INTO RoutePrice (RouteID, TicketTypeID, Price) VALUES
(1, 1, 50),
(1, 2, 100),
(1, 3, 200),
(2, 1, 50),
(2, 2, 100),
(2, 3, 200),
(3, 1, 30),
(3, 2, 70),
(3, 3, 150),
(4, 1, 30),
(4, 2, 70),
(4, 3, 150),
(5, 1, 25),
(5, 2, 60),
(5, 3, 120),
(6, 1, 25),
(6, 2, 60),
(6, 3, 120),
(7, 1, 20),
(7, 2, 50),
(7, 3, 100),
(8, 1, 20),
(8, 2, 50),
(8, 3, 100);

INSERT INTO Flight (RouteID, DepartureTime, Duration, Capacity)
VALUES
(1, '2023-03-10 09:00:00', 120, 200),
(2, '2023-03-11 14:30:00', 90, 150),
(3, '2023-03-12 08:15:00', 180, 300),
(4, '2023-03-13 10:45:00', 120, 200),
(5, '2023-03-14 16:20:00', 90, 150);

INSERT INTO Booking (UserID, FlightID, BookingTime, IsPaid)
VALUES (1, 1, '2023-03-11 14:30:00', 1),
(2, 2, '2023-03-15 10:00:00', 0),
(1, 1, '2023-03-09 10:30:00', 0),
(2, 2, '2023-03-10 16:45:00', 1),
(3, 3, '2023-03-11 12:00:00', 1),
(4, 4, '2023-03-12 08:30:00', 1),
(5, 5, '2023-03-13 17:15:00', 0);



