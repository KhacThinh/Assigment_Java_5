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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChiTietSP {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham idSP;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    private NSX idNsx;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    private MauSac idMauSac;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    private DongSP idDongSP;

    @NotNull(message = "Không được trống năm bao hành!")
    @Positive(message = "Năm bảo hàng phải là số dương!")
    private Integer namBH;

    @NotNull(message = "Không được trống số lượng tồn!")
    @Positive(message = "Năm bảo hàng phải là số dương!")
    private Integer soLuongTon;

    @NotNull(message = "Không được trống giá nhập!")
    @Positive(message = "Giá nhập phải là số dương!")
    private Integer giaNhap;

    @NotNull(message = "Không được trống giá bán!")
    @Positive(message = "Giá bán phải là số dương!")
    private Integer giaBan;

    @NotEmpty(message = "Không được để trống mô tả!")
    private String moTa;

    private Boolean trangThai;

//    @OneToOne(mappedBy = "idChiTietSP")
//    private GioHangChiTiet gioHangChiTiet;

    @OneToMany(mappedBy = "chiTietSanPham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTiets;


    public ChiTietSP(SanPham idSP, NSX idNsx, MauSac idMauSac, DongSP idDongSP, Integer namBH, Integer soLuongTon, Integer giaNhap, Integer giaBan, String moTa, Boolean trangThai) {
        this.idSP = idSP;
        this.idNsx = idNsx;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }
}
