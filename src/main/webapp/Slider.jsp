<%-- 
    Document   : Silder
    Created on : Oct 17, 2022, 10:09:22 PM
    Author     : Nguyễn Đường Phú Trọng -  CE160324
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"/>
        <link
            rel="stylesheet"
            href="./assert/font/fontawesome-free-6.1.1-web/css/all.min.css"
            />
        <link rel="stylesheet" href="./assert/css/style.css" />
        <title>Slider</title>
        <style>
            *{
                font-family: monospace;
            }
            
            .slider-large {
                margin: 42px 0px;
            }

            .carousel-caption {
                margin-bottom: 36%;
            }

            .slider-large-caption {
                margin-bottom: 22%;
            }
            
            .slider-large-caption a {
                font-family: monospace;
                font-size: 64px;
                text-decoration: none;
                font-weight: bold;
                color: #777;
            }

            .slider-large-caption p {
                font-size: 20px;
                font-family: monospace;
                color: #666;
            }

            .carousel-caption-titel {
                font-size: 22px;
                text-decoration: none;
                font-weight: bold;
                color: red;
                font-family: monospace;
            }

            .slider-medium .row {
                display: flex;
                justify-content: center;
            }

            .carousel-item img:hover {
                opacity: 0.7;
                cursor: pointer;
            }

            .carousel-caption-titel:hover {
                color: red;
            }

            .slider-medium {
                margin-bottom: 56px;
            }
            .slider-medium-heading {
                text-align: center;
                font-size: 46px;
                font-family: monospace;
                margin-top: 12px;
            }
            .logo-img {
                width: 286px;
                height: 34px;
            }
            
            .btn-buy {
                color: #ed1c24 !important;
            }
            
            .carousel-caption .caption {
                color: #111;
            }
        </style>
    </head>
    <body>

        <!-- 1. Navigation -->
        <jsp:include page="Navigation.jsp"></jsp:include>
        <jsp:include page="Logo.jsp"></jsp:include>

            <!-- 2. Slider-->
            <div class="container-fluid slider-large">
                <div class="row">
                    <div class="col col-xs-12">
                        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                                        aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                                        aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                                        aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item">
                                    <img src="https://theme.hstatic.net/1000306633/1000891824/14/slideshow_1.jpg?v=160" class="d-block w-100"
                                         alt="...">
                                    <div class="slider-large-caption carousel-caption d-none d-md-block">
                                        <a href="home" class="carousel-caption-titel btn-buy">BUY PRODUCTS</a>
                                        <p class="caption" >This's the fashionable style for this season. Group-1-shop where you are the best style!</p>
                                    </div>
                                </div>
                                <div class="carousel-item ">
                                    <img
                                        src="https://theme.hstatic.net/1000306633/1000891824/14/show_block_home_category_image_3_new.png?v=160"
                                        class="d-block w-100" alt="...">
                                    <div class="slider-large-caption carousel-caption d-none d-md-block">
                                        <a href="home" class="carousel-caption-titel btn-buy">BUY PRODUCTS</a>
                                        <p class="caption">This's the fashionable style for this season. Group-1-shop where you are the best style!</p>
                                    </div>
                                </div>
                                <div class="carousel-item active">
                                    <img src="https://theme.hstatic.net/1000306633/1000891824/14/slideshow_2.jpg?v=160" class="d-block w-100"
                                         alt="...">
                                    <div class="slider-large-caption carousel-caption d-none d-md-block">
                                        <a href="home" class="carousel-caption-titel btn-buy">BUY PRODUCTS</a>
                                        <p class="caption">This's the fashionable style for this season. Group-1-shop where you are the best style!</p>
                                    </div>
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                                    data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                                    data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>


            <div class="container slider-medium">
                <div class="row">
                    <div class="col-xs-12">
                        <h4 class="slider-medium-heading">NEW TRIVIAL ITEMS</h4>
                        <div class="sep"></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-xs-12 col-md-6">
                        <div id="slider-medium-1" class="carousel slide" data-bs-ride="false">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#slider-medium-1" data-bs-slide-to="0" class="active"
                                        aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#slider-medium-1" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#slider-medium-1" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img
                                        src="./assert/img/newItem1_1.jpg"
                                        class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <a href="home" class="carousel-caption-titel">UP COMING PRODUCTS</a>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img
                                        src="./assert/img/newItem1_2.jpg"
                                        class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <a href="home" class="carousel-caption-titel">UP COMING PRODUCTS</a>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img
                                        src="./assert/img/newItem1_3.jpg"
                                        class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <a href="home" class="carousel-caption-titel">UP COMING PRODUCTS</a>
                                    </div>
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#slider-medium-1" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#slider-medium-1" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>

                    <div class="col col-xs-12 col-md-6">
                        <div id="slider-medium-2" class="carousel slide" data-bs-ride="false">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#slider-medium-2" data-bs-slide-to="0" class="active"
                                        aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#slider-medium-2" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#slider-medium-2" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img
                                        src="./assert/img/newItem2_1.jpg"
                                        class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <a href="home" class="carousel-caption-titel">UP COMING PRODUCTS</a>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img
                                        src="./assert/img/newItem2_2.jpg"
                                        class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <a href="" class="carousel-caption-titel">UP COMING PRODUCTS</a>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img
                                        src="./assert/img/newItem2_3.jpg"
                                        class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <a href="home" class="carousel-caption-titel">UP COMING PRODUCTS</a>
                                    </div>
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#slider-medium-2" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#slider-medium-2" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="./bootstrap/js/bootstrap.js"></script>
    </body>
</html>
