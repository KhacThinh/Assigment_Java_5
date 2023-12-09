package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.DongSP;
import com.fpoly.Assignmet.model.entites.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Query("select cv from SanPham cv where cv.ma like %:ten% or cv.ten like %:ten%")
    public List<SanPham> findByTenMaLike(String ten);
}
