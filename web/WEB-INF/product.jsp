<%-- 
    Document   : product
    Created on : 26.10.2017, 20:51:55
    Author     : jvm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/product.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Страница продуктов!</h1>
        <div>${info}</div>
        <div>${error}</div>
        Наши продукты:
        <ul>
            <c:forEach var="product" items="${products}">
                <li>
                    ${product.name}, по ценe ${product.price/100} EUR - ${product.quantity} шт.
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
