USE FlightBookingDB;
GO

INSERT INTO [User] (Username, Password, FullName, Email, PhoneNumber, Address, Role)
VALUES ('admin', 'admin', N'Nguyễn Văn Admin', 'admin@example.com', '0123456789', N'Hà Nội', 0);

INSERT INTO [User] (Username, Password, FullName, Email, PhoneNumber, Address, Role)
VALUES ('user', 'user', N'Trần Thị User', 'user@example.com', '0987654321', N'Hồ Chí Minh', 1);

INSERT INTO City (CityName)
VALUES ('Hà Nội'), ('Hồ Chí Minh'), ('Đà Nẵng'), ('Nha Trang'), ('Phú Quốc'), ('Bình Định'), ('Cà Mau'), ('Cần Thơ'), ('Gia Lai'), ('Vinh'), ('Buôn Ma Thuật'), ('Bình Dương');

INSERT INTO Route (DepartureCityID, ArrivalCityID, Distance)
VALUES (1, 2, 1150), (1, 3, 700), (2, 1, 1150), (2, 3, 850), (3, 1, 700), (3, 2, 850);

INSERT INTO Flight (RouteID, DepartureTime, Duration, Capacity, TicketType, Price)
VALUES (1, '2023-03-15 08:00:00', 120, 120, N'Phổ thông', 1500000),
(1, '2023-03-15 12:00:00', 120, 120, N'Thương gia', 3000000),
(1, '2023-03-15 16:00:00', 120, 120, N'Phổ thông', 1500000),
(1, '2023-03-15 20:00:00', 120, 120, N'Thương gia', 3000000),
(1, '2023-03-16 08:00:00', 120, 120, N'Phổ thông', 1500000),
(1, '2023-03-16 12:00:00', 120, 120, N'Thương gia', 3000000),
(1, '2023-03-16 16:00:00', 120, 120, N'Phổ thông', 1500000),
(1, '2023-03-16 20:00:00', 120, 120, N'Thương gia', 3000000),
(1, '2023-03-17 08:00:00', 120, 120, N'Phổ thông', 1500000),
(1, '2023-03-17 12:00:00', 120, 120, N'Thương gia', 3000000),
(1, '2023-03-17 16:00:00', 120, 120, N'Phổ thông', 1500000),
(1, '2023-03-17 20:00:00', 120, 120, N'Thương gia', 3000000),
(2, '2023-03-15 09:00:00', 180, 100, N'Phổ thông', 2000000),
(2, '2023-03-15 15:00:00', 180, 100, N'Thương gia', 4000000),
(2, '2023-03-15 21:00:00', 180, 100, N'Phổ thông', 2000000),
(2, '2023-03-16 09:00:00', 180, 100, N'Phổ thông', 2000000),
(2, '2023-03-16 15:00:00', 180, 100, N'Thương gia', 4000000),
(2, '2023-03-16 21:00:00', 180, 100, N'Phổ thông', 2000000),
(2, '2023-03-17 09:00:00', 180, 100, N'Phổ thông', 2000000),
(2, '2023-03-17 15:00:00', 180, 100, N'Thương gia', 4000000),
(2, '2023-03-17 21:00:00', 180, 100, N'Phổ thông', 2000000)
INSERT INTO Booking (UserID, FlightID, BookingTime, IsPaid)
VALUES (1, 1, GETDATE(), 0),
(1, 2, GETDATE(), 1),
(2, 3, GETDATE(), 0),
(2, 4, GETDATE(), 1);
INSERT INTO PassengerInfo (BookingID, FullName, Email, PhoneNumber, Address, PassportNumber, DateOfBirth)
VALUES (1, N'Nguyễn Văn A', N'nguyenvana@gmail.com', N'0123456789', N'Hà Nội', N'ABC123456', '1990-01-01'),
       (1, N'Phạm Thị B', N'phamthib@gmail.com', N'0987654321', N'Hồ Chí Minh', N'DEF789012', '1995-02-02'),
       (2, N'Trần Văn C', N'tranvanc@gmail.com', N'0123456789', N'Hải Phòng', N'GHI345678', '1998-03-03');