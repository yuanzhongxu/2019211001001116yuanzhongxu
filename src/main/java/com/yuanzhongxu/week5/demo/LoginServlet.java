package com.yuanzhongxu.week5.demo;

import com.yuanzhongxu.dao.UserDao;
import com.yuanzhongxu.model.User;

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
        con = (Connection) getServletContext().getAttribute("con");
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
//    doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        UserDao userDao=new UserDao();
        try {

            User user=userDao.findByUsernamePassword(con, username, password);
            if(user!=null){

                String  rememberMe=request.getParameter("remember");
                if(rememberMe!=null&&rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);

                }

              HttpSession session= request.getSession();
              System.out.println("session id-->"+session.getId());
              session.setMaxInactiveInterval(10);

//                Cookie c=new Cookie("sessionid",""+user.getId());
//                c.setMaxAge(10*60);
//                response.addCookie(c);
                session.setAttribute("user",user);
                request.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message", "Username or Password Error!!!");

                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



//        String sql = "select username,password from yzx where username='" + username + "' and password='" + password + "'";
//        try {
//            PreparedStatement pr = con.prepareStatement(sql);
//            ResultSet re = pr.executeQuery();
//            PrintWriter out = response.getWriter();
////                Username==re.getString("username")&&Password==re.getString("password")
//            if (re.next()) {
//                request.setAttribute("id", re.getInt("id"));
//                request.setAttribute("username", re.getInt("username"));
//                request.setAttribute("password", re.getInt("password"));
//                request.setAttribute("email", re.getInt("email"));
//                request.setAttribute("gender", re.getInt("gender"));
//                request.setAttribute("birthdate", re.getInt("birthdate"));
////                    out.println("LOGIN SUCCESS!!!");
////                    out.println("WELCOME BACK: "+Username+"!!");
//                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
//            } else {
//                request.setAttribute("message", "Username or Password Error!!!");
//                //response.sendRedirect("login-fail.jsp");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            }
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}

