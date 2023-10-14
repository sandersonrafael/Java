package com.cursojava.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursojava.springmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
