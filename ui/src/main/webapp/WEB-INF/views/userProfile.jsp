<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>User profile</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css"/>"/>
</head>
<body>
<header>
        <p id="username">You are logged in as ${user.getLogin()}</p>
        <a href="/login"><button type="button">logout / login</button></a>
        <a href="/showBooks"><button type="button">SHOP</button></a>
 </header>

<h1>ONLINE BOOK SHOP</h1>
    <table>
        <tr>
            <td>Name :</td>
            <td>${user.getFirstName()}</td>
        </tr>
        <tr>
            <td>Last name :</td>
            <td>${user.getLastName()}</td>
        </tr>
        <tr>
            <td>Address :</td>
            <td>${user.getAddress()}</td>
        </tr>
    </table>

    <h2>Books in your basket<h2>
    <table border="1px black" class="itemsTable">
        <thead>
        <th width="150px"><h2>Title</h2></th>
        <th width="150px"><h2>Author</h2></th>
        <th width="150px"><h2>Published by</h2></th>
        <th width="150px"><h2>Year of writing</h2></th>
        <th width="150px"><h2>Year of publishing</h2></th>
        <th width="150px"><h2>Number of pages</h2></th>
        <th width="150px"><h2>Price RUB</h2></th>
        </thead>
        <tbody>
        <c:forEach var="item" items="${user.getBooks()}">
                 <tr>
                     <td>${item.getId()}</td>
                     <td>${item.getTitle()}</td>
                     <td>${item.getAuthor()}</td>
                     <td>${item.getPublisher()}</td>
                     <td>${item.getYearOfWriting()}</td>
                     <td>${item.getYearOfPublishing()}</td>
                     <td>${item.getPagesNumber()}</td>
                     <td>${item.getPrice()}</td>
                 </tr>
             </c:forEach>
        </tbody>
    </table>
</body>
</html>