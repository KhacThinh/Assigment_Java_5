package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.ChiTietSP;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ChiTietSanPhamService {
    public List<ChiTietSP> findAllByObject();

    public ChiTietSP save(ChiTietSP e);

    public ChiTietSP update(ChiTietSP e);

    public ChiTietSP delete(UUID id);

    public ChiTietSP findById(UUID id);

    public List<ChiTietSP> findByName(String name);

    public List<ChiTietSP> findPaing(int index, int size);
}
