package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.commons.idKhachHangLogin;
import com.fpoly.Assignmet.model.entites.ChiTietSP;
import com.fpoly.Assignmet.model.entites.GioHangChiTiet;
import com.fpoly.Assignmet.model.entites.HoaDon;
import com.fpoly.Assignmet.model.entites.HoaDonChiTiet;
import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.service.ChiTietSanPhamService;
import com.fpoly.Assignmet.service.GioHangChiTietService;
import com.fpoly.Assignmet.service.HoaDonChiTietService;
import com.fpoly.Assignmet.service.HoaDonService;
import com.fpoly.Assignmet.service.KhachHangService;
import com.fpoly.Assignmet.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("hoa-don-chi-tiet")
@RequiredArgsConstructor
public class HoaDonChiTietController {
    private final HoaDonChiTietService hoaDonChiTietService;
    private final HoaDonService hoaDonService;
    private final ChiTietSanPhamService chiTietSanPhamService;

    private final GioHangChiTietService gioHangChiTietService;

    private final KhachHangService khachHangService;
    private final NhanVienService nhanVienService;

    @PostMapping("")
    public String themHoaDonChiTiet(
            Model model,
            @RequestParam("idChiTietSanPham") String idCTSP,
            @RequestParam("giaBan") String giaBan,
            @RequestParam("soLuongMua") String soLuong,
            @RequestParam("tenNguoiNhan") String tenNguoiNhan,
            @RequestParam("sdt") String sdt,
            @RequestParam("diaChi") String diaChi

    ) {
        ChiTietSP chiTietSP = chiTietSanPhamService.findById(UUID.fromString(idCTSP));

        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayTao(new Date(System.currentTimeMillis()));
        hoaDon.setKhachHang(khachHangService.findById(idKhachHangLogin.uuid));
        hoaDon.setNhanVien(nhanVienService.findById(UUID.fromString("529a5a7f-4049-4f1d-9dd4-9971a521a922")));
        String maHoaDon = "HD00" + hoaDonService.getAll().size();
        hoaDon.setMa(maHoaDon);
        hoaDon.setDiaChi(diaChi);
        hoaDon.setSdt(sdt);
        hoaDon.setTenNguoiNhan(tenNguoiNhan);
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
//        hoaDonChiTiets.add(hoaDonChiTiet);
        hoaDon.setChiTietHoaDon(hoaDonChiTiets);
        hoaDonService.save(hoaDon);


        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setHoaDon(hoaDon);
        hoaDonChiTiet.setDonGia(Integer.valueOf(giaBan));
        hoaDonChiTiet.setSoLuong(Integer.valueOf(soLuong));
        hoaDonChiTiet.setChiTietSanPham(chiTietSP);
        hoaDonChiTietService.save(hoaDonChiTiet);

        chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() - Integer.valueOf(soLuong));
        chiTietSanPhamService.save(chiTietSP);
        return "redirect:/hoa-don-chi-tiet";
    }

    @GetMapping("")
    public String show(Model model) {
        KhachHang khachHang = khachHangService.findById(idKhachHangLogin.uuid);
        List<HoaDon> hoaDons = khachHang.getHoaDons();

        // Sắp xếp danh sách hóa đơn theo ngày giờ tạo giảm dần
        hoaDons.sort(Comparator.comparing(HoaDon::getNgayTao).reversed());

        if (!hoaDons.isEmpty()) {
            HoaDon hoaDonMoiNhat = hoaDons.get(0);
            model.addAttribute("hoaDon", hoaDonMoiNhat);
            model.addAttribute("hoaDonChiTiets", hoaDonMoiNhat.getChiTietHoaDon());
        }

        return "/hoa-don-chi-tiet/hien-thi-hoa-don";
    }

    @PostMapping("addList")
    public String addList(@RequestParam("idSanPhamMua") List<UUID> idSanPhamMua,
                          @RequestParam("tenNguoiNhan") String tenNguoiNhan,
                          @RequestParam("sdt") String sdt,
                          @RequestParam("diaChi") String diaChi) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayTao(new Date(System.currentTimeMillis()));
        hoaDon.setKhachHang(khachHangService.findById(idKhachHangLogin.uuid));
        hoaDon.setNhanVien(nhanVienService.findById(UUID.fromString("529a5a7f-4049-4f1d-9dd4-9971a521a922")));
        hoaDon.setMa("HD00" + hoaDonService.getAll().size());
        hoaDon.setDiaChi(diaChi);
        hoaDon.setSdt(sdt);
        hoaDon.setTenNguoiNhan(tenNguoiNhan);
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        hoaDon.setChiTietHoaDon(hoaDonChiTiets);
        hoaDonService.save(hoaDon);

        for (UUID id : idSanPhamMua) {
            GioHangChiTiet gioHangChiTiet = gioHangChiTietService.findById(id);
            ChiTietSP chiTietSP = gioHangChiTiet.getChiTietSP();
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setDonGia(gioHangChiTiet.getDonGia());
            hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
            hoaDonChiTiet.setChiTietSanPham(chiTietSP);
            hoaDonChiTietService.save(hoaDonChiTiet);

            int soLuongMua = gioHangChiTiet.getSoLuong();
            int soLuongTon = chiTietSP.getSoLuongTon();
            chiTietSP.setSoLuongTon(soLuongTon - soLuongMua);
            chiTietSanPhamService.save(chiTietSP);
            gioHangChiTietService.delete(id);
        }

        return "redirect:/hoa-don-chi-tiet";
    }

    @GetMapping("/history")
    public String history(Model model) {
        KhachHang khachHang = khachHangService.findById(idKhachHangLogin.uuid);
        List<HoaDon> hoaDons = khachHang.getHoaDons();

        // Sắp xếp danh sách hóa đơn theo ngày giờ tạo giảm dần
        hoaDons.sort(Comparator.comparing(HoaDon::getNgayTao).reversed());
        if (!hoaDons.isEmpty()) {
            model.addAttribute("hoaDons", hoaDons);

//            model.addAttribute("hoaDonChiTiets", hoaDons.get(0).getChiTietHoaDon());
        }

        return "/hoa-don-chi-tiet/history";
    }


}
