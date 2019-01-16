<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <div class="mainComponents">
        <form:form class="form" method="post" action="/login" modelAttribute="userAccount">
            <table>
                <tr>
                    <td><form:label path="login">Login </form:label></td>
                    <td><form:input type="text" path="login"/></td>
                    <td><p class="login">${login}</p></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password </form:label></td>
                    <td><form:input path = "password" type="password"/></td>
                    <td><p class="password">${password}</p></td>
                 </tr>
             </table>
             <p class="errorMessage">${errorMessage}</p>
             <button class="button" type="submit" name="login">Login</button>
        </form:form>

    </div>
</body>
</html>