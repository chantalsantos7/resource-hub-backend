package org.df.resourcehub.services;

import org.df.resourcehub.models.Collection;
import org.df.resourcehub.models.Resource;
import org.df.resourcehub.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public void addNewCollection(Collection newCollection) {
        collectionRepository.save(newCollection);
    }

    public Collection addNewResourceToCollection(String collectionId, Resource newResource) {
        Optional<Collection> collection = collectionRepository.findById(collectionId);
        if (collection.isPresent()) {
            Collection actual = collection.get();
            //try the getResources function, if it comes null, create a new list;

            List<Resource> existingResources;
            try {
                existingResources = actual.getResources();
                existingResources.add(newResource);
            } catch (NullPointerException e) {
                existingResources = new ArrayList<>();
                existingResources.add(newResource);
            }

            actual.setResources(existingResources);
            Integer updated = collectionRepository.updateResources(collectionId, existingResources);
            if (updated == 1) {
                return actual;
            }
        }
        return null;
    }

    public Collection editResourceInCollection(String collectionId, Integer resourceId, Resource editedResource) {
        Optional<Collection> collection = collectionRepository.findById(collectionId); //TODO: edit resource route reaches here, Spring throws an error about not being able to instantiate Resource
        if (collection.isPresent()) {
            Collection actual = collection.get();
            List<Resource> existingResources = actual.getResources();
            for (int i = 0; i < existingResources.size(); i++) {
                if (Objects.equals(existingResources.get(i).getResourceId(), resourceId)) {
                    existingResources.remove(i);
                    existingResources.add(editedResource);
                    break;
                }
            }
            actual.setResources(existingResources);
            Integer updated = collectionRepository.updateResources(collectionId, existingResources);
            if (updated == 1) {
                return actual;
            }
        }
        return null;
    }
}
