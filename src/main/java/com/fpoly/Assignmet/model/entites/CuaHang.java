package com.fpoly.Assignmet.model.entites;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty(message = "Không được để trống mã!")
    @Column(unique = true, nullable = false)
    private String ma;

    @NotEmpty(message = "Không được để trống tên!")
    private String ten;

    @NotEmpty(message = "Không được để trống địa chỉ!")
    private String diaChi;

    @NotEmpty(message = "Không được để trống thành phố!")
    private String thanhPho;

    @NotEmpty(message = "Không được để trống quốc gia!")
    private String quocGia;

    private boolean trangThai;

//    @OneToMany(mappedBy = "idCH", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<NhanVien> list;

    public CuaHang(String ma, String ten, String diaChi, String thanhPho, String quocGia, boolean trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }
}
