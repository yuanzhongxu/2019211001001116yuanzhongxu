package com.yuanzhongxu.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name="LoginServlet",value="/login")
public class LoginServlet extends HttpServlet {

    Connection con = null;
    @Override
    public void init() throws ServletException {

        String driver = getServletConfig().getServletContext().getInitParameter("driver");
        String url = getServletConfig().getServletContext().getInitParameter("url");
        String username = getServletConfig().getServletContext().getInitParameter("username");
        String password = getServletConfig().getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");


//        String sql="select username,password from yzx where 'username='+Username +'and password='+Password ";
        String sql = "select username,password from yzx where username='"+Username+"' and password='"+Password+"'";
        try{
            PreparedStatement pr=con.prepareStatement(sql);
            ResultSet re = pr.executeQuery();
            PrintWriter out= response.getWriter();
//                Username==re.getString("username")&&Password==re.getString("password")
                if(re.next())

                {
                    out.println("LOGIN SUCCESS!!!");
                    out.println("WELCOME BACK: "+Username+"!!");
                }
                else
                {

                    response.sendRedirect("login-fail.jsp");
                }


                }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
