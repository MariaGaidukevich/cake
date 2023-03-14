package com.cake.cake.controllers;

import com.cake.cake.entity.Cake;
import com.cake.cake.service.CakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cakes")
public class CakeController {
    private final CakeService cakeService;
    @GetMapping("/{id}")
    public String getCake(@PathVariable("id")Long id, Model model) {
        model.addAttribute("cake", cakeService.getCake(id));
        return "cake";
    }
    @PutMapping("/{id}")
    public String updateCake(@PathVariable("id")Long id,@ModelAttribute("cake") Cake cake) {
        cakeService.updateCake(id, cake);
        return "redirect:/orders";
    }
}
