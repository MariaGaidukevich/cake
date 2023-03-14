package com.cake.cake.service;
import com.cake.cake.entity.Ingredient;
import com.cake.cake.enums.IngredientStatus;
import com.cake.cake.enums.IngredientType;

import java.util.List;

public interface IngredientService {
    void createIngredient(Ingredient ingredient);
    void updateIngredient(Long id,Ingredient ingredient);
    Ingredient getIngredient(Long id);
    List<Ingredient>getAllIngredients();
    List <Ingredient> findIngredientsByStatus(IngredientStatus ingredientStatus);

    Iterable filterByType(List<Ingredient> ingredientsByStatus, IngredientType type);
}