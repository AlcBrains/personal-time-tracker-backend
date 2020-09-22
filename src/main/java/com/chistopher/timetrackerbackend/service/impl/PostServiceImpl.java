package com.chistopher.timetrackerbackend.service.impl;

import com.chistopher.timetrackerbackend.domain.entity.Post;
import com.chistopher.timetrackerbackend.domain.repo.PostRepo;
import com.chistopher.timetrackerbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public Post get(Long id) {
        return postRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }
}
