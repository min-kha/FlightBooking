
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
        <title>User Controller</title>
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
                                                <th>ID</th>
                                                <th>Username</th>
                                                <th>Fullname</th>
                                                <th>Email</th>
                                                <th>Phone</th>
                                                <th>Address</th>
                                                <th>Role</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>ID</th>
                                                <th>Username</th>
                                                <th>Fullname</th>
                                                <th>Email</th>
                                                <th>Phone</th>
                                                <th>Address</th>
                                                <th>Role</th>
                                                <th></th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                        <c:forEach items="${users}" var="u">
                                            <tr>
                                                <td>${u.userID}</td>
                                                <td>${u.username}</td>
                                                <td>${u.fullName}</td>
                                                <td>${u.email}</td>
                                                <td>${u.phoneNumber}</td>
                                                <td>${u.address}</td>
                                                <td>${u.role==0?'Admin':'User'}</td>
                                                <td>
                                                    <form method="POST" action="/FlightBooking/userController/delete">
                                                        <input value="${u.userID}" name="userID" type="hidden"/>
                                                        <input value="Delete" class="btn btn-danger btn-sm " tabindex="-1" type="submit" aria-disabled="true">
                                                    </form>

                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="container-fluid px-4" >                       
                        <button onclick="add.style.display='block';" class="btn btn-primary btn-lg " tabindex="-1" role="button" aria-disabled="true">Add a new account</button>
                    </div>
                        <div id="add" style="display: none; padding: 20px; margin: 20px auto 20px 30px; width: 500px; border: 1px #666666 solid; border-radius: 10px;">
                        <form method="post" action="/FlightBooking/userController/register">
                            <h3 style="text-align: center;">Thêm tài khoản user/admin </h3>
                            <div class="form-group-lg mb-3 border-dark">
                                <label for="username">Username</label>
                                <input class="form-control" id="username" name="username" type="text" value="" required >
                            </div>
                            <div class="form-group-lg mb-3">
                                <label for="fullname">Password</label>
                                <input class="form-control" id="password" name="password" type="text" value="" required>
                            </div>
                            <div class="form-group-lg mb-3">
                                <label for="fullname">Full Name</label>
                                <input class="form-control" id="fullname" name="fullName" type="text" value="" required>
                            </div>
                            <div class="form-group-lg mb-3">
                                <label for="email">Email</label>
                                <input class="form-control" id="email" name="email" type="email" value="" required>
                            </div>
                            <div class="form-group-lg mb-3">
                                <label for="address">Address</label>
                                <input class="form-control" id="address" name="address" type="text" value="" required>
                            </div>
                            <div class="form-group-lg mb-3">
                                <label for="phone">Phone Number</label>
                                <input class="form-control" id="phone" name="phoneNumber" type="text" value="" required>
                            </div>
                            <div class="form-group-lg mb-3">
                                <label for="role">Role: </label>
                                <label><input id="role" name="role" type="radio" value="0" required> Admin</label>
                                <label><input id="role" name="role" type="radio" value="1" required> User </label>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                <button type="submit" class=" button btn btn-primary">Add</button>
                            </div>
                        </form>
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

