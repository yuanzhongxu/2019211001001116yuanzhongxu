<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/8
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<h1>Login</h1>
<%
     if(!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }

        }
    }
%>

<form method="post" action="login"><!-- with dopost()in servlet-->
    Username<input type="text" name="username" value="<%=username%>"/><br/>
    Password<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked/>RemeberMe<br>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp"%>