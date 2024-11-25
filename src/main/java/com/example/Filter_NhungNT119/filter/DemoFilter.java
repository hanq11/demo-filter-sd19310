package com.example.Filter_NhungNT119.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "DemoFilter", value = {
        "/quan-ly/*",
        "/nhan-vien/*"
})
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        if(username != null) {
            if(role.equals("ql")) {
                chain.doFilter(req, resp);
            } else if(role.equals("nv")) {
                String uri = req.getRequestURI();
                if(uri.contains("nhan-vien")) {
                    chain.doFilter(req, resp);
                } else {
                    req.getRequestDispatcher("/demo-filter/403.jsp").forward(req, resp);
                }
            }
        } else {
            resp.sendRedirect("/demo-filter/login");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
