package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.HoaDonChiTiet;
import com.fpoly.Assignmet.model.repository.HoaDonChiTietRepository;
import com.fpoly.Assignmet.service.HoaDonChiTietService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    private final HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public HoaDonChiTiet save(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet edit(HoaDonChiTiet hoaDonChiTiet, UUID id) {
        return hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet delete(UUID id) {
        return null;
    }

    @Override
    public HoaDonChiTiet findById(UUID id) {
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(id).get();
        return hoaDonChiTiet;
    }
}
