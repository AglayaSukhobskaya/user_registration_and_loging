package com.sukhobskaia.TestTask.controller;

import com.sukhobskaia.TestTask.dto.UserDTO;
import com.sukhobskaia.TestTask.model.User;
import com.sukhobskaia.TestTask.service.RegistrationService;
import com.sukhobskaia.TestTask.util.UserValidator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    RegistrationService registrationService;
    UserValidator userValidator;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") UserDTO userDTO) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid UserDTO userDTO,
                                      BindingResult bindingResult) {
        if (!Objects.equals(userDTO.plainPassword(), userDTO.repeatedPassword())) {
            bindingResult.rejectValue("repeatedPassword", "", "Passwords mismatch!");
        }

        User user = convertToUser(userDTO);
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/auth/registration";
        }

        registrationService.register(user);

        return "redirect:/auth/login";
    }

    private User convertToUser(UserDTO userDTO) {
        User user = new User();

        user.setUsername(userDTO.username());
        user.setPassword(userDTO.plainPassword());
        user.setAge(userDTO.age());

        return user;
    }
}
