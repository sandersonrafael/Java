package com.cursojava.springmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.springmongo.domain.Post;
import com.cursojava.springmongo.repositories.PostRepository;
import com.cursojava.springmongo.services.exceptions.ObjectNotFoundException;

@Service // declara que é um service para o spring, abstraindo
public class PostService {

    @Autowired // instanciar automaticamente dentro dessa variável
    private PostRepository repository;


    public Post findById(String id) {
        try {
            Post post = repository.findById(id).get();
            return post;
        } catch (RuntimeException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
    }
}
