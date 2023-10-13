package com.cursojava.spring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping // define que esta será uma requisição do tipo Post
    // para receber os parâmetros pelo corpo da requisição, utilizamos a anotation @RequestBody no argumento
    public ResponseEntity<User> insert(@RequestBody User user) {
        User savedUser = service.insert(user);
        // para personalizar o status de resposta, em vez de só usar ResponseEntity.ok() (ok significa status 200),
        // podemos utilizar ResponseEntity.status(numeroDoStatus).body(entidadeSalva)
        // além disso, há outros métodos que já são específicos, como o created(), que já representa status 201 ou
        // badRequest(), etc. Esses métodos podem exigir uma URI (basicamente o link de acesso ao novo objeto)

        // ServletUriComponentsBuilder é usado para obter uma URI da requisição (um header da response com o nome location
        // e que representa a url do novo objeto criado) -> essa é a vantagem de se utilizar isso em vez de status(201)
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
        return ResponseEntity.created(uri).body(savedUser);
        // return ResponseEntity.status(201).body(savedUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // ao tentar deletar o usuário 1, apresenta erro, pois há outras entidades relacionadas à entidade 1, podendo resultar em falha de integridade
        service.delete(id);
        // O método noContent() significa que a ação funcionou mas não retorna nada. Necessário chamar o build() após isto
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User newUserData) {
        User newUser = service.update(id, newUserData);
        return ResponseEntity.ok().body(newUser);
    }
}
