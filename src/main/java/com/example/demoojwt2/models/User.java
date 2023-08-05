package com.example.demoojwt2.models;

import jakarta.persistence.*;

@Entity
@Table

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;




}
