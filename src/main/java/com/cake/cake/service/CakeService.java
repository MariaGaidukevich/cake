package com.cake.cake.service;

import com.cake.cake.entity.Cake;
import com.cake.cake.entity.CakeOrder;

public interface CakeService {
    void createCake (Cake cake, CakeOrder cakeOrder);
    void updateCake(Long id,Cake cake);
    Cake getCake(Long id);
}
