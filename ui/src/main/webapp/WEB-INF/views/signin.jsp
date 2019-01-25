<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html; charset = UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html itemscope itemtype="http://schema.org/Article">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/style.css"/>"/>

     <!-- BEGIN Pre-requisites -->
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
      </script>
      <script src="https://apis.google.com/js/client:platform.js?onload=start" async defer>
      </script>
      <!-- END Pre-requisites -->
        <script>
          function start() {
            gapi.load('auth2', function() {
              auth2 = gapi.auth2.init({
                client_id: 'YOUR_CLIENT_ID.apps.googleusercontent.com',
                // Scopes to request in addition to 'profile' and 'email'
                //scope: 'additional_scope'
              });
            });
          }
        </script>
</head>
<body>
<h1>ONLINE BOOK SHOP</h1>
    <h2>Login</h2>
    <div class="mainComponents">
     <form action="<c:url value='j_spring_security_check'/>" method='POST'>
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" id="userName" name="j_username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" id="password" name="j_password"/><td>
                </tr>
            </table>
             <br>
             <button class="button" type="submit">Sign in</button>
             <a href="/registration"><button type="button">Sign up</button></a>
             <a href="/showBooks"><button type="button">To books</button></a>
        </form>
    </div>

    <br>
    <!-- Add where you want your sign-in button to render -->
    <!-- Use an image that follows the branding guidelines in a real app -->
    <button id="signinButton">Sign in with Google</button>
    <script>
      $('#signinButton').click(function() {
        // signInCallback defined in step 6.
        auth2.grantOfflineAccess().then(signInCallback);
      });
    </script>
    <script>
    function signInCallback(authResult) {
      if (authResult['code']) {

        // Hide the sign-in button now that the user is authorized, for example:
        $('#signinButton').attr('style', 'display: none');

        // Send the code to the server
        $.ajax({
          type: 'POST',
          url: 'http://example.com/storeauthcode',
          // Always include an `X-Requested-With` header in every AJAX request,
          // to protect against CSRF attacks.
          headers: {
            'X-Requested-With': 'XMLHttpRequest'
          },
          contentType: 'application/octet-stream; charset=utf-8',
          success: function(result) {
            // Handle or verify the server response.
          },
          processData: false,
          data: authResult['code']
        });
      } else {
        // There was an error.
      }
    }
    </script>
</body>
</html>