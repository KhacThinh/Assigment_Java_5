package com.fpoly.Assignmet.model.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;

    private String ma;

    private Date ngayTao;

    private Date ngayThanhToan;

    private Date ngayShip;

    private Date ngayNhan;

    private int tinhTrang;

    private String tenNguoiNhan;

    @Lob
    private String diaChi;

    private String sdt;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> chiTietHoaDon;

    public void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        chiTietHoaDon.add(hoaDonChiTiet);
    }

}