package com.cake.cake.repository;

import com.cake.cake.entity.Ingredient;
import com.cake.cake.enums.IngredientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
  List<Ingredient>  findAllByIngredientStatusEquals(IngredientStatus ingredientStatus);
}
