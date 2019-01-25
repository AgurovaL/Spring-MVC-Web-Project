<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Buy book</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css"/>"/>
</head>
<body>
<header>
            <p id="username">You are logged in as ${viewUser.getLogin()}</p>
            <a href="<c:url value="/logout" />"><button type="button">logout / login</button></a>
            <a href="/userProfile"><button type="button">my profile</button></a>
    </header>
<h1>ONLINE BOOK SHOP</h1>
    <h2>Check information</h2>
    <h3>User:</h3>
    <table>
           <tr>
               <td>Name :</td>
               <td>${viewUser.getFirstName()}</td>
           </tr>
           <tr>
               <td>Last name :</td>
               <td>${viewUser.getLastName()}</td>
           </tr>
           <tr>
               <td>Address :</td>
               <td>${viewUser.getAddress()}</td>
           </tr>
           <tr>
                <td>Login :</td>
                <td>${viewUser.getLogin()}</td>
           </tr>
       </table>

    <br><br>
    <h3>Book:</h3>
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
    <br>
        <form:form method="post" action="/buyBook" modelAttribute="viewBuyingOperation">
            <form:input type="hidden" path="bookId"    name="bookId"   value="${viewBook.getId()}"/>
            <form:input type="hidden" path="userId"  name="userId" value="${viewUser.getId()}"/>
            <button class="buyButton" type="submit">Buy</button>
            <p class="errorMessage">${errorMessage}</p>
         </form:form>
         <a href="/showBooks"><button type="button">Back to shop</button></a>
</body>
</html>