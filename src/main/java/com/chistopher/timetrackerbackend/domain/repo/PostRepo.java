package com.chistopher.timetrackerbackend.domain.repo;


import com.chistopher.timetrackerbackend.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PostRepo extends JpaRepository<Post, Long> {
}
