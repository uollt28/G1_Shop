<%-- 
    Document   : ManageAccount
    Created on : Oct 9, 2022, 10:12:05 PM
    Author     : Trần Đăng Khoa - CE160367
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Manager-Account</title>

        <style>
            *{
                font-family: monospace;
                font-size: 14px;
            }
            
            .logo-img {
                width: 286px;
                height: 34px;
            }
            
            .home-filter {
                background-color: rgb(143, 145, 147);
                color: black;
                align-items: center;
                padding: 24px;
                margin-bottom: 24px;
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
                background-color: #1C53A4;
            }

            .primary-btn i {
                font-size: 14px;
                margin-right: 4px;
            }

            .primary-btn:hover a {
                color: white;
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
                width: 170px;
                height: 40px;
                text-align: center;
                border: 1px solid #1C53A4;
                border-radius: 4px;
                line-height: 40px;
                font-weight: 500;
                position: relative;
                background-color: #1C53A4;
                color: white;
            }

            .category-sort i {
                margin-left: 4px;
                color: white;
            }

            .category-btn {
                display: flex;
                align-items: center;
            }

            .category-btn h4{
                font-size: 20px;
                margin-bottom: 0;
                margin-right: 6px;
            }

            .category-btn button {
                margin-bottom: 0;
                margin-right: 8px;
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
                color: #444;
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

            .table-order thead tr th {
                /*border-color: none;*/
            }

            .product-cart-id {
                min-width: 60px;
            }

            .product-cart-img img{
                width: 80px;
                height: 80px;
            }

            .form-add-btn {
                text-decoration: none;
                color: white;
            }
        </style>
    </head>
    <body>
        <!-- Nav and logo -->
        <jsp:include page="Navigation.jsp"></jsp:include>
        <jsp:include page="Logo.jsp"></jsp:include>

            <!-- Nav-home fitter -->
            <nav class="navbar home-filter navbar-expand-lg bg-light">
                <div class="container">
                    <button
                        class="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                        >
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <h4 class="nav-heading">Manage Account</h4>
                            </li>
                            <li class="nav-item">
                                <div class="nav-total-product">Account quantity: ${requestScope.customerQuantity}</div>
                        </li>
                    </ul>
                    <form class="d-flex" role="search" action="searchAccount">
                        <button class="btn primary-btn" type="button">
                            <i class="fa-sharp fa-solid fa-plus"></i>
                            <a class="form-add-btn" href="Register.jsp">Add new account</a>
                        </button>
                        <input
                            class="form-control me-2 search-input"
                            type="search"
                            name="textSearchAccount"
                            placeholder="Enter customer's name"
                            aria-label="Search"
                            value="${txtSearchAccount}"
                            />
                        <button class="btn btn-search" type="submit">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </form>
                </div>
            </div>
        </nav>

        <!-- Category -->
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-bordered align-middle">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Address</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Role-ID</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.listCutomer}" var="c">
                                <tr>
                                    <th scope="row">${c.ID}</th>
                                    <td class="customer-name">${c.name}</td>
                                    <td class="customer-email">${c.email}</td>
                                    <td class="customer-address">
                                        ${c.address}
                                    </td>
                                    <c:forEach items="${requestScope.listAccount}" var="a">
                                        <c:if test="${c.accountID == a.ID}"> 
                                            <td class="customer-phone">${a.phone}</td>
                                            <td class="customer-role-id">${a.roleID}</td>
                                            <td>
                                                <a href="deleteCustomer?customerID=${c.ID}&accountID=${a.ID}" onclick="return showMessageDelete();">
                                                    <i
                                                        class="fa fa-trash product-cart-delete"
                                                        aria-hidden="true"
                                                        ></i>
                                                </a>
                                            </td>
                                        </c:if>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                            <c:if test="${listCutomer.size() == 0}">
                                <tr>
                                    <td colspan="11">There are no customer is found!!!</td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row justify-content-between">
                <div class="col-sm-2">
                    <div class="btn-group">
                        <button class="btn primary-btn" type="submit">
                            <a class="primary-btn" href="home">Back to home</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer -->    
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script>
        function showMessageDelete() {
            var result = confirm("Are you sure to delete this customer?");
            if (result) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</html>