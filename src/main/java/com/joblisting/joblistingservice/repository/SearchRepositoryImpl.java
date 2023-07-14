package com.joblisting.joblistingservice.repository;

import com.joblisting.joblistingservice.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Post> findByText(String text) {

        List<Post> posts = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("morty");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text", new Document("query", text).append("path", Arrays.asList("techs", "profile", "desc")))),
                        new Document("$sort", new Document("exp", 1L)),
                        new Document("$limit", 4L)));
        result.forEach(document -> posts.add(mongoConverter.read(Post.class, document)));
        return posts;
    }
}
