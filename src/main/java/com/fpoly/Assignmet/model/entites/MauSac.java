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
@Table(name = "MauSac")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MauSac {
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

//    @OneToMany(mappedBy = "idMauSac", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ChiTietSP> chiTietSPS;
//
//    public void addChiTietSanPhap(ChiTietSP chiTietSP) {
//        chiTietSPS.add(chiTietSP);
//    }

}
