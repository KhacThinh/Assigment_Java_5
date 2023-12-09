package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.ChucVu;
import com.fpoly.Assignmet.model.entites.DongSP;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DongSanPhamService {
    public List<DongSP> getAll();

    public DongSP save(DongSP dongSP);

    public DongSP edit(DongSP dongSP, UUID id);

    public DongSP delete(UUID id);

    public DongSP findById(UUID id);

    public List<DongSP> findByTenLikeIgnoreCase(String ten);
}
