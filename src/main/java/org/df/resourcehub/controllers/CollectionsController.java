package org.df.resourcehub.controllers;

import org.df.resourcehub.models.Collection;
import org.df.resourcehub.responses.AllCollectionsResponse;
import org.df.resourcehub.responses.CollectionResponse;
import org.df.resourcehub.responses.RequestResponse;
import org.df.resourcehub.services.CollectionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<RequestResponse> getAllCollections(@RequestParam("token") String tokenCookie) {

        List<Collection> collections = collectionsServices.getAllCollections(tokenCookie);
//        System.out.println(collections);
        return new ResponseEntity<>(new AllCollectionsResponse("Found collections", collections), HttpStatus.OK);
    }

    @GetMapping("collections/view")
    public ResponseEntity<RequestResponse> getCollection(@RequestParam("id") String collectionId) {
        Collection collection = collectionsServices.getCollection(collectionId);
        if (collection == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CollectionResponse("Found collection", collection), HttpStatus.FOUND);
    }

@PostMapping("collections/add")
    public String addNewCollection() {
        return "i could add one if i wanted to";
}
}
