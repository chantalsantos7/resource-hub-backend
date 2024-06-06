package org.df.resourcehub.repositories;

import org.df.resourcehub.models.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CollectionRepository extends MongoRepository<Collection, String> {

    @Query("{ 'userId': ObjectId(?0)} ")
    List<Collection> findByUserId(String userId);
}
