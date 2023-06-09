<%-- 
    Document   : nav.jsp
    Created on : Sep 24, 2022, 10:43:49 AM
    Author     : Lê Khanh Băng - CE160155
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- 1. Navigation -->
<div class="navbar">
    <div class="container">
        <span class="navbar-hotline">
            <i class="fa-solid fa-phone"></i>
            Hotline: 0933.782.768
        </span>
        <ul class="navbar-list">
            <c:if test="${sessionScope.accountSeesion != null}">
                <c:if test="${sessionScope.accountSeesion.ID == 1}">
                    <li class="navbar-item">
                        <a href="manageOrder" class="navbar-link">Manage Orders</a>
                    </li>
                    <li class="navbar-item">
                        <a href="manageProduct" class="navbar-link">Manage Products</a>
                    </li>

                    <li class="navbar-item">
                        <a href="manageAccount" class="navbar-link">Manage Accounts</a>
                    </li>
                    <li class="navbar-item">
                        <a href="#" class="navbar-link">Hello admin</a>
                    </li>
                </c:if>
                <li class="navbar-item">
                    <a href="logout" class="navbar-link">Đăng Xuất</a>
                </li>
                <c:if test="${sessionScope.accountSeesion.ID != 1}">
                    <li class="navbar-item">
                        <a href="loadCustomerInfo" class="navbar-link">
                            <i class="fa-solid fa-user"></i>
                            ${sessionScope.customerName}</a>
                    </li>
                </c:if>  
            </c:if>
            <c:if test="${sessionScope.accountSeesion == null}">
                <li class="navbar-item">
                    <a href="Register.jsp" class="navbar-link">
                        Đăng Kí
                    </a>
                </li>
                <li class="navbar-item">

                    <a href="Login.jsp" class="navbar-link">
                        Đăng Nhập</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>
