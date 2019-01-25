<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin page</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css"/>"/>
</head>
<body>
 <header>
        <p id="username">You are logged in as ADMIN</p>
        <a href="<c:url value="/logout" />"><button type="button">logout / login</button></a>
        <a href="/showBooks"><button type="button">SHOP</button></a>
 </header>
<h1>ONLINE BOOK SHOP</h1>
<h2>Admin actions</h2>
<a href="/showUsers"><button type="button">Users</button></a>
<a href="/showOperations"><button type="button">Operations</button></a>
<a href="/addBook"><button type="button">Add book</button></a>
</body>
</html>