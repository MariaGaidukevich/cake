package com.cake.cake.service;

import com.cake.cake.entity.Cake;
import com.cake.cake.entity.CakeOrder;
import com.cake.cake.entity.Ingredient;
import com.cake.cake.exceptions.CakeNotFoundException;
import com.cake.cake.repository.CakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CakeServiceImpl implements CakeService{
    private final CakeRepository cakeRepository;
    @Override
    public void createCake(Cake cake, CakeOrder cakeOrder) {
        Integer collect=0;
        for(Ingredient ingredient: cake.getIngredients()){
            collect+=ingredient.getPrice();
        }
        float total= collect*cake.getWeight();
        cake.setPrice((int)total);
        cakeOrder.addCake(cake);
        cakeRepository.save(cake);
    }

    @Override
    public void updateCake(Long id, Cake cake) {
        Cake updatedCake= cakeRepository.findById(id).get();
        updatedCake.setCakeStatus(cake.getCakeStatus());
        cakeRepository.save(updatedCake);

    }

    @Override
    public Cake getCake(Long id) {
        return cakeRepository.findById(id).orElseThrow(()->new CakeNotFoundException(id));}
}
