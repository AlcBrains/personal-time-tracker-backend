package com.chistopher.timetrackerbackend.controller;


import com.chistopher.timetrackerbackend.domain.entity.Post;
import com.chistopher.timetrackerbackend.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class MainController {

    private final PostService postService;
    private final ObjectMapper om;

    @Autowired
    public MainController(PostService postService, ObjectMapper om) {
        this.postService = postService;
        this.om = om;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.findAll().stream().sorted(Comparator.comparing(Post::getCreatedAt)).collect(Collectors.toList());
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.get(id);
    }

    @PostMapping("/posts/post")
    public void savePost(@RequestBody String body) throws JsonProcessingException {
        postService.save(om.readValue(body, Post.class));
    }
}
