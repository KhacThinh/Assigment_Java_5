package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.ChiTietSP;
import com.fpoly.Assignmet.service.ChiTietSanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("thanh-toan")
@RequiredArgsConstructor
public class HoaDonController {
    private final ChiTietSanPhamService chiTietSanPhamService;

    @PostMapping("")
    public String show(
            @RequestParam("idCTSP") String idCTSP,
            @RequestParam("gia") String gia,
            Model model) {
        UUID idSp = UUID.fromString(idCTSP);
        int price = Integer.valueOf(gia);
        ChiTietSP chiTietSP = chiTietSanPhamService.findById(idSp);
        model.addAttribute("chiTietSP", chiTietSP);
        model.addAttribute("price", price);
        return "/hoa-don/hien-thi";
    }
}
