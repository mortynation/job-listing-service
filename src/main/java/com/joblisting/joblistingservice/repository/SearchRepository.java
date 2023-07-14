package com.joblisting.joblistingservice.repository;

import com.joblisting.joblistingservice.model.Post;

import java.util.List;

public interface SearchRepository {

    public List<Post> findByText(String text);
}
