package org.df.resourcehub.controllers;

import jakarta.validation.Valid;
import org.df.resourcehub.models.User;
import org.df.resourcehub.services.AuthServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(User.class);

    private final AuthServices authServices;

    @Autowired
    public AuthController(AuthServices authServices) {
        this.authServices = authServices;
    }

    //Test method only, do not actually want a GET route for getting user details
    @GetMapping(value = "auth/users")
    public List<User> getAllUsers() {
        return authServices.getAllUsers();
    }

    @PostMapping(value="auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User postSignup(@Valid @RequestBody User user) {
        return authServices.signupUser(user);
    }

}
