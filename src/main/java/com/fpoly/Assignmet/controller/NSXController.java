package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.ChucVu;
import com.fpoly.Assignmet.model.entites.NSX;
import com.fpoly.Assignmet.service.ChucVuService;
import com.fpoly.Assignmet.service.NSXService;
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
@RequestMapping("nsx")
@RequiredArgsConstructor
public class NSXController {
    private final NSXService chucVuService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("chucVus", chucVuService.getAll());
        model.addAttribute("chucVu", new NSX());
        return "/nsx/hien-thi";
    }

    @PostMapping("")
    public String add(@Valid @ModelAttribute("chucVu") NSX dongSP,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chucVu", dongSP);
            model.addAttribute("chucVus", chucVuService.getAll());
            return "/nsx/hien-thi";
        }
        try {
            chucVuService.save(dongSP);
        } catch (Exception exception) {
            String error = exception.toString();
            if (error.contains("The duplicate key value is")) {
                bindingResult.rejectValue("ma", "error.key", "Mã " + dongSP.getMa() + " đã tồn tại");
                model.addAttribute("chucVu", dongSP);
                model.addAttribute("chucVus", chucVuService.getAll());
                return "/nsx/hien-thi";
            }
        }
        return "redirect:/nsx";
    }

    @PostMapping("edit")
    public String edit(@Valid @ModelAttribute("chucVu") NSX chucVu,
                       BindingResult bindingResult,
                       Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chucVu", chucVu);
            return "/nsx/update";
        }
        chucVuService.edit(chucVu, chucVu.getId());
        return "redirect:/nsx";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable String id, Model model) {
        NSX chucVu = chucVuService.findById(UUID.fromString(id));
        model.addAttribute("chucVu", chucVu);
        return "/nsx/update";
    }

    @PostMapping("search")
    public String search(@RequestParam("ten") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/nsx";
        }
        List<NSX> chucVus = chucVuService.findByTenLikeIgnoreCase(ten);
        model.addAttribute("searchName", ten);
        model.addAttribute("chucVu", new ChucVu());
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("chucVus", chucVus);
        }
        return "/nsx/hien-thi";
    }


}
