package org.df.resourcehub.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHelpers {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PasswordHelpers(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String generatePasswordHash(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
