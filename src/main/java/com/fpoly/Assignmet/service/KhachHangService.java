package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.model.entites.NhanVien;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface KhachHangService {

    public List<KhachHang> getAll();

    public KhachHang save(KhachHang khachHang);

    public KhachHang edit(KhachHang khachHang, UUID id);

    public KhachHang delete(KhachHang khachHang);

    public KhachHang findById(UUID id);

    public List<KhachHang> findPaing(int index, int size);

    public List<KhachHang> findByMaLikeIgnoreCaseAndTenLikeIgnoreCase(String ten);
}
