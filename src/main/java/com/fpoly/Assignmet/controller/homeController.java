package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.ChiTietSP;
import com.fpoly.Assignmet.service.ChiTietSanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("home")
@RequiredArgsConstructor
public class homeController {

    private final ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("")
    public String home(Model model, @RequestParam(value = "paing", defaultValue = "1") String paging) {
        int count = chiTietSanPhamService.findAllByObject().size();
        int size = 6;
        int endPage = count / size;
        if (count % size != 0) {
            endPage++;
        }
        model.addAttribute("endPage", endPage);
        model.addAttribute("list", chiTietSanPhamService.findPaing(Integer.valueOf(paging), size));
        return "index";
    }

    @PostMapping("search")
    public String search(@RequestParam("tenSanPham") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/home";
        }
        List<ChiTietSP> chucVus = chiTietSanPhamService.findByName(ten);
        model.addAttribute("searchName", ten);
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("list", chucVus);
        }
        return "/index";
    }
}
