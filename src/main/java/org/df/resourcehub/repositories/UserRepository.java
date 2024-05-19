package org.df.resourcehub.repositories;

import org.df.resourcehub.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, String> {
    public User findByEmail(String email);
}
