package com.cake.cake.service;
import com.cake.cake.entity.Ingredient;
import com.cake.cake.enums.IngredientStatus;
import com.cake.cake.enums.IngredientType;
import com.cake.cake.exceptions.IngredientNotFoundException;
import com.cake.cake.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService{
    private final IngredientRepository ingredientRepository;
    @Override
    public void createIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }

    @Override
    public void updateIngredient(Long id,Ingredient ingredient) {
       Ingredient updatedIngredient= ingredientRepository.findById(id).get();
       updatedIngredient.setPrice(ingredient.getPrice());
       updatedIngredient.setIngredientStatus(ingredient.getIngredientStatus());
       ingredientRepository.save(updatedIngredient);
    }

    @Override
    public Ingredient getIngredient(Long id) {
   return ingredientRepository.findById(id).orElseThrow(()->new IngredientNotFoundException(id));
    }

    @Override
    public List<Ingredient> getAllIngredients() {
      return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> findIngredientsByStatus(IngredientStatus ingredientStatus) {
       return ingredientRepository.findAllByIngredientStatusEquals(IngredientStatus.AVAILABLE);

    }
    public Iterable<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType ingredientType)
    {
        return ingredients.stream().filter(i -> i.getIngredientType().equals(ingredientType)).collect(Collectors.toList());
    }
}

