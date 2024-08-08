package com.sukhobskaia.TestTask.dto;

import com.sukhobskaia.TestTask.util.Constant;

import javax.validation.constraints.*;

public record UserDTO(@NotEmpty(message = "Username should not be empty")
                      @Email(message = "Username should be a valid email")
                      String username,

                      @Pattern(regexp = Constant.PASSWORD_PATTERN,
                              message = "The password must contain numbers and lowercase and uppercase letters")
                      @NotEmpty(message = "Password should not be empty")
                      @Size(min = 6, message = "Password should contain at least 6 characters")
                      String plainPassword,

                      String repeatedPassword,

                      @Min(value = 18, message = "Age should be over 18 years")
                      int age) {
}
