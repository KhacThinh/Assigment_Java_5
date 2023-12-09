package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.HoaDon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface HoaDonService {
    public List<HoaDon> getAll();

    public HoaDon save(HoaDon hoaDon);

    public HoaDon edit(HoaDon hoaDon, UUID id);

    public HoaDon delete(UUID id);

    public HoaDon findById(UUID id);
}
