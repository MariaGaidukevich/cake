package com.cake.cake.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    boolean isActive = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="role_user")
    private Collection<Role> roles;
}
