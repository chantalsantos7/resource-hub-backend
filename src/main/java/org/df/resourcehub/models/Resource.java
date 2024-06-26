package org.df.resourcehub.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Resource {
    @Id
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    @JsonProperty("dateAdded")
    private Date dateAdded;

    @JsonProperty("link")
    private String link;

    @JsonProperty("notes")
    private String notes;
}
