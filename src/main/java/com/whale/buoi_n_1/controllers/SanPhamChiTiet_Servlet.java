package com.whale.buoi_n_1.controllers;

import com.whale.buoi_n_1.repositories.SanPhamChiTiet_Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {
        "/san-pham-chi-tiet/index",
        "/san-pham-chi-tiet/create",
        "/san-pham-chi-tiet/store",
        "/san-pham-chi-tiet/update",
        "/san-pham-chi-tiet/edit",
        "/san-pham-chi-tiet/delete"
})
public class SanPhamChiTiet_Servlet extends HttpServlet {
    private SanPhamChiTiet_Repository repository = new SanPhamChiTiet_Repository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham-chi-tiet/index")) {
            this.index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idSp = Integer.parseInt(request.getParameter("idDetails"));
        if (idSp == 0 || idSp == null){
            request.getRequestDispatcher("/views/san_pham/index.jsp").forward(request, response);
        } else {
            request.setAttribute("listSanPhamChiTiet", repository.findById(idSp));
            request.getRequestDispatcher("/views/san_pham_chi_tiet/index.jsp").forward(request, response);
        }
    }

}
