package com.example.Ajax_PhanTrang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BacSiController", value = {
        "/bac-si/hien-thi",
        "/bac-si/phan-trang"
})
public class BacSiController extends HttpServlet {
    BacSiRepository bacSiRepository = new BacSiRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            req.setAttribute("danhSach", bacSiRepository.hienThi());
            req.getRequestDispatcher("/phan-trang.jsp").forward(req, resp);
        } else {
            int page = 0;
            if(req.getParameter("page") != null) {
                page = Integer.valueOf(req.getParameter("page"));
            }
            req.setAttribute("page", page);
            req.setAttribute("danhSach", bacSiRepository.phanTrang(page, 2));
            req.getRequestDispatcher("/phan-trang.jsp").forward(req, resp);
        }
    }
}
