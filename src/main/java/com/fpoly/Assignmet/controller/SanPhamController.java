package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.DongSP;
import com.fpoly.Assignmet.model.entites.SanPham;
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
@RequestMapping("san-pham")
@RequiredArgsConstructor
public class SanPhamController {

    private final SanPhamService dongSanPhamService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("dongSp", new SanPham());
        model.addAttribute("dongSanPhams", dongSanPhamService.getAll());
        return "/san-pham/hien-thi";
    }

    @PostMapping("")
    public String add(@Valid @ModelAttribute("dongSp") SanPham dongSP,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dongSp", dongSP);
            model.addAttribute("dongSanPhams", dongSanPhamService.getAll());
            return "/san-pham/hien-thi";
        }
        try {
            dongSanPhamService.save(dongSP);
        } catch (Exception exception) {
            String error = exception.toString();
            if (error.contains("The duplicate key value is")) {
                bindingResult.rejectValue("ma", "error.key", "Mã " + dongSP.getMa() + " đã tồn tại");
                model.addAttribute("dongSp", dongSP);
                model.addAttribute("dongSanPhams", dongSanPhamService.getAll());
                return "/san-pham/hien-thi";
            }
        }
        return "redirect:/san-pham";
    }

    @PostMapping("edit")
    public String edit(@Valid @ModelAttribute("dongSp") SanPham dongSP,
                       BindingResult bindingResult,
                       Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dongSp", dongSP);
            return "/san-pham/hien-thi";
        }
        dongSanPhamService.edit(dongSP, dongSP.getId());
        return "redirect:/san-pham";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable String id, Model model) {
        SanPham dongSP = dongSanPhamService.findById(UUID.fromString(id));
        model.addAttribute("dongSp", dongSP);
        return "/san-pham/update";
    }

    @PostMapping("search")
    public String search(@RequestParam("ten") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/san-pham";
        }
        List<SanPham> chucVus = dongSanPhamService.findByTenLikeIgnoreCase(ten);
        model.addAttribute("searchName", ten);
        model.addAttribute("dongSp", new SanPham());
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("dongSanPhams", chucVus);
        }
        return "/san-pham/hien-thi";
    }
}
