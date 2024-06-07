package org.df.resourcehub.services;

import org.df.resourcehub.models.Collection;
import org.df.resourcehub.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionsServices {

    private final CollectionRepository collectionRepository;

    @Autowired
    public CollectionsServices(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> getAllCollections(String id) {
        //        System.out.println(collections.toString());
        return collectionRepository.findByUserId(id); //TODO: Rework so only returns collection IDs and names
    }

    public Collection getCollection(String collectionId) {
        Optional<Collection> possibleCollection = collectionRepository.findById(collectionId);
        return possibleCollection.orElse(null);
    }
}
