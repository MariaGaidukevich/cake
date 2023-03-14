package com.cake.cake.controllers;

import com.cake.cake.entity.CakeOrder;
import com.cake.cake.service.CakeOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
@SessionAttributes("cakeOrder")
public class CakeOrderController {
    private final CakeOrderService cakeOrderService;

    @ModelAttribute(name="cakeOrder")
    public CakeOrder addOrderToModel(){
        return new CakeOrder();
    }

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("cakeOrders", cakeOrderService.getAllOrders());
        return "allOrders";
    }

    @GetMapping("/{id}")
    public String getCakeOrder(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cakeOrder", cakeOrderService.getCakeOrder(id));
        return "order";
    }

    @PutMapping("/{id}")
    public String updateCakeOrder(@PathVariable("id") Long id, @ModelAttribute("cakeOrder") CakeOrder cakeOrder) {
        cakeOrderService.updateCakeOrder(id, cakeOrder);
        return "redirect:/orders";

    }
    @GetMapping("/current")
    public String showForm(){
        return "orderForm";
    }

    @PostMapping
    public String createCakeOrder(CakeOrder cakeOrder) {
        cakeOrderService.createCakeOrder(cakeOrder);

        return "redirect:/orders/end";
    }
    @GetMapping("/end")
    public String showNumberOfOrder(){
        return "orderEnd";
    }

    @PostMapping("/end")
    public String endSession(SessionStatus sessionStatus){
    sessionStatus.setComplete();
    return "redirect:/customer";
    }
}
