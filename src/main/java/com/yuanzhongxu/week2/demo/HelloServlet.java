package com.yuanzhongxu.week2.demo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet",
initParams={
        @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
        @WebInitParam(name="url",value="jdbc:sqlserver://localhost;databaseName=useryzx"),
        @WebInitParam(name="username",value="sa"),
        @WebInitParam(name="password",value="yzx.147369"),
}
)

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}