<%-- 
    Document   : infomation
    Created on : Mar 12, 2023, 4:29:28 PM
    Author     : khami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Xác nhận đặt vé</title>
        <!-- Font Google -->
        <link href="https://fonts.googleapis.com/css?family=Roboto%20Mono" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Tùy chỉnh stylesheet -->
        <link type="text/css" rel="stylesheet" href="css/styleBookingForm.css" />

        <style>
            body {
                background: url("images/background.jpg") repeat;
                background-color: #0077be;
                font-family: Arial, sans-serif;
                color: #000;
            }

            .container {
                margin: 40px auto;
                padding: 20px;
                opacity: 0.7;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
                width: 100%;
            }

            h1{
                text-align: center;
                font-size: 36px;
                font-weight: bold;
                margin-top: 50px;
            }
            h2{
                text-align: center;
                font-weight: bold;
            }

            label {
                font-size: 18px;
                font-weight: bold;
            }

            input, select {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: none;
                border-radius: 5px;
                box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
            }

            form{
                display: block;
            }
            input[type="submit"], .thanhToan {
                width: auto;
                margin: 20px 20px;
                background-color: #0077be;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                font-size: 18px;
                font-weight: bold;
                cursor: pointer;
            }
            input[value="Giữ chỗ"] {
                background-color: gray;
            }
            input[type="submit"]:hover, .thanhToan:hover {
                background-color: #00509e;
            }


            .main{
                display: flex;
                justify-content: center;
                align-items: flex-start;
                padding: 10px;
            }
            .left{
                padding: 0 80px;
                width: 90%;
                padding-right: 20px;
            }
            .right{
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
                padding: 20px;
                margin-top: 40px;
                opacity: 0.7;
                width: 60%;
            }
            .right span{
                color: #cc3300;
                font-weight: bold;
            }
            .payment-container{
                display: none;
            }
            #xacNhan{
                display: none;
            }
        </style> 



    </head>
    <body>
        <h1 style="text-align: center; margin-bottom: 30px; color: red; text-shadow: 1px 1px 2px black;">Đăng ký mua vé máy bay thành công!</h1>
        <div class="main">        
            <div class="left">
                <form method="post" action="confirmation">
                    <c:forEach items="${passengerInfos}" var="passenger" varStatus="status">
                        <div class="container">
                            <h2>Thông tin hành khách ${status.index + 1}</h2>
                            <label for="fullName">Họ tên:</label>
                            <input type="text" name="fullName_${status.index + 1}" value="${passenger.fullName}" readonly required><br>
                            <label for="email">Email:</label>
                            <input type="email" name="email_${status.index + 1}" value="${passenger.email}" readonly required><br>
                            <label for="phoneNumber">Số điện thoại:</label>
                            <input type="tel" name="phoneNumber_${status.index + 1}" value="${passenger.phoneNumber}" readonly required><br>
                            <label for="address">Địa chỉ:</label>
                            <input type="text" name="address_${status.index + 1}" value="${passenger.address}" readonly required/><br>
                            <label for="passportNumber">Số hộ chiếu/CCCD:</label>
                            <input type="text" name="passportNumber_${status.index + 1}" value="${passenger.passportNumber}" readonly required><br>
                            <label for="dateOfBirth">Ngày sinh:</label>
                            <input type="date" name="dateOfBirth_${status.index + 1}" value="${passenger.dateOfBirth}" readonly required><br>
                        </div>
                    </c:forEach>
                    <%
                        System.out.println("Information.jsp: " + session.getAttribute("passengerInfos"));
                    %>
                </form>
            </div>
            <div class="right">
                <form action="confirmation" method="post">
                    <h2>Đơn hàng của bạn</h2>
                    <hr>
                    <div>
                        <h3>Khởi hành từ  <span>${sessionScope.from} </span>  đến  <span> ${sessionScope.to}</span></h3>
                        <h4>Giờ bay:    <span><fmt:formatDate pattern="HH:mm - dd/MM/yyyy" type="date" value="${sessionScope.flight.departureTime}"/></span></h4>
                    </div>
                    <hr>
                    <div>
                        <h4> Hạng vé: <span>${sessionScope.flight.ticketType}</span></h4>
                    </div>
                    <hr>
                    <div>
                        <h4>Số hành khách:    <span><fmt:formatNumber type="NUMBER" value="${numPassengers}"/> người</span></h4>
                        <div>Giá mỗi người:    <span><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" type="NUMBER" value="${sessionScope.flight.price}"/> vnđ</span> </div>
                        <div>Tổng thuế:   <span><fmt:formatNumber  minFractionDigits="2" maxFractionDigits="2" type="NUMBER" value="${numPassengers*sessionScope.flight.price*0.1}"/> vnđ</span></div>
                    </div>
                    <hr>
                    <div>
                        <h3>Tổng số tiền:   <span><fmt:formatNumber  minFractionDigits="2" maxFractionDigits="2" type="NUMBER" value="${numPassengers*sessionScope.flight.price*110/100}"/> vnđ</span></h3>
                    </div>
                    <div style="display: flex; justify-content: center;">  
                        <input type="submit" class="submit-btn" value="Giữ chỗ">
                        <button type="button" id='thanhToan' class="submit-btn thanhToan" onclick="boxThanhToan.style.display = 'block';">Thanh toán ngay</button>
                    </div>
                </form>
                <div class="payment-container" id='boxThanhToan'>
                    <form action="pay" method="POST">
                        <div class="form-group">
                            <label for="card-number">Số thẻ:</label>
                            <input type="text" class="form-control required" id="card-number" name="card-number" placeholder="Nhập số thẻ của bạn" required>
                        </div>
                        <div class="form-group">
                            <label for="card-holder">Tên chủ thẻ:</label>
                            <input type="text" class="form-control required" id="card-holder" name="card-holder" placeholder="Nhập tên trên thẻ của bạn" required>
                        </div>
                        <div class="form-group">
                            <label for="expiry-date">Ngày hết hạn:</label>
                            <input type="text" class="form-control required" id="expiry-date" name="expiry-date" placeholder="MM/YY" required>
                        </div>
                        <div class="form-group">
                            <label for="cvv">CVV:</label>
                            <input type="text" class="form-control required" id="cvv" name="cvv" placeholder="Nhập số CVV trên mặt sau thẻ của bạn" required>
                        </div>
                        <input type="submit" class="submit-btn thanhToan" value="Thanh toán"  onclick="xacNhan.style.display = 'block';"">
                        <p id="xacNhan" class="alert-success" style="color: green; font-size: large;">Thanh toán thành công!</p>
                    </form>
                </div>

            </div>
        </div>
        <script>
//            function validateForm() {
//                var requiredFields = document.getElementsByClassName("required");
//                var errorMessage = "";
//
//                for (var i = 0; i < requiredFields.length; i++) {
//                    if (requiredFields[i].value === "") {
//                        errorMessage += requiredFields[i].name + " là bắt buộc. \n";
//                    }
//                }
//
//                if (errorMessage !== "") {
//                    alert(errorMessage);
//                    return false;
//                }
//                return true;
//            }

        </script>
    </body>
</html>
