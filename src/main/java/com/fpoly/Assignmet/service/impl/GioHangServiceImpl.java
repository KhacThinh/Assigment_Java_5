package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.GioHang;
import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.model.repository.GioHangRepository;
import com.fpoly.Assignmet.service.GioHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GioHangServiceImpl implements GioHangService {

    private final GioHangRepository gioHangRepository;

    @Override
    public List<GioHang> getAll() {
        return gioHangRepository.findAll();
    }

    @Override
    public GioHang save(GioHang gioHang) {
        return gioHangRepository.save(gioHang);
    }

    @Override
    public GioHang edit(GioHang gioHang, UUID id) {
        return gioHangRepository.save(gioHang);
    }

    @Override
    public GioHang delete(UUID id) {
        GioHang gioHang = findById(id);
        gioHangRepository.delete(gioHang);
        return gioHang;
    }

    @Override
    public GioHang findById(UUID id) {
        GioHang hang = gioHangRepository.findById(id).get();
        return hang;
    }

    @Override
    public GioHang findByKhachHang(KhachHang khachHang) {
        for (GioHang gh : gioHangRepository.findAll()) {
            if (gh.getKhachHang().equals(khachHang)) {
                return gh;
            }
        }
        return null;
    }

}
