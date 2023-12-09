package com.fpoly.Assignmet.model.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "HoaDonChiTiet")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP chiTietSanPham;

    @Min(0)
    private int soLuong;
    private int donGia;

    public HoaDonChiTiet(HoaDon hoaDon, ChiTietSP chiTietSanPham, int soLuong, int donGia) {
        this.hoaDon = hoaDon;
        this.chiTietSanPham = chiTietSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
}