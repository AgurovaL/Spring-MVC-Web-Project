<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<html>
<head>
    <title>New book</title>
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
    <h2>Adding new book</h2>
    <div class="components">
       <form:form method="post" action="/addBook" modelAttribute="viewBook">
            <table>
                   <tr>
                        <td><form:label path="title">Title </form:label></td>
                        <td><form:input path="title" type="text"/></td>
                        <td><p class="title">${title}</p></td>
                   </tr>
                   <tr>
                         <td><form:label path="author">Author </form:label></td>
                         <td><form:input path="author" type="text"/></td>
                         <td><p class="author">${author}</p></td>
                   </tr>
                   <tr>
                         <td><form:label path="publisher">Publisher </form:label></td>
                         <td><form:input path="publisher" id="publisher" type="text"/></td>
                         <td><p class="publisher">${publisher}</p></td>
                   </tr>
                   <br><br>
                   <tr>
                         <td><form:label path="yearOfWriting">Year of writing </form:label></td>
                         <td><form:input path="yearOfWriting" id="yearOfWriting" type="number"/></td>
                         <td><p class="yearOfWriting">${yearOfWriting}</p></td>
                   </tr>
                   <tr>
                         <td><form:label path="yearOfPublishing">Year of publishing </form:label></td>
                         <td><form:input path="yearOfPublishing" id="yearOfPublishing" type="number"/></td>
                         <td><p class="yearOfPublishing">${yearOfPublishing}</p></td>
                   </tr>
                   <tr>
                          <td><form:label path="pagesNumber">Number of pages </form:label></td>
                          <td><form:input path="pagesNumber" id="pagesNumber" type="number"/></td>
                          <td><p class="pagesNumber">${pagesNumber}</p></td>
                   </tr>
                    <tr>
                         <td><form:label path="price">Price RUB </form:label></td>
                         <td><form:input path="price" id="price" type="number"/></td>
                         <td><p class="price">${price}</p></td>
                    </tr>
            </table>
            <br>
           <button class="button" type="submit" name="add">Add</button>
           <button class="button" type="reset" name="reset">Reset</button>
           <a href="/adminPage"><button type="button">Back</button></a>
        </form:form >
    </div>
</body>
</html>
