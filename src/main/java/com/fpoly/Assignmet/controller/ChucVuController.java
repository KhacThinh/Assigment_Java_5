package com.fpoly.Assignmet.controller;

import com.fpoly.Assignmet.model.entites.ChucVu;
import com.fpoly.Assignmet.service.ChucVuService;
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
@RequestMapping("chuc-vu")
@RequiredArgsConstructor
public class ChucVuController {
    private final ChucVuService chucVuService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("chucVus", chucVuService.getAll());
        model.addAttribute("chucVu", new ChucVu());
        return "/chuc-vu/hien-thi";
    }

    @PostMapping("")
    public String add(@Valid @ModelAttribute("chucVu") ChucVu chucVu,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chucVu", chucVu);
            model.addAttribute("chucVus", chucVuService.getAll());
            return "/chuc-vu/hien-thi";
        }
        try {
            chucVuService.save(chucVu);
        } catch (Exception exception) {
            String error = exception.toString();
            if (error.contains("The duplicate key value is")) {
                bindingResult.rejectValue("ma", "error.key", "Mã " + chucVu.getMa() + " đã tồn tại");
                model.addAttribute("chucVu", chucVu);
                model.addAttribute("chucVus", chucVuService.getAll());
                return "/chuc-vu/hien-thi";
            }
        }
        return "redirect:/chuc-vu";
    }

    @PostMapping("edit")
    public String edit(@Valid @ModelAttribute("chucVu") ChucVu chucVu,
                       BindingResult bindingResult,
                       Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chucVu", chucVu);
            model.addAttribute("chucVus", chucVuService.getAll());
            return "/chuc-vu/hien-thi.jsp";
        }
        chucVuService.edit(chucVu, chucVu.getId());
        return "redirect:/chuc-vu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable String id, Model model) {
        ChucVu chucVu = chucVuService.findById(UUID.fromString(id));
        model.addAttribute("chucVu", chucVu);
        return "/chuc-vu/update";
    }

    @PostMapping("search")
    public String search(@RequestParam("ten") String ten,
                         Model model
    ) {
        if (ten.trim().equals("")) {
            return "redirect:/chuc-vu";
        }
        List<ChucVu> chucVus = chucVuService.findByTenLikeIgnoreCase(ten);
        model.addAttribute("searchName", ten);
        model.addAttribute("chucVu", new ChucVu());
        if (chucVus.isEmpty()) {
            model.addAttribute("thongBao", "Không tìm thấy!");
        } else {
            model.addAttribute("chucVus", chucVus);
        }
        return "/chuc-vu/hien-thi";
    }


}
