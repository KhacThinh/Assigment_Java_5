package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.MauSac;
import com.fpoly.Assignmet.service.MauSacService;
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
@RequestMapping("mau-sac")
@RequiredArgsConstructor
public class MauSacController {

    private final MauSacService dongSanPhamService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("dongSp", new MauSac());
        model.addAttribute("dongSanPhams", dongSanPhamService.getAll());
        return "/mau-sac/hien-thi";
    }

    @PostMapping("")
    public String add(@Valid @ModelAttribute("dongSp") MauSac dongSP,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dongSp", dongSP);
            model.addAttribute("dongSanPhams", dongSanPhamService.getAll());
            return "/mau-sac/hien-thi";
        }
        try {
            dongSanPhamService.save(dongSP);
        } catch (Exception exception) {
            String error = exception.toString();
            if (error.contains("The duplicate key value is")) {
                bindingResult.rejectValue("ma", "error.key", "Mã " + dongSP.getMa() + " đã tồn tại");
                model.addAttribute("dongSp", dongSP);
                model.addAttribute("dongSanPhams", dongSanPhamService.getAll());
                return "/mau-sac/hien-thi";
            }
        }
        return "redirect:/mau-sac";
    }

    @PostMapping("edit")
    public String edit(@Valid @ModelAttribute("dongSp") MauSac dongSP,
                       BindingResult bindingResult,
                       Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dongSp", dongSP);
            return "/mau-sac/update";
        }
        dongSanPhamService.edit(dongSP, dongSP.getId());
        return "redirect:/mau-sac";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable String id, Model model) {
        MauSac dongSP = dongSanPhamService.findById(UUID.fromString(id));
        model.addAttribute("dongSp", dongSP);
        return "/mau-sac/update";
    }

    @PostMapping("search")
    public String search(@RequestParam("ten") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/mau-sac";
        }
        List<MauSac> chucVus = dongSanPhamService.findByTenLikeIgnoreCase(ten);
        model.addAttribute("searchName", ten);
        model.addAttribute("dongSp", new MauSac());
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("dongSanPhams", chucVus);
        }
        return "/mau-sac/hien-thi";
    }
}
