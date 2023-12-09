package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {

    @Query("select cv from ChucVu cv where cv.ma like %:ten% or cv.ten like %:ten%")
    public List<ChucVu> findChucVuByTenMaLike(String ten);

}
