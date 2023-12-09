package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query("select cv from MauSac cv where cv.ma like %:ten% or cv.ten like %:ten%")
    public List<MauSac> findByTenMaLike(String ten);

}
