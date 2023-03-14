package com.cake.cake.repository;

import com.cake.cake.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByPhoneNumber(String phoneNumber);
}
