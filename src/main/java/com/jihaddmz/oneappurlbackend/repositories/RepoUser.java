package com.jihaddmz.oneappurlbackend.repositories;

import com.jihaddmz.oneappurlbackend.entities.EntityUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RepoUser extends MongoRepository<EntityUser, String> {
    Optional<EntityUser> findByUsername(String username);
}
