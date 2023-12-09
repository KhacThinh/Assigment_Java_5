package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.ChucVu;
import com.fpoly.Assignmet.model.entites.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DongSanPhamRepository extends JpaRepository<DongSP, UUID> {
    @Query("select cv from DongSP cv where cv.ma like %:ten% or cv.ten like %:ten%")
    public List<DongSP> findChucVuByTenMaLike(String ten);
}
