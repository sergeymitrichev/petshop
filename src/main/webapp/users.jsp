<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users</h1>
<%--@elvariable id="users" type="java.util.List"--%>
<c:forEach items="${users}" var="user">
    <jsp:useBean id="user" type="home.petshop.entity.user.User"/>
    <p>${user.toString()}</p>
</c:forEach>
</body>
</html>
