<%-- 
    Document   : header
    Created on : Mar 14, 2023, 3:15:46 PM
    Author     : khami
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .ticketLink{
                font-weight: bold;
                background: rgba(0, 0, 0, 0.2);
                padding: 10px 0 !important;
                border: 1px rgba(255, 255, 255, 0.7) solid;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <nav class="gtco-nav" role="navigation">
            <div class="gtco-container">

                <div class="row">
                    <div class="col-sm-4 col-xs-12">
                        <div id="gtco-logo"><a href="home">Book And Fly<em>.</em></a></div>
                    </div>
                    <div class="col-xs-8 text-right menu-1">
                        <ul>
                            <li class="ticketLink"><a href="ticket">Hoạt động đặt vé của tôi</a></li>
                            <li class="has-dropdown">
                                <a href="#">Travel</a>
                                <ul class="dropdown">
                                    <li><a href="#">Europe</a></li>
                                    <li><a href="#">Asia</a></li>
                                    <li><a href="#">America</a></li>
                                    <li><a href="#">Canada</a></li>
                                </ul>
                            </li>
                            <li><a href="pricing.html">Pricing</a></li>
                            <c:if test="${sessionScope.user!=null}">
                                <li><a href="profile">${sessionScope.user.fullName}</a></li>
                                <li><a href="logout">Log Out</a></li>

                            </c:if> 
                            <c:if test="${sessionScope.user==null}">
                                <li><a href="login">Login</a></li>
                            </c:if>
                        </ul>	
                    </div>
                </div>  

            </div>
        </nav>
    </body>
</html>
