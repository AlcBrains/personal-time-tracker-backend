package com.chistopher.timetrackerbackend.service;

import com.chistopher.timetrackerbackend.domain.entity.Post;

import java.util.List;

public interface PostService {

    void save(Post post);

    Post get(Long id);

    List<Post> findAll();
}
