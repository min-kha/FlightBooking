<%-- 
    Document   : index
    Created on : Mar 10, 2023, 6:39:25 PM
    Author     : khami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Traveler</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
        <meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
        <meta name="author" content="FreeHTML5.co" />

        <!-- Facebook and Twitter integration -->
        <meta property="og:title" content=""/>
        <meta property="og:image" content=""/>
        <meta property="og:url" content=""/>
        <meta property="og:site_name" content=""/>
        <meta property="og:description" content=""/>
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />

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

    </head>
    <body>

        <div class="gtco-loader"></div>

        <div id="page">


            <!-- <div class="page-inner"> -->
            <jsp:include page="component/header.jsp"/>

            <header id="gtco-header" class="gtco-cover gtco-cover-md" role="banner" style="background-image: url(images/background.jpg)">

                <div class="row row-mt-15em">
                    <jsp:include page="user/booking.jsp"></jsp:include>
                    </div>

                </header>

                <div class="gtco-section">
                    <div class="gtco-container">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2 text-center gtco-heading">
                                <h2>Most Popular Destination</h2>
                                <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                            </div>
                        </div>
                        <div class="row">

                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <a href="images/img_1.jpg" class="fh5co-card-item image-popup">
                                    <figure>
                                        <div class="overlay"><i class="ti-plus"></i></div>
                                        <img src="images/img_1.jpg" alt="Image" class="img-responsive">
                                    </figure>
                                    <div class="fh5co-text">
                                        <h2>New York, USA</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                        <p><span class="btn btn-primary">Schedule a Trip</span></p>
                                    </div>
                                </a>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <a href="images/img_2.jpg" class="fh5co-card-item image-popup">
                                    <figure>
                                        <div class="overlay"><i class="ti-plus"></i></div>
                                        <img src="images/img_2.jpg" alt="Image" class="img-responsive">
                                    </figure>
                                    <div class="fh5co-text">
                                        <h2>Seoul, South Korea</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                        <p><span class="btn btn-primary">Schedule a Trip</span></p>
                                    </div>
                                </a>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <a href="images/img_3.jpg" class="fh5co-card-item image-popup">
                                    <figure>
                                        <div class="overlay"><i class="ti-plus"></i></div>
                                        <img src="images/img_3.jpg" alt="Image" class="img-responsive">
                                    </figure>
                                    <div class="fh5co-text">
                                        <h2>Paris, France</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                        <p><span class="btn btn-primary">Schedule a Trip</span></p>
                                    </div>
                                </a>
                            </div>


                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <a href="images/img_4.jpg" class="fh5co-card-item image-popup">
                                    <figure>
                                        <div class="overlay"><i class="ti-plus"></i></div>
                                        <img src="images/img_4.jpg" alt="Image" class="img-responsive">
                                    </figure>
                                    <div class="fh5co-text">
                                        <h2>Sydney, Australia</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                        <p><span class="btn btn-primary">Schedule a Trip</span></p>
                                    </div>
                                </a>
                            </div>

                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <a href="images/img_5.jpg" class="fh5co-card-item image-popup">
                                    <figure>
                                        <div class="overlay"><i class="ti-plus"></i></div>
                                        <img src="images/img_5.jpg" alt="Image" class="img-responsive">
                                    </figure>
                                    <div class="fh5co-text">
                                        <h2>Greece, Europe</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                        <p><span class="btn btn-primary">Schedule a Trip</span></p>
                                    </div>
                                </a>
                            </div>

                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <a href="images/img_6.jpg" class="fh5co-card-item image-popup">
                                    <figure>
                                        <div class="overlay"><i class="ti-plus"></i></div>
                                        <img src="images/img_6.jpg" alt="Image" class="img-responsive">
                                    </figure>
                                    <div class="fh5co-text">
                                        <h2>Spain, Europe</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                        <p><span class="btn btn-primary">Schedule a Trip</span></p>
                                    </div>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>

                <div id="gtco-features">
                    <div class="gtco-container">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2 text-center gtco-heading animate-box">
                                <h2>How It Works</h2>
                                <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 col-sm-6">
                                <div class="feature-center animate-box" data-animate-effect="fadeIn">
                                    <span class="icon">
                                        <i>1</i>
                                    </span>
                                    <h3>Lorem ipsum dolor sit amet</h3>
                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="feature-center animate-box" data-animate-effect="fadeIn">
                                    <span class="icon">
                                        <i>2</i>
                                    </span>
                                    <h3>Consectetur adipisicing elit</h3>
                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="feature-center animate-box" data-animate-effect="fadeIn">
                                    <span class="icon">
                                        <i>3</i>
                                    </span>
                                    <h3>Dignissimos asperiores vitae</h3>
                                    <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>


                <div class="gtco-cover gtco-cover-sm" style="background-image: url(images/img_bg_1.jpg)"  data-stellar-background-ratio="0.5">
                    <div class="overlay"></div>
                    <div class="gtco-container text-center">
                        <div class="display-t">
                            <div class="display-tc">
                                <h1>We have high quality services that you will surely love!</h1>
                            </div>	
                        </div>
                    </div>
                </div>

                <div id="gtco-counter" class="gtco-section">
                    <div class="gtco-container">

                        <div class="row">
                            <div class="col-md-8 col-md-offset-2 text-center gtco-heading animate-box">
                                <h2>Our Success</h2>
                                <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                            </div>
                        </div>

                        <div class="row">

                            <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
                                <div class="feature-center">
                                    <span class="counter js-counter" data-from="0" data-to="196" data-speed="5000" data-refresh-interval="50">1</span>
                                    <span class="counter-label">Destination</span>

                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
                                <div class="feature-center">
                                    <span class="counter js-counter" data-from="0" data-to="97" data-speed="5000" data-refresh-interval="50">1</span>
                                    <span class="counter-label">Hotels</span>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
                                <div class="feature-center">
                                    <span class="counter js-counter" data-from="0" data-to="12402" data-speed="5000" data-refresh-interval="50">1</span>
                                    <span class="counter-label">Travelers</span>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
                                <div class="feature-center">
                                    <span class="counter js-counter" data-from="0" data-to="12202" data-speed="5000" data-refresh-interval="50">1</span>
                                    <span class="counter-label">Happy Customer</span>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>



                <div id="gtco-subscribe">
                    <div class="gtco-container">
                        <div class="row animate-box">
                            <div class="col-md-8 col-md-offset-2 text-center gtco-heading">
                                <h2>Subscribe</h2>
                                <p>Be the first to know about the new templates.</p>
                            </div>
                        </div>
                        <div class="row animate-box">
                            <div class="col-md-8 col-md-offset-2">
                                <form class="form-inline">
                                    <div class="col-md-6 col-sm-6">
                                        <div class="form-group">
                                            <label for="email" class="sr-only">Email</label>
                                            <input type="email" class="form-control" id="email" placeholder="Your Email">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6">
                                        <button type="submit" class="btn btn-default btn-block">Subscribe</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            <jsp:include page="component/footer.jsp"/>
            <!-- </div> -->

        </div>

        <div class="gototop js-top">
            <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
        </div>

        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- jQuery Easing -->
        <script src="js/jquery.easing.1.3.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Waypoints -->
        <script src="js/jquery.waypoints.min.js"></script>
        <!-- Carousel -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- countTo -->
        <script src="js/jquery.countTo.js"></script>

        <!-- Stellar Parallax -->
        <script src="js/jquery.stellar.min.js"></script>

        <!-- Magnific Popup -->
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/magnific-popup-options.js"></script>

        <!-- Datepicker -->
        <script src="js/bootstrap-datepicker.min.js"></script>


        <!-- Main -->
        <script src="js/main.js"></script>

    </body>
</html>

