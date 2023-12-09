package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.CuaHang;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CuaHangService {

    public List<CuaHang> getAll();

    public CuaHang save(CuaHang cuaHang);

    public CuaHang edit(CuaHang cuaHang, UUID id);

    public CuaHang delete(CuaHang cuaHang);

    public CuaHang findById(UUID id);

    public List<CuaHang> findByTenMaLike(String ten);

    public List<CuaHang> findPaing(int index, int size);
}
