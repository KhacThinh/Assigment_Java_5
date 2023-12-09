package com.fpoly.Assignmet.model.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DongSP")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DongSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @NotEmpty(message = "Không được để trống mã")
    @Column(unique = true, nullable = false)
    private String ma;

    @NotEmpty(message = "Không được để trống tên")
    private String ten;

//    @OneToMany(mappedBy = "idDongSP")
//    private List<ChiTietSP> chiTietSPS;
//
//    public void addChiTietSanPham(ChiTietSP chiTietSP) {
//        chiTietSPS.add(chiTietSP);
//    }
//
//    public void deleteChiTietSanPham(ChiTietSP chiTietSP) {
//        chiTietSPS.remove(chiTietSP);
//    }

    public DongSP(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}
