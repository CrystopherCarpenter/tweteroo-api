package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    public void create(Tweet req) {
        repository.save(req);
    }

    public List<Tweet> findAll(int page) {
        PageRequest pagination = PageRequest.of(page, 5, Sort.by("id").descending());

        return repository.findAll(pagination).getContent();
    }

    public List<Tweet> findUserTweets(String username, int page) {
        PageRequest pagination = PageRequest.of(page, 5, Sort.by("id").descending());

        return repository.findAllByUsername(username, pagination);
    }
}
