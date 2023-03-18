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
        <link rel="shortcut icon" href="images/161-1616544_popcorn-icon-cinema-flat-icon-png.png" type="">

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
                width: 50%;
            }
            .btn {
                background-color: #0077be;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                font-size: 18px;
                font-weight: bold;
                cursor: pointer;
            }

            .btn:hover {
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
        <section class="" >
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                    <div class="card" style="border-radius: 1rem;">

                        <div class="d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form method="post" action="login">

                                    <div class="d-flex align-items-center mb-3 pb-1" >
                                        <h1 style="font-family: fantasy; opacity: 0.8; text-transform: uppercase;">Book And Fly</h1>
                                    </div>

                                    <h2 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your
                                        account</h2>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example17">Username or email</label>
                                        <input type="text" id="form2Example17"
                                               class="form-control form-control-lg" placeholder="Your Username or email" name="username"/>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example27">Password</label>
                                        <input type="password" id="form2Example27"
                                               class="form-control form-control-lg" placeholder="Password" name="pass"/>
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-group-justified" type="submit">Login</button>
                                    </div>

                                    <p class="mb-5 pb-lg-2 " style="color: #393f81;">
                                        Don't have an account? 
                                        <a class="register" href="register">Register here</a>
                                    </p>
                                    <a href="#!" class="small text-muted">Terms of use.</a>
                                    <a href="#!" class="small text-muted">Privacy policy</a>
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
