package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.HoaDon;
import com.fpoly.Assignmet.model.repository.HoaDonRepository;
import com.fpoly.Assignmet.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public HoaDon save(HoaDon hoaDon) {
        HoaDon hoaDon1 = hoaDon;
        return hoaDonRepository.save(hoaDon1);
    }

    @Override
    public HoaDon edit(HoaDon hoaDon, UUID id) {
        HoaDon hoaDon1 = hoaDon;
        return hoaDonRepository.save(hoaDon1);
    }

    @Override
    public HoaDon delete(UUID id) {
        return null;
    }

    @Override
    public HoaDon findById(UUID id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        return hoaDon;
    }
}
