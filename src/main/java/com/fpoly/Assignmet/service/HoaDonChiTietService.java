package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.HoaDonChiTiet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface HoaDonChiTietService {
    public List<HoaDonChiTiet> getAll();

    public HoaDonChiTiet save(HoaDonChiTiet hoaDonChiTiet);

    public HoaDonChiTiet edit(HoaDonChiTiet hoaDonChiTiet, UUID id);

    public HoaDonChiTiet delete(UUID id);

    public HoaDonChiTiet findById(UUID id);
}
