package com.cake.cake.service;
import com.cake.cake.entity.Cake;
import com.cake.cake.entity.CakeOrder;
import com.cake.cake.entity.Ingredient;
import com.cake.cake.exceptions.OrderNotFoundException;
import com.cake.cake.repository.CakeOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CakeOrderServiceImpl implements CakeOrderService{
    private final CakeOrderRepository cakeOrderRepository;
    @Override
    public void createCakeOrder(CakeOrder cakeOrder) {
        Integer total=0;
        for(Cake cake:cakeOrder.getCakes()){
            total+=cake.getPrice();
        }
        cakeOrder.setCost(total);
        cakeOrderRepository.save(cakeOrder);
        }

    @Override
    public void updateCakeOrder(Long id, CakeOrder cakeOrder) {
        CakeOrder updatedCakeOrder= cakeOrderRepository.findById(id).get();
        updatedCakeOrder.setOrderStatus(cakeOrder.getOrderStatus());
        cakeOrderRepository.save(updatedCakeOrder);
    }

    @Override
    public CakeOrder getCakeOrder(Long id) {
        return cakeOrderRepository.findById(id).orElseThrow(()->new OrderNotFoundException(id));
    }

    @Override
    public List<CakeOrder> getAllOrders() {
        return cakeOrderRepository.findAll();
    }
}
