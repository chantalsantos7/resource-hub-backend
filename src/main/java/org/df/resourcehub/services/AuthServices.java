package org.df.resourcehub.services;

//import org.df.resourcehub.helpers.PasswordHelpers;
import org.df.resourcehub.models.User;
import org.df.resourcehub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class AuthServices {
    private final UserRepository userRepository;
//    private final PasswordHelpers passwordHelpers;

    @Autowired
    public AuthServices(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordHelpers = passwordHelpers;, PasswordHelpers passwordHelpers
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User signupUser(User user) {
        //TODO: Password hashing so raw passwords aren't stored in DB - TDD
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email already has an account associated with it");
        }

//        user.setPassword(passwordHelpers.generatePasswordHash(user.getPassword()));

        return userRepository.save(user);
    }

    public User loginUser(User user) {
        //check if the email provided is in the DB
        //check if the password provided matches with the entry for that email
        var userFromDb = userRepository.findByEmail(user.getEmail());
        if (Objects.equals(user.getPassword(), userFromDb.getPassword())) {
            return userFromDb;
        }

        return null; //TODO: Throw ResponseStatusException instead?
    }
}
