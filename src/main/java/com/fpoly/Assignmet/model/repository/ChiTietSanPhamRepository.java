package com.fpoly.Assignmet.model.repository;

import com.fpoly.Assignmet.model.entites.ChiTietSP;
import com.fpoly.Assignmet.model.entites.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSP, UUID> {
    @Query("select cv from ChiTietSP cv join SanPham sp on cv.idSP.id = sp.id where sp.ten like %:ten% ")
    public List<ChiTietSP> findChucVuByTenMaLike(String ten);

    @Query(value = "with x as(select ROW_NUMBER() over (order by id desc) as rs, * from chi_tietsp \n" +
            "where trang_thai = 1) select * from x where rs between :page and :size", nativeQuery = true)
    public List<ChiTietSP> findByPageing(int page, int size);
}
