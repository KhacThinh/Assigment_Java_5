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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NSX")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @NotEmpty(message = "Không được để trống mã")
    @Column(name = "Ma", unique = true, nullable = false)
    private String ma;

    @NotEmpty(message = "Không được để trống tên")
    @Column(name = "Ten")
    private String ten;
//    @OneToMany(mappedBy = "idNsx", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ChiTietSP> chiTietSanPhams;

//    public void addChiTietSanPham(ChiTietSP chiTietSP) {
//        chiTietSanPhams.add(chiTietSP);
//    }

    public NSX(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}
