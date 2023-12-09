package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.ChiTietSP;
import com.fpoly.Assignmet.service.ChiTietSanPhamService;
import com.fpoly.Assignmet.service.DongSanPhamService;
import com.fpoly.Assignmet.service.MauSacService;
import com.fpoly.Assignmet.service.NSXService;
import com.fpoly.Assignmet.service.SanPhamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("chi-tiet-san-pham")
public class ChiTietSanPhamController {
    private final ChiTietSanPhamService chiTietSanPhamService;
    private final SanPhamService sanPhamService;
    private final MauSacService mauSacService;
    private final NSXService nsxService;
    private final DongSanPhamService dongSanPhamService;

    @GetMapping("")
    public String show(Model model, @RequestParam(value = "paing", defaultValue = "1") String page) {
        int count = chiTietSanPhamService.findAllByObject().size();
        int size = 3;
        int pageIndex = count / size;
        if (count % size != 0) {
            pageIndex++;
        }
        model.addAttribute("chiTietSanPhams", chiTietSanPhamService.findPaing(Integer.valueOf(page), size));
        model.addAttribute("endPage", pageIndex);
        return "/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("chiTietSanPham", new ChiTietSP());
        hienThiChung(model);
        return "/chi-tiet-san-pham/create";
    }

    @PostMapping("")
    public String add(
            Model model,
            @Valid @ModelAttribute("chiTietSanPham") ChiTietSP nhanVien,
            BindingResult bindingResult
    ) {
        hienThiChung(model);
        if (bindingResult.hasErrors()) {
            model.addAttribute("chiTietSanPham", nhanVien);
            return "/chi-tiet-san-pham/create";
        }
        chiTietSanPhamService.save(nhanVien);
        return "redirect:/chi-tiet-san-pham";
    }

    private void hienThiChung(Model model) {
        model.addAttribute("sanPhams", sanPhamService.getAll());
        model.addAttribute("mauSacs", mauSacService.getAll());
        model.addAttribute("dongSps", dongSanPhamService.getAll());
        model.addAttribute("nsxs", nsxService.getAll());
    }

    @GetMapping("edit/{id}")
    public String viewEdit(Model model, @PathVariable String id) {
        ChiTietSP chiTietSP = chiTietSanPhamService.findById(UUID.fromString(id));
        model.addAttribute("chiTietSanPham", chiTietSP);
        hienThiChung(model);
        return "/chi-tiet-san-pham/update";
    }

    @GetMapping("delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        chiTietSanPhamService.delete(UUID.fromString(id));
        return "redirect:/chi-tiet-san-pham";
    }

    @PostMapping("update")
    public String update(
            Model model,
            @Valid @ModelAttribute("chiTietSanPham") ChiTietSP nhanVien,
            BindingResult bindingResult
    ) {
        hienThiChung(model);
        if (bindingResult.hasErrors()) {
            model.addAttribute("chiTietSanPham", nhanVien);
            return "/chi-tiet-san-pham/update";
        }
        chiTietSanPhamService.update(nhanVien);
        return "redirect:/chi-tiet-san-pham";
    }

    @PostMapping("search")
    public String search(@RequestParam("ten") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/chi-tiet-san-pham";
        }
        List<ChiTietSP> chucVus = chiTietSanPhamService.findByName(ten);
        model.addAttribute("searchName", ten);
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("chiTietSanPhams", chucVus);
        }
        return "/chi-tiet-san-pham/hien-thi";
    }
}
