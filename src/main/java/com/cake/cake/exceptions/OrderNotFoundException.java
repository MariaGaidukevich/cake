package com.cake.cake.exceptions;

import java.io.Serial;

public class OrderNotFoundException extends IllegalArgumentException {
    @Serial
    private static final long serialVersionUID = 1L;

    public OrderNotFoundException(Long id) {
        super(String.format("Ингредиент с таким id %d  не найден", id));}}


