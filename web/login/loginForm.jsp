<%-- 
    Document   : loginForm
    Created on : 31.10.2017, 13:08:48
    Author     : jvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/login.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="controller?page=checkLogin" method="POST">
            <div class="loginWrapper">
              <h1>Авторизуйтесь!</h1>
              <p>${info}</p>
              <label><b>Username</b></label>
              <input type="text" placeholder="Enter Username" name="login" required>
              <br>
              <label><b>Password</b></label>
              <input type="password" placeholder="Enter Password" name="password" required>
              <input type="hidden" name="path">
              <br>
              <br><button type="button" class="cancelbtn">Cancel</button>
              <button type="submit">Login</button>
              
              <input type="checkbox" checked="checked"> Remember me
            </div>

            <div class="container" style="background-color:#f1f1f1">
              
              <br>
              <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </body>
</html>
