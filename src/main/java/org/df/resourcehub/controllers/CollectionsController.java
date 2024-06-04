package org.df.resourcehub.controllers;

import jakarta.validation.Valid;
import org.df.resourcehub.reponses.RequestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
public class CollectionsController {

    @GetMapping("collections/get-all")
    public ResponseEntity<RequestResponse> getAllCollections() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
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
