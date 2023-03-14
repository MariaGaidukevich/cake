package com.cake.cake.controllers;

import com.cake.cake.entity.CakeOrder;
import com.cake.cake.entity.Customer;
import com.cake.cake.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
@SessionAttributes("cakeOrder")
public class CustomerController {
    private final CustomerService customerService;

    @ModelAttribute(name = "cakeOrder")
    public CakeOrder addOrderToModel() {
        return new CakeOrder();
    }

    @ModelAttribute(name = "customer")
    public Customer addCustomerToModel() {
        return new Customer();
    }

    @GetMapping
    public String showCustomerFindForm() {
        return "customerForm";
    }

    @GetMapping("/new")
    public String showNewCustomerForm() {
        return "newCustomerForm";
    }

    @PostMapping
    public String findCustomer(@ModelAttribute CakeOrder cakeOrder, @ModelAttribute Customer customer) {
        return customerService.findCustomer(cakeOrder, customer);
    }

    @PostMapping("/new")
    public String createCustomer(@ModelAttribute CakeOrder cakeOrder, @ModelAttribute Customer customer) {
        return customerService.createCustomer(cakeOrder, customer);
    }

//    @PostMapping("/old")
//    public String getByPhone(@ModelAttribute Customer customer, @ModelAttribute CakeOrder cakeOrder) {
//        customerService.findByPhoneNumber(customer, cakeOrder);
//        return "redirect:/design";
//    }
}
