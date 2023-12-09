package com.fpoly.Assignmet.model.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty(message = "Không được để trống mã")
    @Column(unique = true, nullable = false)
    private String ma;

    @NotEmpty(message = "Không được để trống họ")
    private String ho;

    private String tenDem;

    @NotEmpty(message = "Không được để trống tên")
    private String ten;

    private boolean gioiTinh;

    @Past(message = "Ngày sinh của bạn đã vượt hiện tại!")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ngaySinh;

    @NotEmpty(message = "Không được để trống địa chỉ")
    private String diaChi;

    @NotEmpty(message = "Không được để trống số điện thoại")
    @Length(min = 10, max = 10, message = "Số điện thoại phải có 10 số")
    private String sdt;

    @NotEmpty(message = "Không được để trống mật khẩu")
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdCH", referencedColumnName = "id")
    private CuaHang idCH;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdCV", referencedColumnName = "id")
    private ChucVu idCV;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdGuiBC", referencedColumnName = "id")
    private NhanVien idGuiBC;

    private boolean trangThai;

    public NhanVien(String ma, String ho, String tenDem, String ten, boolean gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, CuaHang idCH, ChucVu idCV, NhanVien idGuiBC, boolean trangThai) {
        this.ma = ma;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCH = idCH;
        this.idCV = idCV;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }
}
