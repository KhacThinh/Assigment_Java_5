package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.model.entites.MauSac;
import com.fpoly.Assignmet.service.KhachHangService;
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
@RequestMapping("khach-hang")
@RequiredArgsConstructor
public class KhachHangController {
    private final KhachHangService khachHangService;

    @GetMapping("")
    public String show(Model model, @RequestParam(value = "paing", defaultValue = "1") String page) {
        int count = khachHangService.getAll().size();
        int size = 3;
        int pageIndex = count / size;
        if (count % size != 0) {
            pageIndex++;
        }
        model.addAttribute("khachHangs", khachHangService.findPaing(Integer.valueOf(page), size));
        model.addAttribute("endPage", pageIndex);
        return "/khach-hang/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "/khach-hang/create";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("khachHang", khachHang);
            return "/khach-hang/create";
        }
        try {
            khachHangService.save(khachHang);
        } catch (Exception exception) {
            String error = exception.toString();
            if (error.contains("The duplicate key value is")) {
                model.addAttribute("khachHang", khachHang);
                bindingResult.rejectValue("ma", "error.key", "không được trùng mã!");
                return "/khach-hang/create";
            }
        }
        return "redirect:/khach-hang";
    }

    @GetMapping("edit/{id}")
    public String viewEdit(@PathVariable String id, Model model) {
        KhachHang khachHang = khachHangService.findById(UUID.fromString(id));
        model.addAttribute("khachHang", khachHang);
        return "/khach-hang/edit";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("khachHang", khachHang);
            return "/khach-hang/edit";
        }
        khachHangService.edit(khachHang, khachHang.getId());
        return "redirect:/khach-hang";
    }

    @PostMapping("search")
    public String search(@RequestParam("ten") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/khach-hang";
        }
        List<KhachHang> chucVus = khachHangService.findByMaLikeIgnoreCaseAndTenLikeIgnoreCase(ten);
        model.addAttribute("searchName", ten);
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("khachHangs", chucVus);
        }
        return "/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        KhachHang khachHang = khachHangService.findById(UUID.fromString(id));
        khachHangService.delete(khachHang);
        return "redirect:/khach-hang";
    }
}
