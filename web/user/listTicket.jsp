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
        <style>
            td.paid {
                color: green;
                font-weight: bold;
            }

            td.not-paid {
                color: red;
                font-style: italic;
            }

        </style>
    </head>
    <body>
        <section class="ftco-section">
            <div class="container-fluid mb-5">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h1>Danh sách vé của bạn</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-wrap">
                            <table class="table table-responsive-xl">
                                <thead>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>Mã hành khách</th>
                                        <th>Họ và tên</th>	
                                        <th>Từ</th>
                                        <th>Đến</th>
                                        <th>Thời gian bay</th>
                                        <th>Hạng vé</th>
                                        <th>Giá</th>
                                        <th>Thanh toán</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="ticket" items="${tickets}" >
                                        <tr class="alert" role="alert">
                                            <td></td>
                                            <td><fmt:formatNumber value="${ticket.passengerID}"/></td>
                                            <td>${ticket.fullName}</td>
                                            <td>${ticket.from}</td>
                                            <td>${ticket.to}</td>
                                            <td><fmt:formatDate value="${ticket.time}" type="date" pattern="HH:mm dd-MM-yyyy"/></td>
                                            <td>${ticket.type}</td>
                                            <td><fmt:formatNumber value="${ticket.price}" type="NUMBER" minFractionDigits="2" maxFractionDigits="2"/> đồng</td>
                                            <td class="${ticket.isPaid ? 'paid' : 'not-paid'}">${ticket.isPaid ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                                            <td>
                                                <form style="display: none;" action="ticket/delete" method="post" id='form_${ticket.passengerID}'>
                                                    <input type="text" name="passengerId" value="${ticket.passengerID}">
                                                </form>
                                                <button value='${ticket.passengerID}' id='deleteBtn' onclick="deleteTicket(this.value);" style="border:#ffffff; background: white; cursor: pointer; font-size: smaller; font-weight: bold; color: blue; font-style: italic; text-decoration: underline">DELETE</button>
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
        <script>
            function deleteTicket (id) {
                if ('YES' === (prompt("Bạn đang muốn hủy vé!\n Nhập 'YES' để đồng ý hủy vé: "))) {
                    document.getElementById('form_' + id).submit();
                }
            };
        </script>
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

