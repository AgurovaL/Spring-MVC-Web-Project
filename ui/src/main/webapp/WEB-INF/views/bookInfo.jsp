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
        <p id="username">You are logged in as ${username}</p>
        <a href="<c:url value="/logout" />"><button type="button">logout / login</button></a>
        <a href="/userProfile"><button type="button">my profile</button></a>
        <a href="/showBooks"><button type="button">SHOP</button></a>
 </header>

<h1>ONLINE BOOK SHOP</h1>
    <table>
        <tr>
            <td>Title :</td>
            <td>${viewBook.getTitle()}</td>
        </tr>
        <tr>
            <td>Author :</td>
            <td>${viewBook.getAuthor()}</td>
        </tr>
        <tr>
            <td>Publisher :</td>
            <td>${viewBook.getPublisher()}</td>
        </tr>
        <tr>
             <td>Year of writing :</td>
             <td>${viewBook.getYearOfWriting()}</td>
        </tr>
        <tr>
              <td>Year of publishing :</td>
              <td>${viewBook.getYearOfPublishing()}</td>
        </tr>
        <tr>
              <td>Number of pages :</td>
              <td>${viewBook.getPagesNumber()}</td>
        </tr>
        <tr>
              <td>Price :</td>
              <td>${viewBook.getPrice()}</td>
         </tr>
    </table>
    <form method="get" action="/buyBook">
        <input type="hidden" name="bookId" value="${viewBook.getId()}">
        <input type="hidden" name="userName" value="${username}">
        <button class="buyButton" type="submit" >Buy</button>
    </form>
</body>
</html>