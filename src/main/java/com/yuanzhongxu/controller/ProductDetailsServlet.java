package com.yuanzhongxu.controller;

import com.yuanzhongxu.dao.ProductDao;
import com.yuanzhongxu.model.Category;
import com.yuanzhongxu.model.Product;

import javax.persistence.Id;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (request.getParameter("id") != null) {
                int productId = Integer.parseInt(request.getParameter("id"));
                ProductDao productDao = new ProductDao();
                Product product = productDao.findById(productId, con);
                request.setAttribute("p",product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace(); 
        }
        String path="/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
