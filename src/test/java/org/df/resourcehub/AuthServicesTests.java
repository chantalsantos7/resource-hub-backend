package org.df.resourcehub;

import org.df.resourcehub.models.User;
import org.df.resourcehub.repositories.UserRepository;
import org.df.resourcehub.services.AuthServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthServicesTests {

//    private AuthServices authServices;
//    private UserRepository userRepository;
//
//    @BeforeEach
//    public void setup() {
//        userRepository = mock(UserRepository.class);
//        authServices = new AuthServices(userRepository);
//    }
//
//    //mocks for testing behaviour
//    //stubs for testing logic
//    @Test
//    public void testUserIsSavedIntoDb() {
//        User user = new User();
//        user.setEmail("test@email.com");
//
//        //need to check that when signUpUser is called, the userRepository method is called
//        authServices.signupUser(user);
//        when(userRepository.save(user)).thenReturn(new User());
//
//
//    }

//    @Test
//    public void testEmailDuplicateIsNotAllowedInSignup() {
//        fail();
////        User user = new User();
////        user.setEmail("test@email.com");
////        authServices.signupUser();
//    }
}
