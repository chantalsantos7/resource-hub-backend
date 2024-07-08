package org.df.resourcehub.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;

public class Resource {

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    @JsonProperty("dateAdded")
    private String dateAdded;

    @JsonProperty("dateModified")
    private String dateModified;

    @JsonProperty("link")
    private String link;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("_id")
    private Integer resourceId;

    public Integer getResourceId() {
        return resourceId;
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

    public String getName() {
        return name;
    }

//    public Resource(String name, String category, String dateAdded, String dateModified, String link, String notes) {
//        this.name = name;
//        this.category = category;
//        this.dateAdded = dateAdded;
//        this.dateModified = dateModified;
//        this.link = link;
//        this.notes = notes;
//    }

    public Resource(String name, String category, String dateAdded, String dateModified, String link, String notes, Integer resourceId) {
        this.name = name;
        this.category = category;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.link = link;
        this.notes = notes;
        this.resourceId = resourceId;
    }



}
