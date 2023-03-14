package com.cake.cake.service;
import com.cake.cake.entity.CakeOrder;

import java.util.List;

public interface CakeOrderService {
    void createCakeOrder (CakeOrder cakeOrder);
    void updateCakeOrder(Long id,CakeOrder cakeOrder);
    CakeOrder getCakeOrder(Long id);
    List<CakeOrder> getAllOrders();

}
