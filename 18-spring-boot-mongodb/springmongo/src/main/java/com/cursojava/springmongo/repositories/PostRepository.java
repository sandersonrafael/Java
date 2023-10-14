package com.cursojava.springmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursojava.springmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    /* Query methods */

    // é possível adicionar métodos de busca através de querys do mongo
    // ver documentação para melhores detalhes

    // Buscar por string no título - "método de contrato"
    // O próprio vscode dá autocomplete para ajudar
    // Para ignorar a diferença de maiúsculas e minúsculas, adicionar ao método: IgnoreCase
    List<Post> findByTitleContainingIgnoreCase(String text);
}
