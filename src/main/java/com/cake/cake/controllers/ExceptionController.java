package com.cake.cake.controllers;

import com.cake.cake.exceptions.CakeNotFoundException;
import com.cake.cake.exceptions.IngredientNotFoundException;
import com.cake.cake.exceptions.OrderNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

        @ExceptionHandler(CakeNotFoundException.class)
        public String cakeNotFoundException(CakeNotFoundException ex) {
            return "redirect:/orders";
        }
    @ExceptionHandler(OrderNotFoundException.class)
    public String orderNotFoundException(OrderNotFoundException ex) {
        return "redirect:/orders";
    }
    @ExceptionHandler(IngredientNotFoundException.class)
    public String ingredientNotFoundException(IngredientNotFoundException ex) {
        return "redirect:/orders";
    }
    }

