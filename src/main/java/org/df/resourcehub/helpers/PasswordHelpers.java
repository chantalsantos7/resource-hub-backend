package org.df.resourcehub.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PasswordHelpers {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordHelpers(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String generatePasswordHash(String password) {
        return null; //bCryptPasswordEncoder.encode(password);
    }
}
