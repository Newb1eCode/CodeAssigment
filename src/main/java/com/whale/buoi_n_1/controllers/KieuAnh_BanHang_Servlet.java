package com.whale.buoi_n_1.controllers;

import com.whale.buoi_n_1.entities.HoaDon;
import com.whale.buoi_n_1.entities.HoaDonChiTiet;
import com.whale.buoi_n_1.entities.SanPhamChiTiet;
import com.whale.buoi_n_1.repositories.HoaDonChiTiet_Repository;
import com.whale.buoi_n_1.repositories.HoaDon_Repository;
import com.whale.buoi_n_1.repositories.SanPhamChiTiet_Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "DuongKieuAnh_Store_Servlet", value = {
        "/ban-hang/index",
        "/ban-hang/store"
})
public class KieuAnh_BanHang_Servlet extends HttpServlet {

    private SanPhamChiTiet_Repository spctRepository = new SanPhamChiTiet_Repository();
    private HoaDon_Repository hdRepository = new HoaDon_Repository();
    private HoaDonChiTiet_Repository hdctRepository = new HoaDonChiTiet_Repository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("index")){
            this.index(req, resp);
        }
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Begin : San Pham Chi Tiet
        List<SanPhamChiTiet> listSpct = spctRepository.findByTrangThai();
        req.setAttribute("listSpct", listSpct);
//        End : San Pham Chi Tiet

//        Begin : Hoa Don
        List<HoaDon> listHD = hdRepository.findByTrangThai();
        req.setAttribute("listHD", listHD);
//        End : Hoa Don

//        Begin : Hoa Don Chi Tiet
        if (req.getParameter("idHD") != null){
            int idHD = Integer.parseInt(req.getParameter("idHD"));
            List<HoaDonChiTiet> listHDCT = hdctRepository.findByIdHD(idHD);
            HoaDon value = hdRepository.findById(idHD);
            req.setAttribute("hoaDonByID", value);
            req.setAttribute("listHDCT", listHDCT);
            req.getRequestDispatcher("/views/ban_hang/whale_BanHang.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/views/ban_hang/whale_BanHang.jsp").forward(req, resp);
        }
//        End : Hoa Don Chi Tiet
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
