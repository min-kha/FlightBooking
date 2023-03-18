<%-- 
    Document   : booking
    Created on : Mar 10, 2023, 3:39:49 PM
    Author     : khami
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Những dòng trên cần phải được đặt đầu tiên trong phần head; bất kỳ nội dung phần head nào khác cần phải được đặt *sau* những thẻ này -->

        <title>Form Đặt Chỗ</title>

        <!-- Font Google -->
        <link href="https://fonts.googleapis.com/css?family=Roboto%20Mono" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <!-- Tùy chỉnh stylesheet -->
        <link type="text/css" rel="stylesheet" href="css/styleBookingForm.css" />
        <style>
            .section {
                position: relative;
                height: 100vh;
            }

            .section .section-center {
                position: absolute;
                top: 50%;
                left: 0;
                right: 0;
                -webkit-transform: translateY(-50%);
                transform: translateY(-50%);
            }

            #booking {
                font-family: 'PT Sans', sans-serif;
                background-image: url('../images/background.jpg');
                background-size: cover;
                background-position: center;
            }

            .booking-form {
                background: rgba(0, 0, 0, 0.7);
                padding: 40px;
                border-radius: 6px;
            }

            .booking-form .form-group {
                position: relative;
                margin-bottom: 20px;
            }

            .booking-form .form-control {
                background-color: #fff;
                height: 50px;
                color: #191a1e;
                border: none;
                font-size: 16px;
                font-weight: 400;
                -webkit-box-shadow: none;
                box-shadow: none;
                border-radius: 40px;
                padding: 0px 25px;
            }

            .booking-form .form-control::-webkit-input-placeholder {
                color: rgba(82, 82, 84, 0.4);
            }

            .booking-form .form-control:-ms-input-placeholder {
                color: rgba(82, 82, 84, 0.4);
            }

            .booking-form .form-control::placeholder {
                color: rgba(82, 82, 84, 0.4);
            }

            .booking-form input[type="date"].form-control:invalid {
                color: rgba(82, 82, 84, 0.4);
            }

            .booking-form select.form-control {
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
            }

            .booking-form select.form-control+.select-arrow {
                position: absolute;
                right: 10px;
                bottom: 6px;
                width: 32px;
                line-height: 32px;
                height: 32px;
                text-align: center;
                pointer-events: none;
                color: rgba(0, 0, 0, 0.3);
                font-size: 14px;
            }

            .booking-form select.form-control+.select-arrow:after {
                content: '\279C';
                display: block;
                -webkit-transform: rotate(90deg);
                transform: rotate(90deg);
            }

            .booking-form .form-label {
                display: block;
                margin-left: 20px;
                margin-bottom: 5px;
                font-weight: 400;
                text-transform: uppercase;
                line-height: 24px;
                height: 24px;
                font-size: 12px;
                color: #fff;
            }

            .booking-form .form-checkbox input {
                position: absolute !important;
                margin-left: -9999px !important;
                visibility: hidden !important;
            }

            .booking-form .form-checkbox label {
                position: relative;
                padding-top: 4px;
                padding-left: 30px;
                font-weight: 400;
                color: #fff;
            }

            .booking-form .form-checkbox label+label {
                margin-left: 15px;
            }

            .booking-form .form-checkbox input+span {
                position: absolute;
                left: 2px;
                top: 4px;
                width: 20px;
                height: 20px;
                background: #fff;
                border-radius: 50%;
            }

            .booking-form .form-checkbox input+span:after {
                content: '';
                position: absolute;
                top: 50%;
                left: 50%;
                width: 0px;
                height: 0px;
                border-radius: 50%;
                background-color: #f23e3e;
                -webkit-transition: 0.2s all;
                transition: 0.2s all;
                -webkit-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }

            .booking-form .form-checkbox input:not(:checked)+span:after {
                opacity: 0;
            }

            .booking-form .form-checkbox input:checked+span:after {
                opacity: 1;
                width: 10px;
                height: 10px;
            }

            .booking-form .form-btn {
                margin-top: 27px;
            }

            .booking-form .submit-btn {
                color: #fff;
                background-color: #f23e3e;
                font-weight: 400;
                height: 50px;
                font-size: 14px;
                border: none;
                width: 100%;
                border-radius: 40px;
                text-transform: uppercase;
                -webkit-transition: 0.2s all;
                transition: 0.2s all;
            }

            .booking-form .submit-btn:hover,
            .booking-form .submit-btn:focus {
                opacity: 0.9;
            }
        </style>
    </head>

    <body>
        <div id="booking" class="section">
            <div class="section-center">
                <div class="container">
                    <div class="row">
                        <div class="booking-form">
                            <form action="booking" method="post">
                                <div class="form-group">
                                    <div class="form-checkbox">
                                        <label for="roundtrip" onclick="openReturnDate();">
                                            <input type="radio" id="roundtrip" name="flightType" value="roundTrip" checked>
                                            <span></span>Khứ hồi
                                        </label>
                                        <label for="one-way" onclick="hiddenReturnDate();"> 
                                            <input type="radio" id="one-way" name="flightType" value="oneWay" >
                                            <span></span>Một chiều
                                        </label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <span class="form-label" for="from">Đi từ</span>
                                            <select class="form-control" id="from" name="from" onchange="checkCityFrom()">
                                                <option value="0">Chọn thành phố bắt đầu</option>
                                                <c:forEach items="${cities}" var="city">
                                                    <option value="${city.cityID}">${city.cityName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <span class="form-label" for="to">Đến</span>
                                            <select class="form-control" id="to" name="to" onchange="checkCityTo();">
                                                <option value="0">Chọn thành phố điểm đến</option>
                                                <c:forEach items="${cities}" var="city">
                                                    <option value="${city.cityID}">${city.cityName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <span class="form-label" for="departureDate">Khởi hành</span>
                                            <input class="form-control" type="date" id="departureDate" name="departureDate" required onchange="checkDate()">
                                        </div>
                                    </div>
                                    <div class="col-md-3" id="returnDateBox" style="opacity: 1; transition: opacity 1s ">
                                        <div class="form-group">
                                            <span class="form-label"  for="returnDate">Trở về</span>
                                            <input class="form-control" type="date" id="returnDate" name="returnDate" required onchange="checkDate()">
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <span class="form-label" for="adults">Người lớn (18+)</span>
                                            <select class="form-control" id="adults" name="adults">
                                                <c:forEach step="1" begin="1" end="10" var="i">
                                                    <option value="${i}">${i}</option>
                                                </c:forEach>
                                            </select>
                                            <span class="select-arrow"></span>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <span class="form-label" for="children">Trẻ em (0-17)</span>
                                            <select class="form-control" id="children" name="children">
                                                <c:forEach step="1" begin="0" end="10" var="i">
                                                    <option value="${i}">${i}</option>
                                                </c:forEach>
                                            </select>
                                            <span class="select-arrow"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <!--                                            <span class="form-label" for="ticketType">Loại vé</span>
                                                                                        <select class="form-control" name="ticketType">
                                                                                                    <option value="1">Phổ thông</option>
                                                                                                    <option value="2">Thương gia</option>
                                                                                        </select>
                                                                                        <span class="select-arrow"></span>-->
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-btn">
                                            <button class="submit-btn">Hiển thị chuyến bay</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function hiddenReturnDate() {
                returnDateBox.style.opacity = "0";
                returnDate.removeAttribute("required");
            }
            function openReturnDate() {
                returnDateBox.style.opacity = "1";
                returnDate.setAttribute("required", "required");
            }
            function checkCityFrom() {
                if (from.value == to.value) {
                    alert('Vui lòng chọn lại điểm đi');
                    from.value = 0;
                }
            }
            function checkCityTo() {
                if (from.value == to.value) {
                    alert('Vui lòng chọn lại điểm đến');
                    to.value = 0;
                }
            }
            function checkDate() {
                if (departureDate.value > returnDate.value && returnDate.value !== '') {
                    alert('Vui lòng chọn lại ngày');
                    returnDate.value = 0;
                }
            }
        </script>
    </body>

</html>
