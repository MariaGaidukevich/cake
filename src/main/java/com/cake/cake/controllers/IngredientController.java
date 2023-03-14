package com.cake.cake.controllers;
import com.cake.cake.entity.Ingredient;
import com.cake.cake.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;
    @GetMapping()
   public String getAllIngredients(Model model){
        model.addAttribute("ingredients",ingredientService.getAllIngredients());
  return "allIngredients";
    }
    @GetMapping("/{id}")
    public String getIngredient(@PathVariable("id")Long id,Model model){
        model.addAttribute("ingredient",ingredientService.getIngredient(id));
        return "ingredient";
    }
    @PostMapping
    public String createIngredient(@ModelAttribute("ingredient")Ingredient ingredient) {
        ingredientService.createIngredient(ingredient);
        return "redirect:/ingredients";
    }
    @PutMapping("/{id}")
    public String updateIngredient(@PathVariable("id")Long id,@ModelAttribute("ingredient")Ingredient ingredient){
        ingredientService.updateIngredient(id,ingredient);
        return "redirect:/ingredients";
    }
    @GetMapping("/new")
    public String newIngredientPage(Model model){
    model.addAttribute("ingredient", new Ingredient());
    return "newIngredient";
    }
}
