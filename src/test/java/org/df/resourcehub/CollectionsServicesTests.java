package org.df.resourcehub;

import org.df.resourcehub.models.Collection;
import org.df.resourcehub.repositories.CollectionRepository;
import org.df.resourcehub.services.CollectionsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        //test that it calls the collectionRepository find func with the userId
    }

    @Test
    public void testGetAllReturnsAListOfCollections() {
        String mockId = "e3r43w4324234243";

        List<Collection> collections = collectionsServices.getAllCollections(mockId);
    }
}
