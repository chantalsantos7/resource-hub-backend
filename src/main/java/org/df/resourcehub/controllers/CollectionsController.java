package org.df.resourcehub.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
public class CollectionsController {

    @GetMapping("collections/view")
    public String getAllCollections() {
        return "Can access this route";
    }

@PostMapping("collections/add")
    public String addNewCollection() {
        return "i could add one if i wanted to";
}
}
