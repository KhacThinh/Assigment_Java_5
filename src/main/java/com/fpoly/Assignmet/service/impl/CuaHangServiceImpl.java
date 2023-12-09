package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.ChiTietSP;
import com.fpoly.Assignmet.model.entites.CuaHang;
import com.fpoly.Assignmet.model.repository.CuaHangRepository;
import com.fpoly.Assignmet.service.CuaHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CuaHangServiceImpl implements CuaHangService {

    private final CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.findAll()
                .stream()
                .filter(cuaHang -> cuaHang.isTrangThai() == true)
                .collect(Collectors.toList());
    }

    @Override
    public CuaHang save(CuaHang cuaHang) {
        CuaHang ch = cuaHang;
        ch.setTrangThai(true);
        cuaHangRepository.save(ch);
        return ch;
    }

    @Override
    public CuaHang edit(CuaHang cuaHang, UUID id) {
        cuaHangRepository.save(cuaHang);
        return cuaHang;
    }

    @Override
    public CuaHang delete(CuaHang cuaHang) {
        cuaHang.setTrangThai(false);
        return cuaHangRepository.save(cuaHang);
    }

    @Override
    public CuaHang findById(UUID id) {
        CuaHang cuaHang = cuaHangRepository.findById(id).get();
        return cuaHang;
    }

    @Override
    public List<CuaHang> findByTenMaLike(String ten) {
        return cuaHangRepository.findByTenMaLike(ten);
    }

    @Override
    public List<CuaHang> findPaing(int index, int size) {
        int indexs = index * size - (size - 1);
        int lengh = index * size;
        List<CuaHang> chiTietSPS = cuaHangRepository.findByPageing(indexs, lengh);
        return chiTietSPS;
    }
}
