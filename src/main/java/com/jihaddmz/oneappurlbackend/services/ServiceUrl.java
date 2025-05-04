package com.jihaddmz.oneappurlbackend.services;

import com.jihaddmz.oneappurlbackend.components.CustomException;
import com.jihaddmz.oneappurlbackend.core.Helpers;
import com.jihaddmz.oneappurlbackend.entities.EntityUrl;
import com.jihaddmz.oneappurlbackend.repositories.RepoUrl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServiceUrl {

    private final RepoUrl repoUrl;

    public ServiceUrl(RepoUrl repoUrl) {
        this.repoUrl = repoUrl;
    }

    public List<EntityUrl> getAll() {
        return repoUrl.findAll();
    }

    public EntityUrl getUrlBySlug(String slug) {
        Optional<EntityUrl> result = repoUrl.findBySlug(slug);

        if (result.isEmpty()) {
            throw new CustomException("Url not found", 404);
        }

        result.get().setVisits(result.get().getVisits() + 1);
        repoUrl.save(result.get());

        return result.get();
    }

    public EntityUrl save(String username, String iosUrl, String androidUrl, String appName) {
        // we will check if there is a saved url before with the same slug, regenerate another one, and re-check, if not save it
        String slug;
        do {
            slug = Helpers.generateRandomString(10);
        } while (repoUrl.findBySlug(slug).isPresent());

        return repoUrl.save(new EntityUrl(username, slug, iosUrl, androidUrl, appName));
    }

    public List<EntityUrl> getAllByUsername(String username) {
        return repoUrl.findAllByUsername(username);
    }

    public EntityUrl delete(String id) {
        Optional<EntityUrl> url = repoUrl.findById(id);
        if (url.isEmpty()) {
            throw new CustomException("Url not found", 404);
        }

        repoUrl.deleteById(id);

        return url.get();
    }

    public List<EntityUrl> searchUrls(String query) {
        return repoUrl.findAllByAppNameLikeIgnoreCase(query);

    }
}
