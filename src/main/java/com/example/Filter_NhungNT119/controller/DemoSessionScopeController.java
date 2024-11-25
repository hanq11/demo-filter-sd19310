package com.example.Filter_NhungNT119.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DemoSessionScopeController", value = {
        "/demo-session",
        "/hien-thi-session"
})
public class DemoSessionScopeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().contains("demo-session")) {
            HttpSession session = req.getSession();
            session.setAttribute("name", "From demo session");
        } else {
            req.getRequestDispatcher("/demo-session/hien-thi-session.jsp").forward(req, resp);
        }
    }
}
