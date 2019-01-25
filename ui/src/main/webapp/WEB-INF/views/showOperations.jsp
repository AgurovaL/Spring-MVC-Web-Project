<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All operations</title>
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
 <h2>All operations</h2>
<table border="1px black" class="itemsTable">
    <thead>
    <th width="50px"><h2>ID</h2></th>
    <th width="150px"><h2>User id</h2></th>
    <th width="150px"><h2>Book id</h2></th>
    <th width="150px"><h2>Date</h2></th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${operations}">
             <tr>
                 <td>${item.getId()}</td>
                 <td>${item.getUserId()}</td>
                 <td>${item.getBookId()}</td>
                 <td>${item.getDate()}</td>
                 <td>
                    <form id="deleteOperation" action="/deleteOperation" method="POST">
                       <input id="id" name="id" type="hidden" value="${item.getId()}"/>
                       <input class="cancelButton" type="submit" value="Cancel" onClick="return confirm('Cancel operation?')"/>
                    </form>
                 </td>
             </tr>
         </c:forEach>
    </tbody>
</table>
</body>
</html>