<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Registration</title>
</head>
<body>
    <h2>Registration</h2>
    <div class="components">
       <form:form method="post" action="/register" modelAttribute="viewUser">
           <p>
                <form:label path="firstName">First name </form:label>
                <form:input path="firstName" type="text"/><br>
           </p>
           <p>
                <form:label path="lastName">Last name </form:label>
                <form:input path="lastName" type="text"/><br>
           </p>
           <p>
                <form:label path="address">Address </form:label>
                <form:input path="address" id="address" type="text"/><br>
           </p>
           <br><br>
           <p>
                <form:label path="login">Login </form:label>
                <form:input path="login" id="login" type="text"/><br>
           </p>
           <p>
                <form:label path="password">Password </form:label>
                <form:input path="password" id="password" type="password"/><br>
           </p>
           <p>
                 <form:label path="password2">Re-enter Password </form:label>
                 <form:input path="password2" id="password2" type="password"/><br>
           </p>
           <p class="loginError">${errorMessage}</p>
           <button class="button" type="submit" name="registration">Registration</button>
           <button class="button" type="reset" name="reset">Reset</button>
        </form:form >
    </div>
    <script src="<c:url value="/scripts/errors.js"/>"></script>
    <script src="<c:url value="/scripts/validation.js"/>"></script>
</body>
</html>
