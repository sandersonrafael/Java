package com.cursojava.spring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.spring.entities.User;

// resources são os controllers
@RestController // declara que é um controller. Anotação essencial
@RequestMapping(value = "/users") // caminho (url) que o usuário precisa ir para acessar os recursos
public class UserResource {

    // ResponseEntity<Entidade> define qual o tipo de entidade será dado como resposta ao usuário acessar
    @GetMapping // define que será acessível através de requisições do tipo Get
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Fulana", "email@email.com", "5584988887777", "senha123");
        return ResponseEntity.ok().body(u); // ResponseEntity.ok() -> representa sucesso na requisição
        // body() -> define quem será retornado ao haver sucesso
    }
}
