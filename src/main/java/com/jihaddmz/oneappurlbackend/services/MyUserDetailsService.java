package com.jihaddmz.oneappurlbackend.services;

import com.jihaddmz.oneappurlbackend.entities.EntityUser;
import com.jihaddmz.oneappurlbackend.repositories.RepoUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final RepoUser repoUser;

    public MyUserDetailsService(RepoUser repoUser) {
        this.repoUser = repoUser;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        EntityUser entityUser = repoUser.findById(id).orElseThrow(() -> new UsernameNotFoundException("User with id " + id + " not found"));

        return org.springframework.security.core.userdetails.User.withUsername(entityUser.getUsername()).password(entityUser.getPassword()).authorities("USER").build();
    }
}
