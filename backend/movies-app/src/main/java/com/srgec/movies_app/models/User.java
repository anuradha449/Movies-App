package com.srgec.movies_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor

public class User {

    @Id   //this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //it will generate id for storing data
    private int id;  //column 1

    @Column(nullable = false)
    private String name;  //column 2

    @Column(unique = true,nullable = false)
    private String email;  //column 3

    @Column(nullable = false)
    private String password;    //column 4

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }



    
}
