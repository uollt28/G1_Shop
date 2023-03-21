<%-- 
    Document   : Register
    Created on : Sep 23, 2022, 10:44:35 PM
    Author     : Lê Khanh Băng - CE160155
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./assert/css/loginRegister.css" />
        <title>Authentication-Email</title>
        <style>
            * {
                font-family: monospace;
                font-size: 14px;
            }

            .form-heading {
                font-size: 22px;
            }

            .form-decrit {
                font-size: 16px;
            }

            .form-error {
                font-size: 16px;
            }

            .btn-canel a , .main-btn a {
                text-decoration: none;
                color: white;
            }
            .disable {
                display: none;
            }

            .active {
                display: block;
            }
            
            .btn-group {
                display: flex;
            }
            
            .main-btn {
                margin-right: 12px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form action="authenEmail" method="post">
                <h2 class="form-heading">Xác nhận tài khoản Email</h2>
                <p class="form-decrit">
                    Hãy nhập mã xác thực gồm 6 số được gửi về địa chỉ email <strong>${email}</strong> của bạn.
                </p>
                <div class="form-control">
                    <h4 class="form-label">Nhập mã:</h4>
                    <input
                        type="text"
                        name="inputCode"
                        id="inputCode"
                        placeholder="VD: 012345"
                        required
                        />
                    <div class="form-error ${isValidCode == false ? "active" : ""}">Mã xác thực không đúng!!!</div>
                </div>

                <div class="form-control disable" >
                    <input
                        type="text"
                        name="randomCode"
                        id="randomCode"
                        value="${randomCode}"
                        />
                </div>

                <div class="form-control disable">
                    <input
                        type="text"
                        name="fullName"
                        id="fullName"
                        value="${fullName}"
                        />
                </div>

                <div class="form-control disable">
                    <input
                        type="text"
                        name="email"
                        id="email"
                        value="${email}"
                        />
                </div>

                <div class="form-control disable">
                    <input
                        type="text"
                        name="phone"
                        id="phone"
                        value="${phone}"
                        />
                </div>

                <div class="form-control disable">
                    <input
                        type="text"
                        name="password"
                        id="password"
                        value="${password}"
                        />
                </div>

                <div class="form-control disable" >
                    <input
                        type="text"
                        name="address"
                        id="address"
                        value="${address}"
                        />
                </div>

                <div class="form-control disable" >
                    <input
                        type="text"
                        name="countFailedAuthen"
                        id="countFailedAuthen"
                        value="${countFailedAuthen}"
                        />
                </div>

                <p class="form-decrit">
                    Nếu bạn chưa có email tạo tài khoản
                    <a href="Register.jsp" class="form-link">tại đây</a>
                </p>
                <div class="btn-group">
                    <button class="main-btn ${isValidCode == false ? "disable" : ""}" type="submit">XÁC NHẬN</button>
                    <button class="main-btn disable ${isValidCode == false ? "active" : ""}" type="button">
                        <a href="reAuthenEmail?fullName=${fullName}&email=${email}&phone=${phone}&password=${password}&address=${address}&countFailedAuthen=${countFailedAuthen}" target="target">GỬI LẠI</a></button>
                    <button class="main-btn btn-canel" type="button"><a><a href="home">HỦY BỎ</a></button>
                </div>
            </form>
        </div>
    </body>
</html>
