package com.cake.cake.exceptions;

import java.io.Serial;

public class CakeNotFoundException extends IllegalArgumentException {
@Serial
    private static final long serialVersionUID = 1L;

    public CakeNotFoundException(Long id) {
        super(String.format("Торт с таким id %d  не найден", id));}}


