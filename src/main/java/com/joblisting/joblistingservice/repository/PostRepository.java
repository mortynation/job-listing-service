package com.joblisting.joblistingservice.repository;

import com.joblisting.joblistingservice.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
