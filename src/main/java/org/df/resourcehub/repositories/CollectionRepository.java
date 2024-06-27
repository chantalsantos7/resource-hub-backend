package org.df.resourcehub.repositories;

import org.df.resourcehub.models.Collection;
import org.df.resourcehub.models.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface CollectionRepository extends MongoRepository<Collection, String> {

    @Query("{ 'userId': ObjectId(?0)} ")
    List<Collection> findByUserId(String userId);

    @Query("{ '_id': ObjectId(?0) }")
    @Update("{'$set': {'resources': ?1}}")
    Integer updateResources(String id, List<Resource> updatedResources);
}
