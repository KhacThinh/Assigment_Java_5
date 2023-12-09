package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.KhachHang;
import com.fpoly.Assignmet.model.entites.NhanVien;
import com.fpoly.Assignmet.service.ChucVuService;
import com.fpoly.Assignmet.service.CuaHangService;
import com.fpoly.Assignmet.service.NhanVienService;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    private final NhanVienService nhanVienService;
    private final CuaHangService cuaHangService;
    private final ChucVuService chucVuService;

    @GetMapping("")
    public String show(Model model, @RequestParam(value = "paing", defaultValue = "1") String page) {
        int count = nhanVienService.getAll().size();
        int size = 3;
        int pageIndex = count / size;
        if (count % size != 0) {
            pageIndex++;
        }
        model.addAttribute("nhanViens", nhanVienService.findPaing(Integer.valueOf(page), size));
        model.addAttribute("endPage", pageIndex);
        return "/nhan-vien/index";
    }

    @GetMapping("create")
    public String viewCreate(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        hienThi3Day(model);
        return "/nhan-vien/create";
    }

    @PostMapping("")
    public String add(
            Model model,
            @Valid @ModelAttribute("nhanVien") NhanVien nhanVien,
            BindingResult bindingResult
    ) {
        hienThi3Day(model);
        if (bindingResult.hasErrors()) {
            model.addAttribute("nhanVien", nhanVien);
            return "/nhan-vien/create";
        }
        try {
            nhanVienService.save(nhanVien);
        } catch (Exception exception) {
            String error = exception.toString();
            if (error.contains("The duplicate key value is")) {
                bindingResult.rejectValue("ma", "error.key", "Mã " + nhanVien.getMa() + " đã tồn tại");
                model.addAttribute("nhanVien", nhanVien);
                return "/nhan-vien/create";
            }
        }
        return "redirect:/nhan-vien";
    }

    private void hienThi3Day(Model model) {
        model.addAttribute("guiBCs", nhanVienService.getAll());
        model.addAttribute("cuaHangs", cuaHangService.getAll());
        model.addAttribute("chucVus", chucVuService.getAll());
    }

    @GetMapping("edit/{id}")
    public String viewEdit(@PathVariable String id, Model model) {
        hienThi3Day(model);
        NhanVien nhanVien = nhanVienService.findById(UUID.fromString(id));
        model.addAttribute("nhanVien", nhanVien);
        return "/nhan-vien/update";
    }

    @PostMapping("update")
    public String update(
            Model model,
            @Valid @ModelAttribute("nhanVien") NhanVien nhanVien,
            BindingResult bindingResult
    ) {
        hienThi3Day(model);
        if (bindingResult.hasErrors()) {
            model.addAttribute("nhanVien", nhanVien);
            return "/nhan-vien/update";
        }
        nhanVienService.edit(nhanVien, nhanVien.getId());
        return "redirect:/nhan-vien";
    }

    @PostMapping("search")
    public String search(@RequestParam("ten") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/nhan-vien";
        }
        List<NhanVien> chucVus = nhanVienService.findByTenMaLike(ten);
        model.addAttribute("searchName", ten);
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("nhanViens", chucVus);
        }
        return "/nhan-vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        nhanVienService.delete(UUID.fromString(id));
        return "redirect:/nhan-vien";
    }
}
