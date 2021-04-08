<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/7
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public void jspInit(){
        System.out.println("i am in jspinit()");
    }
%>
<html>
<head>
    <title>Life Cycle JSP</title>
</head>
<body>
<%System.out.println("i am jspservice()");%>
</body>
</html>
<!-- service -->
<%!
    public void jspDestroy(){
        System.out.println("i am in jspDestroy()");
    }
%>
