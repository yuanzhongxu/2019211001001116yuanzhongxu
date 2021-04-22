<%@ page import="com.yuanzhongxu.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/16
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<h1>User Info</h1>
<%
    User user= (User) request.getAttribute("user");
%>
<table>
    <tr>
        <td> Username:</td><td><%=user.getUsername()%></td><br>
        <td> Password:</td><td><%=user.getPassword()%></td<br>
        <td> Email:</td><td><%=user.getEmail()%></td><br>
        <td> Gender:</td><td><%=user.getGender()%></td><br>
        <td> Birth Date:</td><td><%=user.getBirthdate()%></td><br>

    </tr>
</table>

<%@include file="footer.jsp"%>