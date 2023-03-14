package com.cake.cake.repository;

import com.cake.cake.entity.CakeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeOrderRepository extends JpaRepository<CakeOrder,Long> {
}
