package org.df.resourcehub.services;

import org.df.resourcehub.models.User;
import org.df.resourcehub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
        //TODO: Password hashing so raw passwords aren't stored in DB - TDD (Spring Security adds too much complexity)
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email already has an account associated with it");
        }

//        user.setPassword(passwordHelpers.generatePasswordHash(user.getPassword()));
        return userRepository.save(user);
    }

    public User loginUser(User user) {
        //check if the email provided is in the DB
        //check if the password provided matches with the entry for that email
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb != null && user.getPassword().equals(userFromDb.getPassword())) {
            return userFromDb;
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login credentials");
    }
}
