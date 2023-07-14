package com.joblisting.joblistingservice.controller;

import com.joblisting.joblistingservice.model.Post;
import com.joblisting.joblistingservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("joblisting/")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();

    }

    @PostMapping("/save")
    public void savePost(@RequestBody Post post) {
        postRepository.save(post);
    }
}
