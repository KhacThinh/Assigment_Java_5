package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.CuaHang;
import com.fpoly.Assignmet.model.entites.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    @Query("select cv from CuaHang cv where cv.ma like %:ten% or cv.ten like %:ten%")
    public List<CuaHang> findByTenMaLike(String ten);

    @Query(value = "with x as(select ROW_NUMBER() over (order by id desc) as rs, * from cua_hang \n" +
            "where trang_thai = 1) select * from x where rs between :page and :size", nativeQuery = true)
    public List<CuaHang> findByPageing(int page, int size);
}
