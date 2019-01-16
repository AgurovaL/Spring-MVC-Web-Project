<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All users</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css"/>"/>
</head>
<body>
 <header>
        <p id="username">You are logged in as ${login}</p>
         <a href="/login"><button type="button">logout / login</button></a>
 </header>
<h1>ONLINE BOOK SHOP</h1>
 <h2>All users</h2>
<table border="1px black" class="itemsTable">
    <thead>
    <th width="50px"><h2>ID</h2></th>
    <th width="150px"><h2>First name</h2></th>
    <th width="150px"><h2>Last name</h2></th>
    <th width="150px"><h2>Address</h2></th>
    <th width="150px"><h2>Login</h2></th>
    <th width="150px"><h2>Password</h2></th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${users}">
             <tr>
                 <td>${item.getId()}</td>
                 <td>${item.getFirstName()}</td>
                 <td>${item.getLastName()}</td>
                 <td>${item.getAddress()}</td>
                 <td>${item.getLogin()}</td>
                 <td>${item.getPassword()}</td>
             </tr>
         </c:forEach>
    </tbody>
</table>
</body>
</html>