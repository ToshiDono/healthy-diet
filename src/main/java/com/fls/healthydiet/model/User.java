package com.fls.healthydiet.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(columnDefinition = "text")
    private String login;

    @NotNull
    @Column(columnDefinition = "text")
    private String password;

}
