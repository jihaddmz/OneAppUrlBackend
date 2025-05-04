package com.jihaddmz.oneappurlbackend.repositories;

import com.jihaddmz.oneappurlbackend.entities.EntityUrl;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RepoUrl extends MongoRepository<EntityUrl, String> {

    Optional<EntityUrl> findBySlug(String slug);

    List<EntityUrl> findAllByUsername(String username);

    List<EntityUrl> findAllByAppNameLikeIgnoreCase(String query);
}
