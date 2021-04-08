<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/7
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter JSP</title>
</head>
<body>
<%int count=0;%>
this Page has access:<%out.println(++count);%>
</body>
</html>
