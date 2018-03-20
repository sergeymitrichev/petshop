<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Products</h1>
<%--@elvariable id="products" type="java.util.List"--%>
<c:forEach items="${products}" var="product">
    <jsp:useBean id="product" type="home.petshop.entity.product.Product"/>
    <p>${product.toString()}</p>
</c:forEach>
</body>
</html>
