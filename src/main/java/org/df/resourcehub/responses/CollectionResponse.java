package org.df.resourcehub.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.df.resourcehub.models.Collection;

public class CollectionResponse extends RequestResponse {
    @JsonProperty("collection")
    private Collection collection;


    public CollectionResponse(String message, Collection collection) {
        super(message);
        this.collection = collection;
    }
}
