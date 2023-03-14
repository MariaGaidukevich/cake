package com.cake.cake.service;

import com.cake.cake.entity.CakeOrder;
import com.cake.cake.entity.Customer;
import com.cake.cake.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public String findCustomer(CakeOrder cakeOrder, Customer customer) {
        if (customerRepository.findByPhoneNumber(customer.getPhoneNumber()) != null) {
            cakeOrder.setCustomer(customerRepository.findByPhoneNumber(customer.getPhoneNumber()));
            return "redirect:/design";
        } else {
            return "redirect:/customer/new";
        }

    }
    @Override
    public String createCustomer(CakeOrder cakeOrder, Customer customer) {
        if (customerRepository.findByPhoneNumber(customer.getPhoneNumber()) == null) {
            cakeOrder.setCustomer(customer);
            customerRepository.save(customer);
        } else {
            cakeOrder.setCustomer(customerRepository.findByPhoneNumber(customer.getPhoneNumber()));
        }
        return "redirect:/design";
    }

}


