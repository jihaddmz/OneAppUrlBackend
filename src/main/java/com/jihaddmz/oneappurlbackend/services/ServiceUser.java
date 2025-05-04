package com.jihaddmz.oneappurlbackend.services;

import com.jihaddmz.oneappurlbackend.components.CustomException;
import com.jihaddmz.oneappurlbackend.entities.EntityUser;
import com.jihaddmz.oneappurlbackend.repositories.RepoUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServiceUser {

    private final RepoUser repoUser;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public ServiceUser(RepoUser repoUser, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repoUser = repoUser;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public Map<String, Boolean> signupUser(String username, String fullName, String password) {
        Optional<EntityUser> entityUser = repoUser.findById(username);
        if (entityUser.isPresent()) {
            throw new CustomException("Username is taken!", 400);
        }
        repoUser.save(new EntityUser(username, fullName, passwordEncoder.encode(password)));
       return Map.of("success", true);
    }

    public Map<String, String> signInUser(String username, String password) {
        Optional<EntityUser> entityUser = repoUser.findByUsername(username);

        if (entityUser.isEmpty()) {
            throw new CustomException("User with username " + username + " is not found", 404);
        }

        if (!passwordEncoder.matches(password, entityUser.get().getPassword())) {
            throw new CustomException("Wrong password!", 400);
        }

        return Map.of("token", jwtService.generateToken(username));
    }

    public List<EntityUser> getAllUsers() {
        return repoUser.findAll();
    }
}
