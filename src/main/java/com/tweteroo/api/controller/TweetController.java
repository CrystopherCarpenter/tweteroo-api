package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetRepository repository;

    @PostMapping
    public String create(@RequestBody @Valid TweetDTO req) {
        repository.save(new Tweet(req));

        return ("OK");
    }

}
