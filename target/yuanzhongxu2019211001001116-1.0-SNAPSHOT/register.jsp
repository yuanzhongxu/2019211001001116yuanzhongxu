<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/25
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="register"><!-- with dopost()in servlet-->
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender<input type="radio" name="gender" value="Male">Male<input type="radio" name="gender" value="Female">Female<br/>
    Date of Brith:<input type="text" name="birthdate"/><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
