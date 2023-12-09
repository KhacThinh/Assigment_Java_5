package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.model.repository.KhachHangRepository;
import com.fpoly.Assignmet.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll().stream()
                .filter(cuaHang -> cuaHang.isTrangThai() == true)
                .collect(Collectors.toList());
    }

    @Override
    public KhachHang save(KhachHang khachHang) {
        khachHang.setTrangThai(true);
        khachHangRepository.save(khachHang);
        return khachHang;
    }

    @Override
    public KhachHang edit(KhachHang khachHang, UUID id) {
        khachHangRepository.save(khachHang);
        return khachHang;
    }

    @Override
    public KhachHang delete(KhachHang khachHang) {
        khachHang.setTrangThai(false);
        khachHangRepository.save(khachHang);
        return khachHang;
    }

    @Override
    public KhachHang findById(UUID id) {
        KhachHang khachHang = khachHangRepository.findById(id).get();
        return khachHang;
    }


    @Override
    public List<KhachHang> findPaing(int index, int size) {
        int indexs = index * size - (size - 1);
        int lengh = index * size;
        List<KhachHang> chiTietSPS = khachHangRepository.findByPageing(indexs, lengh);
        return chiTietSPS;
    }

    @Override
    public List<KhachHang> findByMaLikeIgnoreCaseAndTenLikeIgnoreCase(String ten) {
        return khachHangRepository.findByTenMaLike(ten);
    }

}
