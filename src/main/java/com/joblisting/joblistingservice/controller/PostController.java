package com.joblisting.joblistingservice.controller;

import com.joblisting.joblistingservice.model.Post;
import com.joblisting.joblistingservice.repository.PostRepository;
import com.joblisting.joblistingservice.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("joblisting/")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SearchRepository searchRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();

    }

    @PostMapping("/save")
    public void savePost(@RequestBody Post post) {
        postRepository.save(post);
    }

    @GetMapping("/search/{text}")
    public List<Post> search(@PathVariable String text) {
        return searchRepository.findByText(text);
    }
}
