package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.DongSP;
import com.fpoly.Assignmet.model.entites.MauSac;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface MauSacService {
    public List<MauSac> getAll();

    public MauSac save(MauSac mauSac);

    public MauSac edit(MauSac tmauSac, UUID id);

    public MauSac delete(UUID id);

    public MauSac findById(UUID id);

    public List<MauSac> findByTenLikeIgnoreCase(String ten);
}
