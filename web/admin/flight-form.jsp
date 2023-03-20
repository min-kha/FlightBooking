<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Flight Controller</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/FlightBooking/admin/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="/admin/component/nav.jsp"></jsp:include>
            <div id="layoutSidenav">
                <div id="layoutSidenav_nav">
                <jsp:include page="/admin/component/navLeft.jsp"></jsp:include>
                </div>
                <div id="layoutSidenav_content">

                    <div class="container">
                        <h2>Thêm/Sửa chuyến bay</h2>
                        <form action="${pageContext.request.contextPath}/flight/update" method="POST">
                        <c:if test="${flight != null}">
                            Mã chuyến bay: <input type="text" name="flightID" value="${flight.flightID}" readonly/>
                        </c:if>
                        <br>
                        <br>
                        <label for="routeID">Mã tuyến bay:</label>
                        <select name="routeID">
                            <c:forEach items="${routes}" var="r">
                                <c:choose>
                                    <c:when test="${r.routeID == flight.routeID}">
                                        <option value="${r.routeID}" selected>${r.getDepartureCityName()} - ${r.getArrivalCityName()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${r.routeID}">${r.getDepartureCityName()} - ${r.getArrivalCityName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select><br><br>
                        <label for="departureTime">Thời gian khởi hành:</label>
                        <input type="datetime-local" name="departureTime" value="${flight.departureTime}"><br><br>
                        <label for="duration">Thời gian bay (phút):</label>
                        <input type="number" name="duration" min="1" value="${flight.duration}"><br><br>
                        <label for="capacity">Số lượng ghế:</label>
                        <input type="number" name="capacity" min="1" value="${flight.capacity}"><br><br>
                        <label for="ticketType">Loại vé:</label>
                        <select name="ticketType">
                            <c:choose>
                                <c:when test="${flight.ticketType eq 'Phổ thông'}">
                                    <option value="Phổ thông" selected>Phổ thông</option>
                                    <option value="Thương gia">Thương gia</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="Phổ thông" >Phổ thông</option>
                                    <option value="Thương gia"selected>Thương gia</option>
                                </c:otherwise>
                            </c:choose>
                        </select><br><br>
                        <label for="price">Giá vé:</label>
                        <input type="number" name="price" min="1" value="${flight.price}"><br><br>
                        <input type="submit" value="Lưu">
                    </form>
                </div>
                <jsp:include page="/admin/component/footer.jsp"></jsp:include>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/FlightBooking/admin/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="/FlightBooking/admin/assets/demo/chart-area-demo.js"></script>
        <script src="/FlightBooking/admin/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="/FlightBooking/admin/js/datatables-simple-demo.js"></script>
    </body>
</html>

