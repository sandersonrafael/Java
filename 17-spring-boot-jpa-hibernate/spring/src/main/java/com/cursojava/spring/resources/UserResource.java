package com.cursojava.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.spring.entities.User;
import com.cursojava.spring.services.UserService;

// resources são os controllers
@RestController // declara que é um controller. Anotação essencial
@RequestMapping(value = "/users") // caminho (url) que o usuário precisa ir para acessar os recursos
public class UserResource {

    @Autowired // dependência de um service, para que o controller possa chamar os métodos do service, que chama o repository
    private UserService service;

    // ResponseEntity<Entidade> define qual o tipo de entidade será dado como resposta ao usuário acessar
    @GetMapping // define que será acessível através de requisições do tipo Get para a url definada no RequestMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); // ResponseEntity.ok() -> representa sucesso na requisição
        // body() -> define quem será retornado ao haver sucesso
    }

    @GetMapping(value = "/{id}") // define que haverá um parâmetro de url que representa id, após a url do RequestMapping
    public ResponseEntity<User> findById(@PathVariable Long id) { // @PathVariable faz o spring reconhecer que esse é o parâmetro do GetMapping
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
