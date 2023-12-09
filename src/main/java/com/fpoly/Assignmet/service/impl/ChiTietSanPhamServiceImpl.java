package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.ChiTietSP;
import com.fpoly.Assignmet.model.repository.ChiTietSanPhamRepository;
import com.fpoly.Assignmet.service.ChiTietSanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    private final ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<ChiTietSP> findAllByObject() {
        return chiTietSanPhamRepository.findAll()
                .stream().filter(chiTietSP -> chiTietSP.getTrangThai() == true)
                .collect(Collectors.toList());
    }

    @Override
    public ChiTietSP save(ChiTietSP e) {
        e.setTrangThai(true);
        return chiTietSanPhamRepository.save(e);
    }

    @Override
    public ChiTietSP update(ChiTietSP e) {
        e.setTrangThai(true);
        return chiTietSanPhamRepository.save(e);
    }

    @Override
    public ChiTietSP delete(UUID id) {
        ChiTietSP chiTietSP = findById(id);
        chiTietSP.setTrangThai(false);
        chiTietSanPhamRepository.save(chiTietSP);
        return chiTietSP;
    }

    @Override
    public ChiTietSP findById(UUID id) {
        ChiTietSP chiTietSP = chiTietSanPhamRepository.findById(id).get();
        return chiTietSP;
    }

    @Override
    public List<ChiTietSP> findByName(String name) {
        return chiTietSanPhamRepository.findChucVuByTenMaLike(name);
    }

    @Override
    public List<ChiTietSP> findPaing(int index, int size) {
        int indexs = index * size - (size - 1);
        int lengh = index * size;
        List<ChiTietSP> chiTietSPS = chiTietSanPhamRepository.findByPageing(indexs, lengh);
        return chiTietSPS;
    }
}
