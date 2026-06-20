package com.srgec.movies_app.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.srgec.movies_app.config.JwtService;
import com.srgec.movies_app.exception.UserNotFoundException;
import com.srgec.movies_app.models.User;
import com.srgec.movies_app.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public UserService(UserRepository repository, PasswordEncoder encoder, JwtService jwtService) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public User register(User user) throws Exception {
        // check if the user exists by email
        Optional<User> foundUser = repository.findByEmail(user.getEmail());
        if (foundUser.isPresent()) {
            throw new Exception("user already exist with this email.");
        }

        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

    public String login(String email, String password) throws Exception {
        // check if the user exists by email
        Optional<User> foundUser = repository.findByEmail(email);
        if (!foundUser.isPresent()) {
            throw new UserNotFoundException();
        }
        // verify password
        User user = foundUser.get();
        boolean matches = encoder.matches(password, user.getPassword());
        if (!matches) {
            throw new RuntimeException("Invalid Password");
        }

        return jwtService.generateToken(email);
    }
}
