package org.df.resourcehub.controllers;

import jakarta.validation.Valid;
import org.df.resourcehub.models.User;
import org.df.resourcehub.responses.AuthResponse;
import org.df.resourcehub.responses.RequestResponse;
import org.df.resourcehub.services.AuthServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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


@PostMapping(value="auth/signup")
public ResponseEntity<RequestResponse> postSignup(@Valid @RequestBody User user) {
    try {
        authServices.signupUser(user);
        return new ResponseEntity<>(new RequestResponse("Signup successful"), HttpStatus.CREATED);
    } catch (ResponseStatusException e) {
        return new ResponseEntity<>(new RequestResponse(e.getReason()), HttpStatus.BAD_REQUEST);
    }
}

    @PostMapping(value = "auth/login")
    public ResponseEntity<RequestResponse> postLogin(@Valid @RequestBody User user) {
       try {
           User loggedInUser = authServices.loginUser(user);
           return new ResponseEntity<>(new AuthResponse("Login successful", loggedInUser.getId()), HttpStatus.ACCEPTED);
       } catch (ResponseStatusException e) {
           return new ResponseEntity<>(new RequestResponse(e.getReason()), HttpStatus.UNAUTHORIZED);
       }
    }

}
