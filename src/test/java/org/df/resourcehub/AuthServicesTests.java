package org.df.resourcehub;

import org.df.resourcehub.models.User;
import org.df.resourcehub.repositories.UserRepository;
import org.df.resourcehub.services.AuthServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServicesTests {

    private AuthServices authServices;
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class);
        authServices = new AuthServices(userRepository);
    }

    //mocks for testing behaviour
    //stubs for testing logic
    @Test
    public void testUserIsSavedIntoDb() {
        User user = new User("test@email.com");

        //need to check that when signUpUser is called, the userRepository method is called

        when(userRepository.save(user)).thenReturn(new User());
        authServices.signupUser(user);
        verify(userRepository).save(user);

    }

    @Test
    public void testEmailDuplicateIsNotAllowedInSignup() {
//        fail();
        User user = new User("test@email.com");
        authServices.signupUser(user);
        User newUser = new User("test@email.com");
        when (userRepository.findByEmail("test@email.com")).thenReturn(new User());
        assertThrows(ResponseStatusException.class, () -> authServices.signupUser(newUser));
    }
}
