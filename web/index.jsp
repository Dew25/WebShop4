<%-- 
    Document   : index
    Created on : 26.10.2017, 20:34:27
    Author     : jvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/index.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>${info}</div>
        <div>${error}</div>
        <a href="/WebShop4/controller?page=login">login</a><br>
        <a href="/WebShop4/controller?page=logout">logout</a>
    </body>
</html>
