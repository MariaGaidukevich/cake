package com.cake.cake.exceptions;

import java.io.Serial;

public class IngredientNotFoundException extends IllegalArgumentException {
    @Serial
    private static final long serialVersionUID = 1L;

    public IngredientNotFoundException(Long id) {
        super(String.format("Ингредиент с таким id %d  не найден", id));}}

