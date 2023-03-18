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

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/styleListFlight.css">
        <link rel="shortcut icon" href="images/icon.png" type="image/gif">

    </head>
    <body>
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
                            <table class="table table-responsive-xl">
                                <thead>
                                    <tr>
                                        <!--<th>&nbsp;</th>-->
                                        <th>Khởi hành</th>
                                        <th>Thời gian</th>	
                                        <th>Còn trống</th>
                                        <th>Loại vé</th>
                                        <th>Giá vé</th>
                                        <th>Trạng thái</th>
                                        <th>&nbsp;</th>
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
                                            <td>
                                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                    <span aria-hidden="true"><i class="fa fa-close"></i></span>
                                                </button>
                                            </td>
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

    </body>
</html>

