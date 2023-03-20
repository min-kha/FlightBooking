
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <main>
                        <div class="container-fluid px-4">
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-table me-1"></i>
                                    List Categories
                                </div>
                                <div class="card-body">
                                    <table id="datatablesSimple">
                                        <thead>
                                            <tr>
                                                <th>Flight ID</th>
                                                <th>Route ID</th>
                                                <th>Departure Time</th>
                                                <th>Duration (minutes)</th>
                                                <th>Capacity</th>
                                                <th>Ticket Type</th>
                                                <th>Price</th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="flight" items="${flights}">
                                            <tr>
                                                <td>${flight.flightID}</td>
                                                <td>${flight.routeID}</td>
                                                <td>${flight.departureTime}</td>
                                                <td>${flight.duration}</td>
                                                <td>${flight.capacity}</td>
                                                <td>${flight.ticketType}</td>
                                                <td>${flight.price}</td>
                                                <td>
                                                    <a href="/FlightBooking/flight/showFormForUpdate?id=${flight.flightID}" class="btn btn-primary btn-sm " tabindex="-1" aria-disabled="true">Update</a>
                                                </td>
                                                <td>
                                                    <a href="/FlightBooking/flight/delete?id=${flight.flightID}" class="btn btn-danger btn-sm " tabindex="-1" aria-disabled="true">Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="container-fluid px-4" >                       
                        <a href="/FlightBooking/flight/showFormForAdd" class="btn btn-primary btn-lg " tabindex="-1" role="button"
                                aria-disabled="true">Add a new flight</a>
                    </div>
                   
                </main>
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

