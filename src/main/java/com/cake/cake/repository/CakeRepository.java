package com.cake.cake.repository;

import com.cake.cake.entity.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<Cake,Long> {
}
