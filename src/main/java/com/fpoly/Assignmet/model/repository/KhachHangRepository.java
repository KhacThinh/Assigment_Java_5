package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.model.entites.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {

    @Query("select cv from KhachHang cv where cv.ma like %:ten% or cv.ten like %:ten%")
    public List<KhachHang> findByTenMaLike(String ten);

    @Query(value = "with x as(select ROW_NUMBER() over (order by id desc) as rs, * from khach_hang \n" +
            "where trang_thai = 1) select * from x where rs between :page and :size", nativeQuery = true)
    public List<KhachHang> findByPageing(int page, int size);

}
