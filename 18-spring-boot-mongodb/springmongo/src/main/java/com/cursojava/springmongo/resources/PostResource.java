package com.cursojava.springmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.springmongo.domain.Post;
import com.cursojava.springmongo.resources.util.URL;
import com.cursojava.springmongo.services.PostService;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired // instanciação abstraída pelo spring
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        // o parâmetro vem encodado, como mensionado anteriormente, com caracteres diferentes do correto como %20 para espaço
        text = URL.decodeParam(text); // decodificado para o que foi realmente escrito

        List<Post> posts = service.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
}
