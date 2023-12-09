package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {
    @Query(value = "delete from delete from gio_hang_chi_tiet where id = :uuid", nativeQuery = true)
    public GioHangChiTiet deleteGioHangChiTiet(String uuid);
}
