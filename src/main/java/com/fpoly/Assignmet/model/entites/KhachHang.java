package com.fpoly.Assignmet.model.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @NotEmpty(message = "Không được để trống mã!")
    @Column(unique = true, nullable = false)
    private String ma;

    @NotEmpty(message = "Không được để trống họ!")
    private String ho;

    private String tenDem;

    @NotEmpty(message = "Không được để trống tên!")
    private String ten;

    @Past(message = "Ngày sinh của bạn vượt thời gian!")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ngaySinh;


    @NotEmpty(message = "Không được để trống số điện thoại!")
    @Length(min = 10, max = 10, message = "Số điện thoại phải đủ 10 số!")
    private String sdt;

    @NotEmpty(message = "Không được để trống địa chỉ!")
    private String diaChi;

    @NotEmpty(message = "Không được để trống thành phố!")
    private String thanhPho;

    @NotEmpty(message = "Không được để trống quốc gia")
    private String quocGia;

    @NotEmpty(message = "Không được để trống mật khẩu")
    @Length(min = 8, message = "Mật khẩu phải trên 8 ký tự!")
    private String matKhau;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HoaDon> hoaDons;

    private boolean trangThai;

    public KhachHang(String ma, String ho, String tenDem, String ten, Date ngaySinh, String sdt, String diaChi, String thanhPho, String quocGia, String matKhau, boolean trangThai) {
        this.ma = ma;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }
}
