package com.fpoly.Assignmet.service;

import com.fpoly.Assignmet.model.entites.NSX;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface NSXService {
    public List<NSX> getAll();

    public NSX save(NSX nsx);

    public NSX edit(NSX nsx, UUID id);

    public NSX delete(UUID id);

    public NSX findById(UUID id);

    public List<NSX> findByTenLikeIgnoreCase(String ten);
}
