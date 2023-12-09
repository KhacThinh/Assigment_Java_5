package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
}
