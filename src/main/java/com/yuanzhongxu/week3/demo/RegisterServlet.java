package com.yuanzhongxu.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        String BirthDate = request.getParameter("birthdate");

//        PrintWriter writer=response.getWriter();
//        writer.println("<br>username:"+username);
//        writer.println("<br>password:"+password);
//        writer.println("<br>email:"+email);
//        writer.println("<br>gender:"+gender);
//        writer.println("<br>birth Date:"+birthDate);
//        writer.close();
        String sql = "insert into yzx(username,password,email,gender,birthdate)"+"values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,Username);
            ps.setString(2,Password);
            ps.setString(3,Email);
            ps.setString(4,Gender);
            ps.setString(5,BirthDate);
            ps.executeUpdate();
            System.out.println("323");
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String select = "select id,username,password,email,birthdate from yzx";
        try {
            PreparedStatement pr=con.prepareStatement(select);
            ResultSet re = pr.executeQuery();
            //response.setContentType("text/html");
            PrintWriter out= response.getWriter();

//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>select</title>");
//            out.println("<body>");
//            out.println("<table border=\"2\">");
//            out.println("<tr>\n" +
//                    "<td>id</td>\n" + "<td>username</td>\n" + "<td>password</td>\n" + "<td>email</td>\n" +
//                    "<td>gender</td>\n" +
//                    "<td>birthDate</td>\n" +
//                    "</tr>");
//            while (re.next()){
//                String id = re.getString(1);
//                String username = re.getString(2);
//                String password = re.getString(3);
//                String email = re.getString(4);
//                String gender =re.getString(5);
//                String birthdate =re.getString(6);
//                out.println("<tr>\n" +
//                        "<td>" + id + "</td>\n" + "<td>" + username + "</td>\n" + "<td>" + password + "</td>\n" + "<td>" + email + "</td>\n" +
//                        "<td>" + gender + "</td>\n " +
//                        "<td>" + birthdate + "</td>\n" +
//                        "</tr>");
//            }
//            out.println("</table>");
//            out.println("</body>"+"</head>"+"</html>");
            request.setAttribute("name",re);
            request.getRequestDispatcher("userList.jsp").forward(request,response);
            System.out.println("i am in RegisterServlet-->doPost--> after forward()");
            out.close();
            pr.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
