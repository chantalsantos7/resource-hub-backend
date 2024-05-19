package org.df.resourcehub.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PasswordHelpersTests {

    BCryptPasswordEncoder passwordEncoder;
    PasswordHelpers passwordHelpers;

    @BeforeEach
    public void setupTests() {
        passwordEncoder = mock(BCryptPasswordEncoder.class);
        passwordHelpers = new PasswordHelpers(passwordEncoder);
    }

    @Test
    public void testGeneratedHashIsNotTheSameAsPassword() {
        String passwordHash = passwordHelpers.generatePasswordHash("testpassword");
        assertNotEquals(passwordHash, "testpassword");
    }

    @Test
    public void testArgumentIsUsedToGenerateHash() {
        //check that the arg String is being used inside the internal function?
        //mock the hash and random providers, check if it is called on input

        String testString = "testpassword";
        System.out.println(passwordHelpers.generatePasswordHash(testString));;
        verify(passwordEncoder).encode(testString);
    }

    @Test
    public void testGeneratedHashMatchesPassword() {
        String testString = "testPassword";
        String hashedString = "hashedPassword";
        when(passwordEncoder.encode(testString)).thenReturn(hashedString);
        String result = passwordHelpers.generatePasswordHash(testString);
//        System.out.println(result);
        assertEquals(result, hashedString);  }

}
