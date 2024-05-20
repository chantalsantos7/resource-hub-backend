package org.df.resourcehub.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestResponse {
    @JsonProperty("message")
    private String message;

    public RequestResponse(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
