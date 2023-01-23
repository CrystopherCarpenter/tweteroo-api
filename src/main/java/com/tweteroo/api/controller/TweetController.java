package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.service.TweetService;
import com.tweteroo.api.service.UsersService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void create(@RequestBody @Valid TweetDTO req) {
        Users user = UsersService.findByUsername(req.username()).get(0);
        service.create(new Tweet(req, user));
    }

    @GetMapping
    public List<Tweet> listAll(@PageableDefault(page = 0) Pageable page) {
        return service.findAll(page.getPageNumber());

    }

    @GetMapping("/{username}")
    public List<Tweet> listUserTweets(@PageableDefault(page = 0) Pageable page, @PathVariable String username) {
        return service.findUserTweets(username, page.getPageNumber());
    }

}
