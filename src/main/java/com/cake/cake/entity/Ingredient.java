package com.cake.cake.entity;

import com.cake.cake.enums.IngredientStatus;
import com.cake.cake.enums.IngredientType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private Integer price;
    @Enumerated(EnumType.STRING)
    private IngredientStatus ingredientStatus;

    @Enumerated(EnumType.STRING)
    private IngredientType ingredientType;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Cake> cakes=new ArrayList<>();
}
