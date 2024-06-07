package org.df.resourcehub;

import org.df.resourcehub.models.Collection;
import org.df.resourcehub.repositories.CollectionRepository;
import org.df.resourcehub.services.CollectionsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class CollectionsServicesTests {

    private CollectionsServices collectionsServices;
    private CollectionRepository collectionRepository;

    @BeforeEach
    public void setupTests() {
        collectionRepository = mock(CollectionRepository.class);
        collectionsServices = new CollectionsServices(collectionRepository);
    }


    @Test
    public void testSearchesDBForCollectionsWithAUserId() {
//        fail();
        String mockId = "345567672354";

        collectionsServices.getAllCollections(mockId);
        verify(collectionRepository).findByUserId(mockId);
    }

    @Test
    public void testGetAllReturnsAListOfCollections() {
        String mockId = "e3r43w4324234243";
        List<Collection> expectedCollections = Arrays.asList(new Collection(), new Collection());
        when(collectionRepository.findByUserId(mockId)).thenReturn(expectedCollections);
        List<Collection> collections = collectionsServices.getAllCollections(mockId);
        assertEquals(expectedCollections, collections, "Returned list of collections should match the expected list");
    }

    @Test
    public void testGetCollectionSearchesDBForCollectionByID() {
        String mockCollectionId = "1233454677689";
        collectionsServices.getCollection(mockCollectionId);
        verify(collectionRepository).findById(mockCollectionId);
    }

    @Test
    public void testGetCollectionReturnsSingleCollection() {
        String mockCollectionId = "1233454677689";
        Optional<Collection> expectedCollection = Optional.of(new Collection());
//        expectedCollection.setId("1233454677689");
        when(collectionRepository.findById("1233454677689")).thenReturn(expectedCollection);
        Optional<Collection> actualCollection = collectionsServices.getCollection(mockCollectionId);
        assertEquals(expectedCollection, actualCollection);
    }
}
