package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.GioHang;
import com.fpoly.Assignmet.model.entites.KhachHang;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GioHangService {
    public List<GioHang> getAll();

    public GioHang save(GioHang gioHang);

    public GioHang edit(GioHang gioHang, UUID id);

    public GioHang delete(UUID id);

    public GioHang findById(UUID id);

    public GioHang findByKhachHang(KhachHang khachHang);
}
