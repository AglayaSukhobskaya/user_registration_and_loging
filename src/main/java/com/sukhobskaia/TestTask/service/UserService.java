package com.sukhobskaia.TestTask.service;

import com.sukhobskaia.TestTask.model.User;
import com.sukhobskaia.TestTask.repository.UserRepository;
import com.sukhobskaia.TestTask.security.UserDetailsImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements UserDetailsService {
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return new UserDetailsImpl(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
