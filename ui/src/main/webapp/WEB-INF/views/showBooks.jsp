<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>All books</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css"/>"/>
</head>
<body>
    <header>
            <p id="username">You are logged in as ${username}</p>
            <a href="<c:url value="/logout" />"><button type="button">logout / login</button></a>
            <a href="/userProfile"><button type="button">my profile</button></a>
            <a href="/adminPage"><button type="button">admin</button></a>
    </header>
<h1>ONLINE BOOK SHOP</h1>
 <h2>All books</h2>
<table border="1px black" class="itemsTable">
    <thead>
    <th width="50px"><h2>ID</h2></th>
    <th width="150px"><h2>Title</h2></th>
    <th width="150px"><h2>Author</h2></th>
    <th width="150px"><h2>Publisher</h2></th>
    <th width="150px"><h2>Year of writing</h2></th>
    <th width="150px"><h2>Year of publishing</h2></th>
    <th width="150px"><h2>Number of pages</h2></th>
    <th width="150px"><h2>Price RUB</h2></th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${books}">
             <tr>
                 <td>${item.getId()}</td>
                 <td>${item.getTitle()}</td>
                 <td>${item.getAuthor()}</td>
                 <td>${item.getPublisher()}</td>
                 <td>${item.getYearOfWriting()}</td>
                 <td>${item.getYearOfPublishing()}</td>
                 <td>${item.getPagesNumber()}</td>
                 <td>${item.getPrice()}</td>
                 <td>
                     <form method="get" action="/buyBook" >
                         <input type="hidden" name="bookId" value="${item.getId()}">
                         <input type="hidden" name="userName" value="${username}">
                         <button class="buyButton" type="submit">Buy</button>
                     </form>
                      <form method="get" action="/bookInfo" >
                            <input type="hidden" name="bookId" value="${item.getId()}">
                            <input type="hidden" name="userName" value="${username}">
                            <button class="infoButton" type="submit">Info</button>
                      </form>
                  </td>
             </tr>
         </c:forEach>
    </tbody>
</table>
</body>
</html>