package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.GioHangChiTiet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GioHangChiTietService {
    public List<GioHangChiTiet> getAll();

    public GioHangChiTiet save(GioHangChiTiet gioHangChiTiet);

    public GioHangChiTiet edit(GioHangChiTiet gioHangChiTiet, UUID id);

    public GioHangChiTiet delete(UUID id);

    public GioHangChiTiet findById(UUID id);
}
