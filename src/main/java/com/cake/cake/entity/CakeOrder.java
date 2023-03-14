package com.cake.cake.entity;

import com.cake.cake.enums.OrderStatus;
import com.cake.cake.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class CakeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Cake> cakes=new ArrayList<>();

    @Column
    private String deliveryAddress;

    @Column
    private Integer cost;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime deliveryDate;
    @Column
    @Enumerated(EnumType.STRING)
   private OrderStatus orderStatus=OrderStatus.NEW;
    @Column
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;
    public void addCake(Cake cake){
        this.cakes.add(cake);
    }
}
