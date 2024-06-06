package org.df.resourcehub.controllers;

import org.df.resourcehub.models.Collection;
import org.df.resourcehub.responses.CollectionsResponse;
import org.df.resourcehub.responses.RequestResponse;
import org.df.resourcehub.services.CollectionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
public class CollectionsController {

    private final CollectionsServices collectionsServices;

    @Autowired
    public CollectionsController(CollectionsServices collectionsServices) {
        this.collectionsServices = collectionsServices;
    }

    @GetMapping("collections/get-all")
    public ResponseEntity<RequestResponse> getAllCollections(@CookieValue("token") String tokenCookie) {

        List<Collection> collections = collectionsServices.getAllCollections(tokenCookie);
//        System.out.println(collections);
        return new ResponseEntity<>(new CollectionsResponse("Found collections", collections), HttpStatus.OK);
    }

    @GetMapping("collections/view")
    public ResponseEntity<RequestResponse> getCollection(@RequestBody String collectionId) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

@PostMapping("collections/add")
    public String addNewCollection() {
        return "i could add one if i wanted to";
}
}
