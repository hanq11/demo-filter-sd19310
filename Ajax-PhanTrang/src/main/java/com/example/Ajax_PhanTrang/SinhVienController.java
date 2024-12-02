package com.example.Ajax_PhanTrang;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SinhVienController1", value = {
        "/api/sinh-vien/get-all"
})
public class SinhVienController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<SinhVien> danhSach = new ArrayList<>();
        danhSach.add(new SinhVien("SV001", "Nguyen Van A", 19, false, "UDPM"));
        danhSach.add(new SinhVien("SV002", "Nguyen Thi B", 20, true, "CNTT"));
        danhSach.add(new SinhVien("SV003", "Nguyen Van C", 21, false, "UDPM"));
        danhSach.add(new SinhVien("SV004", "Nguyen Van D", 23, true, "CNTT"));
        danhSach.add(new SinhVien("SV005", "Nguyen Van E", 30, false, "UDPM"));
        // Chuyen doi ArrayList thanh dang json
        Gson gson = new Gson();
        String data = gson.toJson(danhSach);
        // Dat kieu du lieu tra ve cua resp
        resp.setContentType("application/json");
        // Hien thi json len man hinh
        PrintWriter pw = resp.getWriter();
        pw.write(data);
        pw.flush();;
    }
}

