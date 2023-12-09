package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NSXRepository extends JpaRepository<NSX, UUID> {
    @Query("select cv from NSX cv where cv.ma like %:ten% or cv.ten like %:ten%")
    public List<NSX> findByTenMaLike(String ten);
}
