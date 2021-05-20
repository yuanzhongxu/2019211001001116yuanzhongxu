<%@ page import="com.yuanzhongxu.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/29
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>

<%
    User u1=(User) session.getAttribute("user");
%>
<form method="post" action="updateUser"><!-- with dopost()in servlet-->
    <input type="hidden" name="id" value="<%=u1.getId()%>">
    Username<input type="text" name="username" value=<%=u1.getUsername()%>/><br/>
    Password<input type="password" name="password" value=<%=u1.getPassword()%>/><br/>
    Email<input type="text" name="email" value=<%=u1.getEmail()%>/><br/>
    Gender<input type="radio" name="gender" value="Male" <%="male".equals(u1.getGender()) ? "checked":""%>>Male
    <input type="radio" name="gender" value="Female" <%="female".equals(u1.getGender()) ? "checked":""%>>Female<br/>
    Date of Brith:<input type="text" name="birthdate" value="<%=u1.getBirthdate()%>"/><br/>
    <input type="submit" value="Save Changes"/>
</form>


<%@include file="footer.jsp"%>