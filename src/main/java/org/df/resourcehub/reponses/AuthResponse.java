package org.df.resourcehub.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse extends RequestResponse {
    @JsonProperty("token")
    private String token;

    public AuthResponse(String message) {
        super(message);
    }
}
