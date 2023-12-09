package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.NhanVien;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface NhanVienService {
    public List<NhanVien> getAll();

    public NhanVien save(NhanVien nhanVien);

    public NhanVien edit(NhanVien nhanVien, UUID id);

    public NhanVien delete(UUID id);

    public NhanVien findById(UUID id);

    public List<NhanVien> findByTenMaLike(String ten);

    public List<NhanVien> findPaing(int index, int size);
}
