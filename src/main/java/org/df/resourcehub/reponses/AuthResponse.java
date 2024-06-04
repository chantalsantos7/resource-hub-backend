package org.df.resourcehub.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse extends RequestResponse {
    @JsonProperty("token")
    private String id;

    public AuthResponse(String message, String id) {
        super(message);
        this.id = id;
    }
}
