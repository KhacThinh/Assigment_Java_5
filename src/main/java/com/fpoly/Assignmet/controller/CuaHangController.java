package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.CuaHang;
import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.service.CuaHangService;
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
@RequestMapping("cua-hang")
@RequiredArgsConstructor
public class CuaHangController {
    private final CuaHangService cuaHangService;

    @GetMapping("")
    public String show(Model model, @RequestParam(value = "paing", defaultValue = "1") String page) {
        int count = cuaHangService.getAll().size();
        int size = 3;
        int pageIndex = count / size;
        if (count % size != 0) {
            pageIndex++;
        }
        model.addAttribute("list", cuaHangService.findPaing(Integer.valueOf(page), size));
        model.addAttribute("endPage", pageIndex);
        return "cua-hang/hien-thi";
    }

    @GetMapping("create")
    public String viewCreate(Model model) {
        model.addAttribute("cuaHang", new CuaHang());
        return "cua-hang/create";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("cuaHang") CuaHang cuaHang,
                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cuaHang", cuaHang);
            return "/cua-hang/create";
        }
        try {
            cuaHangService.save(cuaHang);
        } catch (Exception exception) {
            String error = exception.toString();
            if (error.contains("The duplicate key value is")) {
                bindingResult.rejectValue("ma", "error.key", "Mã " + cuaHang.getMa() + " đã tồn tại");
                model.addAttribute("cuaHang", cuaHang);
                return "/cua-hang/create";
            }
        }
        return "redirect:/cua-hang";
    }

    @GetMapping("edit/{id}")
    public String viewUpdate(@PathVariable String id, Model model) {
        CuaHang hang = cuaHangService.findById(UUID.fromString(id));
        model.addAttribute("cuaHang", hang);
        return "/cua-hang/update";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("cuaHang") CuaHang cuaHang,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cuaHang", cuaHang);
            return "/cua-hang/create";
        }
        cuaHangService.edit(cuaHang, cuaHang.getId());
        return "redirect:/cua-hang";
    }

    @PostMapping("search")
    public String search(@RequestParam("ten") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/cua-hang";
        }
        List<CuaHang> chucVus = cuaHangService.findByTenMaLike(ten);
        model.addAttribute("searchName", ten);
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("list", chucVus);
        }
        return "/cua-hang/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        CuaHang khachHang = cuaHangService.findById(UUID.fromString(id));
        cuaHangService.delete(khachHang);
        return "redirect:/cua-hang";
    }
}
