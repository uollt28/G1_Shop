<%-- 
    Document   : ProductDetail
    Created on : Sep 23, 2022, 10:44:01 PM
    Author     : Huỳnh Hữu Nghĩa - CE160343 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"/>
        <link
            rel="stylesheet"
            href="./assert/font/fontawesome-free-6.1.1-web/css/all.min.css"
            />
        <link rel="stylesheet" href="./assert/css/style.css" />       
        <link rel="stylesheet" href="./assert/css/productDetail.css" />
        <title>Contact-Us</title>
        <style>
            * {
                font-family: monospace;
                font-size: 16px;
            }

            .cart {
                text-decoration: none;
                position: relative;
                margin-left: 12px;
                display: flex;
                align-items: center;
            }

            .cart i{
                font-size: 24px;
                color: black;
                position: relative;
                text-decoration: none;
            }

            .cart-quantity {
                display: block;
                width: 22px;
                background-color: var(--main-btn-color);
                color: white;
                text-align: center;
                font-size: 12px;
                font-weight: bold;
                border-radius: 6px;
                position: absolute;
                top: -4px;
                right: -10px;
            }
            
            .contact-wrapper {
                margin-top: 32px;
                margin-bottom: 36px;
            }
            
            .footer-list, .contact-heading{
                margin-left: 24px;
            }
            
            .logo-img {
                width: 286px;
                height: 34px;
            }
        </style>
    </head>
    <body>
        <!-- 1. Navigation -->
        <jsp:include page="Navigation.jsp"></jsp:include>
        <jsp:include page="Logo.jsp"></jsp:include>
        <jsp:include page="HomeFiltter.jsp"></jsp:include>

            <!-- 2. Contact us -->
            <div class="container contact-wrapper">
                <div class="footer-body">
                    <h4 class="contact-heading">CONTACT US</h4>
                    <ul class="footer-list">
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-location-dot"></i>
                            <li class="footer-item">
                                Store I: 445 Sư Vạn Hạnh, P.12, Q.10
                            </li>
                        </div>
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-location-dot"></i>
                            <li class="footer-item">
                                Store II: 48 Trần Quang Diệu, P.14, Q.3, TP.HCM
                            </li>
                        </div>
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-location-dot"></i>
                            <li class="footer-item">
                                Store III: 463 Quang Trung, P.10, Q.Gò Vấp, TP.HCM
                            </li>
                        </div>
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-location-dot"></i>
                            <li class="footer-item">
                                Store IV: G-Town 1, 350 Điện Biên Phủ, P.17, Q.Bình Thạnh,
                                TP.HCM
                            </li>
                        </div>
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-location-dot"></i>
                            <li class="footer-item">
                                Store V: 463 Quang Trung, P.10, Q. Gò Vấp, TP.HCM.
                            </li>
                        </div>
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-location-dot"></i>
                            <li class="footer-item">
                               Store VI: TNP (Sense Market) - Đối Diện Số 90 Lê Lai, P. Bến Nghé, Q.1, TP.HCM.
                            </li>
                        </div>
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-location-dot"></i>
                            <li class="footer-item">
                                Biên Hoà: Vincom Biên Hoà - Shop House, PG2-06, 1096 Phạm
                                Văn Thuận, Tân Mai, Biên Hoà.
                            </li>
                        </div>
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-location-dot"></i>
                            <li class="footer-item">
                                Cần Thơ: Vincom Xuân Khánh - Shop House, PG2-08, Đường 30
                                tháng 4, Xuân Khánh, Cần Thơ.
                            </li>
                        </div>
                        
                        <div class="footer-wrapper">
                            <i class="fa-solid fa-phone"></i>
                            <li class="footer-item">Hotline: 0933782768</li>
                        </div>
                    </ul>
                </div>
            </div>
                </div>
            </div>

            <!-- Footer -->    
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>

