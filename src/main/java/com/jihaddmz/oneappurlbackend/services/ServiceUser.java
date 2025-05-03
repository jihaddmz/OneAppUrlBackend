package com.jihaddmz.oneappurlbackend.services;

import com.jihaddmz.oneappurlbackend.components.CustomException;
import com.jihaddmz.oneappurlbackend.entities.EntityUser;
import com.jihaddmz.oneappurlbackend.repositories.RepoUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser {

    private final RepoUser repoUser;

    public ServiceUser(RepoUser repoUser) {
        this.repoUser = repoUser;
    }

    public EntityUser saveUser(String username, String password) {
        Optional<EntityUser> entityUser = repoUser.findById(username);
        if (entityUser.isPresent()) {
            throw new CustomException("Username is taken!", 400);
        }
       return repoUser.save(new EntityUser(username, password));
    }

    public List<EntityUser> getAllUsers() {
        return repoUser.findAll();
    }
}
