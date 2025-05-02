package com.jihaddmz.oneappurlbackend.repositories;

import com.jihaddmz.oneappurlbackend.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoUser extends MongoRepository<User, String> {
}
