package com.example.Filter_NhungNT119.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DemoFilterController", value = {
        "/demo-filter/login",
        "/demo-filter/logout",
})
public class DemoFilterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("login")) {
            request.getRequestDispatcher("/demo-filter/login.jsp").forward(request, response);
        } else if(uri.contains("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("/demo-filter/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();
        if(username.equals("ql") && password.equals("ql")) {
            httpSession.setAttribute("username", "ql");
            httpSession.setAttribute("role", "ql");
            response.sendRedirect("/quan-ly/hien-thi");
        } else if(username.equals("nv") && password.equals("nv")) {
            httpSession.setAttribute("username", "nv");
            httpSession.setAttribute("role", "nv");
            response.sendRedirect("/nhan-vien/hien-thi");
        } else {
            request.setAttribute("message", "Thong tin dang nhap sai");
            request.getRequestDispatcher("/demo-filter/login.jsp").forward(request, response);
        }
    }
}
