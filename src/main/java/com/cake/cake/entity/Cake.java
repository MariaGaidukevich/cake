package com.cake.cake.entity;

import com.cake.cake.enums.CakeStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private float weight;
    @Column
    private Integer price;
    @Column
    private String comment;
    @Column
    @Enumerated(EnumType.STRING)
    private CakeStatus cakeStatus=CakeStatus.NOT_READY;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

}
