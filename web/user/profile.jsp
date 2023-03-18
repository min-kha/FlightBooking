<%-- 
    Document   : login
    Created on : Mar 14, 2023, 11:26:59 PM
    Author     : khami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="images/icon.png" type="image/gif">

        <title>Login</title>

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
        <style>
            body {
                background: url("images/background.jpg") repeat;
                background-color: #0077be;
                font-family: Arial, sans-serif;
                color: #000;
            }
            .card{
                padding: 30px;
                margin: 140px auto;
                opacity: 0.7;
                height: auto;
            }
            .button {
                background-color: #0077be;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                font-size: 18px;
                font-weight: bold;
                cursor: pointer;
            }

            .button:hover {
                background-color: #00509e;
                color: #fff;
            }
            .register{
                font-size: 20px;
                font-weight: bold;
                color: #00509e;
                opacity: 0.7;
            }
            .register:hover{
                font-size: 26px;
                color: #393f81;
                font-weight: bold;
                opacity: 0.9;
            }


        </style>
    </head>
    <body>
        <!-- Section: Design Block -->
        <jsp:include page="../component/header.jsp"/>
        <section class="py-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <div class="card shadow-lg border-0 rounded-lg">
                            <div class="card-header">
                                <h3 class="text-center font-weight-light my-4">User Profile</h3>
                            </div>
                            <div class="card-body">
                                <form method="post" action="userController/update">
                                    <div class="form-group-lg mb-3 border-dark">
                                        <label for="username">Username</label>
                                        <input class="form-control" id="username" name="username" type="text" value="${user.username}" readonly>
                                    </div>
                                    <div class="form-group-lg mb-3">
                                        <label for="fullname">Full Name</label>
                                        <input class="form-control" id="fullname" name="fullname" type="text" value="${user.fullName}" required>
                                    </div>
                                    <div class="form-group-lg mb-3">
                                        <label for="email">Email</label>
                                        <input class="form-control" id="email" name="email" type="email" value="${user.email}" required>
                                    </div>
                                    <div class="form-group-lg mb-3">
                                        <label for="address">Address</label>
                                        <input class="form-control" id="address" name="address" type="text" value="${user.address}" required>
                                    </div>
                                    <div class="form-group-lg mb-3">
                                        <label for="phone">Phone Number</label>
                                        <input class="form-control" id="phone" name="phone" type="text" value="${user.phoneNumber}" required>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <a class=" btn btn-secondary" href="<%=request.getContextPath()%>/profile">Cancel</a>
                                        <button type="submit" class=" button btn btn-primary">Update Profile</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="../component/footer.jsp"/>

    </body>
</html>
