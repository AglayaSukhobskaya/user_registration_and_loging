package com.sukhobskaia.TestTask.dto;

import javax.validation.constraints.*;

public class UserDTO {
    @NotEmpty(message = "Username should not be empty.")
    @Email(message = "Username should be a valid email.")
    private String username;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-zA-Z\\d]).{6,}$",
            message = "Password must contain letters and numbers and at least one capital letter!")
    @NotEmpty(message = "Password should not be empty.")
    @Size(min = 6, message = "Password should contain at least 6 characters.")
    private String plainPassword;

    private String repeatedPassword;

    @Min(value = 18, message = "Age should be over 18 years.")
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
