<%-- 
    Document   : listflight
    Created on : Mar 12, 2023, 2:33:58 AM
    Author     : khami
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="dao.CityDAO" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Danh sách chuyến bay</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- bootstrap core css -->

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
              integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
              crossorigin="anonymous" />
        <!-- Custom styles for this template -->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">

        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Themify Icons-->
        <link rel="stylesheet" href="css/themify-icons.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="css/bootstrap.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/bootstrap-datepicker.min.css">

        <!-- Owl Carousel  -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">

        <!-- Theme style  -->
        <link rel="stylesheet" href="css/style.css">

        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
        <script src="js/respond.min.js"></script>
        <![endif]-->

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/styleListFlight.css">
        <link rel="shortcut icon" href="images/icon.png" type="image/gif">

    </head>
    <body>
        <jsp:include page="../component/header.jsp"/>
        <br>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h1>Danh sách chuyến bay</h1>
                        <h2>Từ ${from} đến ${to}</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-wrap">
                            <table class="table table-responsive-xl" id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <!--<th>&nbsp;</th>-->
                                        <th>Khởi hành</th>
                                        <th>Thời gian</th>	
                                        <th>Còn trống</th>
                                        <th>Loại vé</th>
                                        <th>Giá vé</th>
                                        <th>Trạng thái</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="flight" items="${flights}" >
                                        <tr class="alert" role="alert">
                                            <!--                                            <td>
                                                                                            <label class="checkbox-wrap checkbox-primary">
                                                                                                <input type="checkbox" checked>
                                                                                                <span class="checkmark"></span>
                                                                                            </label>
                                                                                        </td>-->
                                            <td><fmt:formatDate value="${flight.departureTime}" pattern="HH:mm dd-MM-yyyy" /></td>
                                            <td>${flight.duration}</td>
                                            <td>${flight.capacity}</td>
                                            <td>${flight.ticketType}</td>
                                            <td><fmt:formatNumber  minFractionDigits="2" maxFractionDigits="2" type="NUMBER" value="${flight.price}"/> đồng</td>
                                            <td class="status"><a href="booking?f=${flight.flightID}"><span class="active">Đặt vé</span></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <style>
            .datatable-pagination-list{
                display: flex;
                justify-content: center;
            }
            .datatable-pagination-list li{
                margin: 5px 10px;
                color: blue;
                width: 40px;
                text-align: center;
                background: #cccccc;
                border-radius: 5px;
                cursor: pointer;
            }

            .datatable-pagination-list li::marker{
                color: white;
            }
            .datatable-pagination-list li a{
                display: inline-block;
                width: 100%;
                color: black;
            }
            .datatable-pagination-list .datatable-active{
                color: red;
            }
            .datatable-input{
                margin-bottom:  10px;
                display: block;
                width: 40%;
                border: #002752;

            }
            .datatable-dropdown{
                margin: 10px;
            }
        </style>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>

