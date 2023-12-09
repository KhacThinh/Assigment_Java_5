package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SanPhamService {
    public List<SanPham> getAll();

    public SanPham save(SanPham sanPham);

    public SanPham edit(SanPham sanPham, UUID id);

    public SanPham delete(UUID id);

    public SanPham findById(UUID id);

    public List<SanPham> findByTenLikeIgnoreCase(String ten);
}
