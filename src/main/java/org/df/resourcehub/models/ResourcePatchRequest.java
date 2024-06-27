package org.df.resourcehub.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Map;

public class ResourcePatchRequest {

    @JsonProperty("collectionId")
    private String collectionId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    @JsonProperty("dateAdded")
    private String dateAdded;

    @JsonProperty("dateModified")
    private String dateModified;


    @JsonProperty("resourceId")
    private Integer resourceId;
    public Integer getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("link")
    private String link;

    @JsonProperty("notes")
    private String notes;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

}
