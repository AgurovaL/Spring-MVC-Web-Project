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
            <table>
                   <tr>
                        <td><form:label path="firstName">First name </form:label></td>
                        <td><form:input path="firstName" type="text"/></td>
                        <td><p class="firstName">${firstName}</p></td>
                   </tr>
                   <tr>
                         <td><form:label path="lastName">Last name </form:label></td>
                         <td><form:input path="lastName" type="text"/></td>
                         <td><p class="lastName">${lastName}</p></td>
                   </tr>
                   <tr>
                         <td><form:label path="address">Address </form:label></td>
                         <td><form:input path="address" id="address" type="text"/></td>
                         <td><p class="address">${address}</p></td>
                   </tr>
                   <br><br>
                   <tr>
                         <td><form:label path="login">Login </form:label></td>
                         <td><form:input path="login" id="login" type="text"/></td>
                         <td><p class="login">${login}</p></td>
                   </tr>
                   <tr>
                         <td><form:label path="password">Password </form:label></td>
                         <td><form:input path="password" id="password" type="password"/></td>
                         <td><p class="password">${password}</p></td>
                   </tr>
                   <tr>
                          <td><form:label path="password2">Re-enter Password </form:label></td>
                          <td><form:input path="password2" id="password2" type="password"/></td>
                          <td><p class="password2">${password2}</p></td>
                   </tr>
            </table>
            <p class="loginError">${errorMessage}</p>
           <button class="button" type="submit" name="registration">Registration</button>
           <button class="button" type="reset" name="reset">Reset</button>
        </form:form >
    </div>
    <script src="<c:url value="/scripts/errors.js"/>"></script>
    <script src="<c:url value="/scripts/validation.js"/>"></script>
</body>
</html>
