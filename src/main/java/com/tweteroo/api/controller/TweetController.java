package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public List<Tweet> listAll(@RequestParam(name = "page", defaultValue = "1") int page) {
        Pageable pagination = PageRequest.of(page, 5, Sort.by("id").descending());

        Page<Tweet> tweets = repository.findAll(pagination);
        return tweets.getContent();
    }

    @GetMapping("/{username}")
    public List<Tweet> listUserTweets(@PathVariable String username, @RequestBody @Valid TweetDTO req,
            @RequestParam(name = "page", defaultValue = "1") int page) {
        Pageable pagination = PageRequest.of(page, 5, Sort.by("id").descending());

        List<Tweet> tweets = repository.findAllByUsername(username, pagination);
        return tweets;
    }

}
