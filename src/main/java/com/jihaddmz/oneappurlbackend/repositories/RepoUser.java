package com.jihaddmz.oneappurlbackend.repositories;

import com.jihaddmz.oneappurlbackend.entities.EntityUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoUser extends MongoRepository<EntityUser, String> {
}
