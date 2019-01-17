<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css"/>"/>
</head>
<body>
<header>
            <p id="username">You are logged in as ${login}</p>
            <a href="/login"><button type="button">logout / login</button></a>
            <a href="/userProfile"><button type="button">my profile</button></a>
    </header>
<h1>ONLINE BOOK SHOP</h1>
    <h2>Check information</h2>
    <h3>User:</h3>
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
           <tr>
                <td>Login :</td>
                <td>${user.getLogin()}</td>
           </tr>
       </table>

    <br><br>
    <h3>Book:</h3>
    <table>
           <tr>
               <td>Title :</td>
                <td>${book.getTitle()}</td>
           </tr>
           <tr>
                <td>Author :</td>
                <td>${book.getAuthor()}</td>
           </tr>
           <tr>
                 <td>Publisher :</td>
                 <td>${book.getPublisher()}</td>
           </tr>
           <tr>
                 <td>Year of writing :</td>
                 <td>${book.getYearOfWriting()}</td>
           </tr>
           <tr>
                  <td>Year of publishing :</td>
                  <td>${book.getYearOfPublishing()}</td>
           </tr>
           <tr>
                 <td>Number of pages :</td>
                 <td>${book.getPagesNumber()}</td>
           </tr>
           <tr>
                <td>Price :</td>
                <td>${book.getPrice()}</td>
           </tr>
    </table>
    <br>
        <form method="post" action="/buyBook">
            <input type="hidden" name="bookId" value="${book.getId()}">
            <input type="hidden" name="userName" value="${user.getLogin()}">
            <button type="submit">Buy</button>
            <p class="errorMessage">${errorMessage}</p>
         </form>
         <a href="/showBooks"><button type="button">Back to shop</button></a>
</body>
</html>