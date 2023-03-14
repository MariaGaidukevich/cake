package com.cake.cake.service;
import com.cake.cake.entity.CakeOrder;
import com.cake.cake.entity.Customer;

public interface CustomerService {
        String findCustomer (CakeOrder cakeOrder, Customer customer);
        String createCustomer(CakeOrder cakeOrder, Customer customer);
//void findByPhoneNumber(Customer customer, CakeOrder cakeOrder);
}
