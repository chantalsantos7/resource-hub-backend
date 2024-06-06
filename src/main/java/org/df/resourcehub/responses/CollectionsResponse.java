package org.df.resourcehub.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.df.resourcehub.models.Collection;

import java.util.List;

public class CollectionsResponse extends RequestResponse {

    @JsonProperty("collections")
    private List<Collection> collections;
    public CollectionsResponse(String message, List<Collection> collections) {
        super(message);
        this.collections = collections;
    }
}
