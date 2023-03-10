package com.sukhobskaia.TestTask.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "Username should not be empty.")
    @Email(message = "Username should be a valid email.")
    private String username;

    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-zA-Z\\d]).{6,}$",
            message = "Password must contain letters and numbers and at least one capital letter!")
    @NotEmpty(message = "Password should not be empty.")
    @Size(min = 6, message = "Password should contain at least 6 characters.")
    private String password;

    @Column(name = "age")
    @Min(value = 18, message = "Age should be over 18 years.")
    private int age;

    public User() {}

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
