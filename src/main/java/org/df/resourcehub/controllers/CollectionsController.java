package org.df.resourcehub.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.df.resourcehub.models.Collection;
import org.df.resourcehub.models.Resource;
import org.df.resourcehub.models.ResourcePatchRequest;
import org.df.resourcehub.responses.AllCollectionsResponse;
import org.df.resourcehub.responses.CollectionResponse;
import org.df.resourcehub.responses.RequestResponse;
import org.df.resourcehub.services.CollectionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    //Body needs to be a new Resource, but also have the collection Id to know which collection to patch
    @PatchMapping(value = "collections/add-resource")
    public ResponseEntity<RequestResponse> addNewResourceToCollection(RequestEntity<String> requestEntity) { //RequestEntity<String> requestEntity @RequestBody ResourcePatchRequest request
        String json = Objects.requireNonNull(requestEntity.getBody()).trim();
        ObjectMapper mapper = new ObjectMapper();

        try {
            ResourcePatchRequest request = mapper.readValue(json, ResourcePatchRequest.class);
            Resource resource = new Resource(request.getName(), request.getCategory(), request.getDateAdded(), request.getDateModified(), request.getLink(), request.getNotes());
            Collection collection = collectionsServices.addNewResourceToCollection(request.getCollectionId(), resource);
            if (collection != null) {
                return new ResponseEntity<>(new CollectionResponse("Modified collection", collection), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping(value = "collections/edit-resource")
    public ResponseEntity<RequestResponse> editResourceInCollection(RequestEntity<String> requestEntity) {
        String json = Objects.requireNonNull(requestEntity.getBody()).trim();
        ObjectMapper mapper = new ObjectMapper();

        try {
            ResourcePatchRequest request = mapper.readValue(json, ResourcePatchRequest.class);
            Resource resource = new Resource(request.getName(), request.getCategory(), request.getDateAdded(), request.getDateModified(), request.getLink(), request.getNotes(), request.getResourceId());
            Collection collection = collectionsServices.editResourceInCollection(request.getCollectionId(), request.getResourceId(), resource);
            if (collection != null) {
                return new ResponseEntity<>(new CollectionResponse("Modified collection", collection), HttpStatus.OK);
            }

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());

        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

