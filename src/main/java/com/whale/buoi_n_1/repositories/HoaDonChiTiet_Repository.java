package com.whale.buoi_n_1.repositories;

import com.whale.buoi_n_1.Utils.HibernateUtil;
import com.whale.buoi_n_1.entities.HoaDonChiTiet;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;

public class HoaDonChiTiet_Repository {
    Session session;

    public HoaDonChiTiet_Repository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<HoaDonChiTiet> findAll() {
        String query = "From HoaDonChiTiet";
        List<HoaDonChiTiet> listHoaDonCT = (List<HoaDonChiTiet>) session.createQuery(query).list();
        return listHoaDonCT;
    }

    public List<HoaDonChiTiet> findByIdHD(int idHD) {
        String query = "From HoaDonChiTiet WHERE hoaDon.id = :idHD";
        List<HoaDonChiTiet> listHoaDonCT = (List<HoaDonChiTiet>) session.createQuery(query)
                .setParameter("idHD", idHD).list();
        return listHoaDonCT;
    }

}
