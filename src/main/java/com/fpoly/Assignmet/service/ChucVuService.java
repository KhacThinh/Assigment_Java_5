package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.ChucVu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ChucVuService {
    public List<ChucVu> getAll();

    public ChucVu save(ChucVu chucVu);

    public ChucVu edit(ChucVu chucVu, UUID id);

    public ChucVu delete(UUID id);

    public ChucVu findById(UUID id);

    public List<ChucVu> findByTenLikeIgnoreCase(String ten);
}
