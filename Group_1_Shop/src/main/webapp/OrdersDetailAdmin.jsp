<%-- 
    Document   : ManageOrders
    Created on : Oct 20, 2022, 8:17:32 PM
    Author     : Trần Đăng Khoa - CE160367
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css" />
        <link
            rel="stylesheet"
            href="./assert/font/fontawesome-free-6.1.1-web/css/all.min.css"
            />
        <link rel="stylesheet" href="./assert/css/style.css" />
        <title>Order-Detail</title>

        <style>
            
            *{
                font-family: monospace;
                font-size: 14px;
            }
            .home-filter {
                background-color: rgb(143, 145, 147);
                color: black;
                align-items: center;
                padding: 24px;
                margin-bottom: 24px;
            }
            
            .logo-img {
                width: 286px;
                height: 34px;
            }

            .nav-heading {
                margin: 10px 12px 2px 0px;
                color: #1c53a4;
                font-size: 22px;
                font-weight: bold;
            }

            .nav-item {
                display: flex;
                justify-content: center;
            }

            .btn-add {
                width: 300px;
                height: 50px;
                padding: 12px;
                box-sizing: border-box;
                background-color: #1C53A4;
                color: white;
                margin-right: 16px;
            }

            .primary-btn {
                width: 200px;
                padding: 12px 12px;
                margin-right: 12px;
                font-weight: 500;
            }

            .primary-btn i {
                font-size: 14px;
                margin-right: 4px;
            }

            .search-input {
                width: 220px;
            }

            .nav-total-product {
                min-width: 232px;
                background-color: #1C53A4;
                color: white;
                text-align: center;
                height: 46px;
                line-height: 46px;
                font-weight: bold;
                border-radius: 2px;
                font-size: 15px;
            }

            .nav-total-product i {
                margin-right: 4px;
            }

            .btn-group {
                margin: 24px 0px;
            }

            .align-middle {
                text-align: center;
            }

            .category {
                display: flex;
                justify-content: space-between;
            }

            .category-sort {
                width: 150px;
                height: 40px;
                text-align: center;
                border: 1px solid black;
                line-height: 40px;
                font-weight: 500;
                position: relative;
            }

            .category-sort i {
                margin-left: 4px;
            }

            .category-btn button {
                margin-bottom: 0;
            }

            .category-btn button a {
                color: black !important;
                font-weight: bold;
            }

            .category-sort-option {
                background-color: rgb(247, 246, 246);
                text-align: start;
                border-radius: 2px;
                box-shadow: 2px 2px rgb(229, 229, 229);
                position: absolute;
                right: 0;
                top: 46px;
                display: none;
            }

            .category-sort span::before {
                content: "";
                width: 170px;
                height: 16px;
                background-color: transparent;
                position: absolute;
                bottom: -8px;
                right: 0;
            }

            .category-sort-option ul h5 {
                font-size: 16px;
                padding: 2px 32px;
                margin: 4px 0px;
                display: flex;
            }

            .category-sort-option ul h5 i {
                margin-left: 6px;
                margin-top: 4px;
            }

            .category-sort-option ul {
                padding-left: 0;
            }

            .category-sort-option ul li {
                width: 100%;
                height: 28px;
                list-style: none;
                padding-left: 0;
                padding: 0px 32px !important;
                display: flex;
                align-items: center;
            }

            .category-sort-option ul li a {
                text-decoration: none;
                color: rgb(102, 101, 101);
                font-size: 14px !important;
            }

            .category-sort-option ul li:hover {
                background-color: rgb(217, 214, 214);
            }

            .category-sort:hover .category-sort-option {
                display: block;
            }

            .table {
                margin-top: 18px;
            }

            .justify-content-between {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .total-label,
            .total-price,
            .total-import-price {
                font-weight: bold;
                padding: 24px;
                margin-top: 12px;
            }

            .product-cart-img img {
                width: 40px;
                height: 40px;
            }

            .table-order thead {
                background-color: #1c53a4;
                color: white;
                border-color: #1c53a4;
            }

            .table-order-heading {
                font-weight: 500;
            }

            .table-order thead tr th {
                /*border-color: none;*/
            }

            .product-cart-date ,.product-cart-note {
                min-width: 110px;
            }

            .product-cart-fullname {
                min-width: 110px;
            }

            .product-cart-address {
                max-width: 190px;
            }

            .order-list-email {
                max-width: 110px;
                overflow-x: hidden;
                word-wrap: break-word;
            }

            .product-cart-id {
                min-width: 44px;
                font-weight: bold;
            }

            .product-cart-p-id {
                min-width: 44px;
            }

            .product-cart-total{
                font-weight: bold;
            }
            
            .primary-btn {
                 background-color: #1c53a4;
            }
            
            .primary-btn a {
                text-decoration: none;
                color: white;
            }
            
            .justify-content-between {
                margin-bottom: 24px;
            }
            
            .product-cart-price-total {
                color: red;
                font-weight: bold;
            }
        </style>
    </head>

    <body>        

        <!-- 1. Navigation -->
        <jsp:include page="Navigation.jsp"></jsp:include>
        <jsp:include page="Logo.jsp"></jsp:include>

            <!-- Nav-home fitter -->
            <nav class="navbar home-filter navbar-expand-lg bg-light">
                <div class="container">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <h4 class="nav-heading">Manage Orders</h4>
                            </li>
                            <li class="nav-item">
                                <div class="nav-total-product"> Order ID:   
                                ${orderID}
                            </div>
                        </li>
                    </ul>
                    <form class="d-flex" role="search" action="searchOrders">
                        <input name="txtSearch" value="${txtOrderIDValue}" class="form-control me-2 search-input" type="search" placeholder="Enter orders ID" aria-label="Search" />
                        <button class="btn btn-search" type="submit">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </form>
                </div>
            </div>
        </nav>



        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-bordered align-middle table-order">
                        <thead>
                            <tr>
                                <!--<th scope="col">ACCEPT</th>-->
                                <th scope="col" class="table-order-heading">Order date</th>
                                <th scope="col" class="table-order-heading">Name</th>
                                <th scope="col" class="table-order-heading">Email</th>
                                <th scope="col" class="table-order-heading">Phone</th>
                                <th scope="col" class="table-order-heading">Address</th>
                                <th scope="col" class="table-order-heading">Note</th>
                                <th scope="col" class="table-order-heading">P-ID</th>
                                <th scope="col" class="table-order-heading">Title</th>
                                <th scope="col" class="table-order-heading">Image</th> 
                                <th scope="col" class="table-order-heading">Size</th>
                                <th scope="col" class="table-order-heading">Quantity</th>
                                <th scope="col" class="table-order-heading">Status</th>
                                <th scope="col" class="table-order-heading">Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOrder}" var="o">
                                <tr>
                                    <td  class="product-cart-date">${o.date}</td>
                                    <td  class="product-cart-fullname">
                                        ${customer.name}
                                    </td>
                                    <td class="order-list-email">
                                        ${customer.email}
                                    </td>
                                    <td class="product-cart-phone">${customer.phone}</td>
                                    <td class="product-cart-address">
                                        ${customer.address}
                                    </td>
                                    <td  class="product-cart-note">
                                        ${o.note}
                                    </td>
                                    <td class="product-cart-p-id">${o.product_id}</td>
                                    <td class="product-cart-title">${o.title}</td>
                                    <td class="product-cart-img"><img src="img/${o.product_id}.webp" alt="alt"/></td>
                                    <td class="product-cart-p-id">${o.size}</td>
                                    <td  class="product-cart-quantity">${o.quantity}</td>
                                    <td  class="product-cart-status">
                                        ${o.status}
                                    </td>
                                    <td class="product-cart-total">
                                        <fmt:formatNumber type="number" pattern="###,###" value="${o.price * o.quantity}"/>đ</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row justify-content-between align-items-end">
                <div class="col-sm-2">
                    <div class="btn-group">
                        <button class="btn primary-btn" type="button">
                            <a href="manageOrder">BACK TO</a>
                        </button>
                    </div>
                </div>
                <div class="col-md-4">
                    <table class="table table-bordered align-middle">
                        <tbody>
                            <tr>
                                <td class="product-cart-price-label">TẠM TÍNH</td>
                                <td>
                                    <fmt:formatNumber type="number" pattern="###,###" value="${totalPrice}" />đ
                                </td>
                            </tr>
                            <tr>
                                <td class="product-cart-price-label">PHÍ VẬN CHUYỂN</td>
                                <td>
                                    +<fmt:formatNumber type="number" pattern="###,###" value="30000" />đ
                                </td>
                            </tr>
                            <tr>
                                <td class="product-cart-price-label">TỔNG TIỀN</td>
                                <td class="product-cart-price-total">
                                    <fmt:formatNumber type="number" pattern="###,###" value="${totalPrice + 30000}" />đ
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- 3. Footer -->
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
    <script src="./bootstrap/js/bootstrap.js"></script>

</html>

