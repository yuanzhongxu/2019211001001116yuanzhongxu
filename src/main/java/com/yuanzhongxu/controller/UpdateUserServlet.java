package com.yuanzhongxu.controller;

import com.yuanzhongxu.dao.UserDao;
import com.yuanzhongxu.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con;
    public void init() throws ServletException{
        con =(Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Connection con = null;
        int Id= Integer.parseInt(request.getParameter("id"));
        String Username=request.getParameter("username");
        String Password=request.getParameter("password");
        String Email=request.getParameter("email");
        String Gender=request.getParameter("gender");
        Date Birthdate= Date.valueOf(request.getParameter("birthdate"));
        User user=new User();
        user.setId(Id);
        user.setUsername(Username);
        user.setPassword(Password);
        user.setEmail(Email);
        user.setGender(Gender);
        user.setBirthdate(Birthdate);

        UserDao userDao=new UserDao();
        try {
            userDao.updateUser(con,user);
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(7*24*60);
            session.setAttribute("user",user);
            request.getRequestDispatcher("accountDetails").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
