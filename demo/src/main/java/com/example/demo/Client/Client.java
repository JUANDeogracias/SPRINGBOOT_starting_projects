package com.example.demo.Client;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;
    private String surname;

    public Client(int id, String name, String email, String password, String surname) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.surname = surname;
    }

    public Client() {
        // Constructor por defecto
    }
}
