package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.commons.idKhachHangLogin;
import com.fpoly.Assignmet.model.entites.ChiTietSP;
import com.fpoly.Assignmet.model.entites.GioHang;
import com.fpoly.Assignmet.model.entites.GioHangChiTiet;
import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.service.ChiTietSanPhamService;
import com.fpoly.Assignmet.service.GioHangChiTietService;
import com.fpoly.Assignmet.service.GioHangService;
import com.fpoly.Assignmet.service.KhachHangService;
import com.fpoly.Assignmet.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("gio-hang-chi-tiet")
@RequiredArgsConstructor
public class GioHangChiTietController {
    private final GioHangChiTietService gioHangChiTietService;
    private final ChiTietSanPhamService chiTietSanPhamService;

    private final NhanVienService nhanVienService;
    private final KhachHangService khachHangService;
    private final GioHangService gioHangService;

    @PostMapping("")
    public String show(
            Model model,
            @RequestParam("idCTSP") String idCTSP,
            @RequestParam("giaGiam") String giamGia
    ) {
        UUID idSp = UUID.fromString(idCTSP);
        int price = Integer.valueOf(giamGia);
        ChiTietSP chiTietSP = chiTietSanPhamService.findById(idSp);
        model.addAttribute("chiTietSP", chiTietSP);
        model.addAttribute("price", price);
        return "/gio-hang/hien-thi";
    }

    @PostMapping("add")
    public String add(Model model,
                      @RequestParam("idChiTietSanPham") String idCTSP,
                      @RequestParam("giaBan") String giaBan,
                      @RequestParam("soLuongMua") String soLuong) {
        KhachHang khachHang = khachHangService.findById(idKhachHangLogin.uuid);
        List<GioHang> gioHangs = gioHangService.getAll();
        GioHang gioHang = gioHangService.findByKhachHang(khachHang);

        if (Objects.isNull(gioHang)) {
            gioHang = new GioHang();
            gioHang.setKhachHang(khachHang);
            gioHang.setNgayTao(new Date(System.currentTimeMillis()));
            gioHang.setMa("GH000" + gioHangs.size());
            gioHangService.save(gioHang);
        }

        ChiTietSP chiTietSP = chiTietSanPhamService.findById(UUID.fromString(idCTSP));
        List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietService.getAll();
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        boolean check = false;
        for (GioHangChiTiet ghct : gioHangChiTiets) {
            if (ghct.getChiTietSP().equals(chiTietSP)) {
                gioHangChiTiet = ghct;
                check = true;
            }
        }
        if (check) {
            int coutProduct = gioHangChiTiet.getSoLuong();
            gioHangChiTiet.setSoLuong(coutProduct + Integer.valueOf(soLuong));
        } else {
            gioHangChiTiet.setChiTietSP(chiTietSP);
            gioHangChiTiet.setGioHang(gioHang);
            gioHangChiTiet.setDonGia(Integer.valueOf(giaBan));
            gioHangChiTiet.setSoLuong(Integer.valueOf(soLuong));
        }

        gioHangChiTietService.save(gioHangChiTiet);
        return "redirect:/home";
    }

    @GetMapping("")
    public String showGioHangChiTiet(Model model) {
        KhachHang khachHang = khachHangService.findById(idKhachHangLogin.uuid);
        List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietService
                .getAll()
                .stream()
                .filter(gioHangChiTiet1 -> gioHangChiTiet1.getGioHang().getKhachHang().equals(khachHang))
                .collect(Collectors.toList());
        model.addAttribute("listGHCT", gioHangChiTiets);
        return "/gio-hang/gio-hang-chi-tiet";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        gioHangChiTietService.delete(UUID.fromString(id));
        return "redirect:/gio-hang-chi-tiet";
    }
}
