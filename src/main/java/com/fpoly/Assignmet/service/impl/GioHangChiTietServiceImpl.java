package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.GioHangChiTiet;
import com.fpoly.Assignmet.model.repository.GioHangChiTietRepository;
import com.fpoly.Assignmet.service.GioHangChiTietService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    private final GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangChiTiet> getAll() {
        return gioHangChiTietRepository.findAll()
                .stream()
                .filter(ghct -> ghct.getChiTietSP().getTrangThai() == true)
                .collect(Collectors.toList());
    }

    @Override
    public GioHangChiTiet save(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet edit(GioHangChiTiet gioHangChiTiet, UUID id) {
        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet delete(UUID id) {
        GioHangChiTiet gioHangChiTiet = findById(id);
        if (Objects.nonNull(gioHangChiTiet)) {
            gioHangChiTietRepository.delete(gioHangChiTiet);
        }
        return gioHangChiTiet;
    }

    @Override
    public GioHangChiTiet findById(UUID id) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(id).get();
        return gioHangChiTiet;
    }
}
