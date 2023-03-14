package com.cake.cake.controllers;

import com.cake.cake.entity.Cake;
import com.cake.cake.entity.CakeOrder;
import com.cake.cake.enums.IngredientStatus;
import com.cake.cake.enums.IngredientType;
import com.cake.cake.service.CakeService;
import com.cake.cake.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/design")
@SessionAttributes("cakeOrder")
public class DesignController {
    private final IngredientService ingredientService;
    private final CakeService cakeService;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        for (IngredientType type : IngredientType.values()) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredientService.filterByType(ingredientService.findIngredientsByStatus(IngredientStatus.AVAILABLE), type));
        }
    }

    @ModelAttribute(name="cakeOrder")
    public CakeOrder addOrderToModel(){
        return new CakeOrder();
    }

    @ModelAttribute(name="cake")
    public Cake addCakeToModel(){
        return new Cake();
    }

    @GetMapping
    public String showDesignForm()
    {return "designForm";}

    @PostMapping
    public String createCake (Cake cake, @ModelAttribute CakeOrder cakeOrder){
        cakeService.createCake(cake, cakeOrder);
        return "redirect:/orders/current";
    }


}
