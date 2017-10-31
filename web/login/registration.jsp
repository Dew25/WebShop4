<%-- 
    Document   : registry
    Created on : 31.10.2017, 22:00:43
    Author     : jvm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/registration.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Регистрация нового пользователя!</h1>
        <form action="controller?page=newUser" method="POST">
            <div class="regWrapper"
            <h1>Введите все данные</h1>
                <p>Имя: <input type="text" name="name" placeholder="Имя" value="${name}"></p>
                <p>Фамилия: <input type="text" name="surname" placeholder="Фамилия" value="${surname}"></p>
                <p>Логин: <input type="text" name="login" placeholder="логин" value="${login}"></p>
                <p>Пароль: <input type="password" name="password1" placeholder="password"></p>
                <p>Повторите пароль: <input type="password" name="password2" placeholder="повторите пароль"></p>
                <p>Телефон: <input type="text" name="phone" placeholder="Телефон" value="${phone}"></p>
                <p>Город: <input type="text" name="city" placeholder="Город" value="${city}"></p>
                <p>Деньги: <input type="text" name="money" placeholder="Деньги" value="${money}"></p>
                <p><input type="submit" name="submit" value="Зарегистрироваться"></p>
            </div>
        </form>
    </body>
</html>
