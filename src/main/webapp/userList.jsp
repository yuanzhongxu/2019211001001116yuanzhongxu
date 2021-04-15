<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/15
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@page import="java.sql.ResultSet" %>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>Id</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
        ResultSet re= (ResultSet) request.getAttribute("rsname");
        if(re==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else{


    while (re.next()) {
        int id = re.getInt(1);
        String username = re.getString(2);
        String password = re.getString(3);
        String email = re.getString(4);
        String gender = re.getString(5);
        String birthdate = re.getString(6);
        out.println("<tr>\n" +
                "<td>" + id + "</td>\n" + "<td>" + username + "</td>\n" + "<td>" + password + "</td>\n" + "<td>" + email + "</td>\n" +
                "<td>" + gender + "</td>\n " +
                "<td>" + birthdate + "</td>\n" +
                "</tr>");
    }
        }
                    %>
</table>

<%@include file="footer.jsp"%>