<%@include file="header.jsp"%>
<h2><%="Welcome to My Online shop Home Page" %>
</h2><br>
<form method="get" target='_blank' action="search">
    <!-- <url-pattern>/search</yrl-pattern> -->
    <input type="text" name="txt" size=30/>
    <select name="search">
        <option value="baidu">baidu</option>
        <option value="bing">bing</option>
        <option value="google">google</option>
    </select>
    <input type="submit" value="search"/>
</form>
<h1><%= "Hello World!!!" %>
</h1>

<br/>
<a href="hello-servlet">Hello Servlet!!!</a>
<br/>
<a href="hello">Student Info Servlet-week2</a>
<br/>
<a href="life">Life Cycle Servlet-week3</a>
<br/>
<a href="register.jsp">Register-getParameter-week3</a>
<br/>
<a href="config">Config parameter-week4</a>
<br/>
<a href="register.jsp">Register JDBC-week4</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>

<a href="login.jsp">Login-week5</a>
<%--<form>--%>
<%--    <span style="...">New User Registeration</span><br/><br/>--%>
<%--    <span style="...">Username</span><input type="text" name="name" required="true" style="..."><br/><br/>--%>
<%--    <span style="...">Password</span><input type="password" name="password" required="true" style="..."><br/><br/>--%>
<%--    <span style="...">Email</span><input type="email" name="email" required="true" style="..."><br/><br/>--%>
<%--    <span style="...">Gender</span>--%>
<%--    <span style="...">Male</span><input type="radio">--%>
<%--    <span style="...">Female</span><input type="radio"><br/><br/>--%>
<%--    <span style="...">Date of birth(yyyy-mm-dd)</span><input type="date" pattern="yyyy-mm-dd" required="true" style="..."><br/><br/>--%>
<%--    <input type="submit" value="register" style="...">--%>
<%--</form>--%>


<%@include file="footer.jsp"%>
