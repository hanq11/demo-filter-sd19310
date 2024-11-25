package com.example.Filter_NhungNT119.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CongTyController", value = {
        "/quan-ly/hien-thi",
        "/nhan-vien/hien-thi"
})
public class CongTyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("quan-ly")) {
            req.getRequestDispatcher("/demo-filter/quan-ly.jsp").forward(req, resp);
        } else if(uri.contains("nhan-vien")) {
            req.getRequestDispatcher("/demo-filter/nhan-vien.jsp").forward(req, resp);
        }
    }
}
