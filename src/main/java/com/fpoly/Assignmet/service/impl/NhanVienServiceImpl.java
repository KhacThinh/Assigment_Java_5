package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.CuaHang;
import com.fpoly.Assignmet.model.entites.NhanVien;
import com.fpoly.Assignmet.model.repository.NhanVienRepository;
import com.fpoly.Assignmet.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll().stream()
                .filter(cuaHang -> cuaHang.isTrangThai() == true)
                .collect(Collectors.toList());
    }

    @Override
    public NhanVien save(NhanVien nhanVien) {
        nhanVien.setTrangThai(true);
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien edit(NhanVien nhanVien, UUID id) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien delete(UUID id) {
        NhanVien nhanVien = findById(id);
        nhanVien.setTrangThai(false);
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien findById(UUID id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).get();
        return nhanVien;
    }

    @Override
    public List<NhanVien> findByTenMaLike(String ten) {
        return nhanVienRepository.findByTenMaLike(ten);
    }

    @Override
    public List<NhanVien> findPaing(int index, int size) {
        int indexs = index * size - (size - 1);
        int lengh = index * size;
        List<NhanVien> chiTietSPS = nhanVienRepository.findByPageing(indexs, lengh);
        return chiTietSPS;
    }
}
