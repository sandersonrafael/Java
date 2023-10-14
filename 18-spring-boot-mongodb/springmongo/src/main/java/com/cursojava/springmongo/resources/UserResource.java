package com.cursojava.springmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cursojava.springmongo.domain.User;
import com.cursojava.springmongo.dto.UserDTO;
import com.cursojava.springmongo.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired // instanciação abstraída pelo spring
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> dtoList = list.stream().map(u -> new UserDTO(u)).toList();

        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    // nesse caso, é instanciado um novo usuário através do dado passado pelo body da requisição
    // este representa um UserDTO e não um User. Então o user é instanciado através dos dados do DTO
    public ResponseEntity<UserDTO> inser(@RequestBody UserDTO userDTO) {
        User user = service.fromDTO(userDTO);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();

        return ResponseEntity.created(uri).body(new UserDTO(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
        User user = service.fromDTO(userDTO);
        user.setId(id);
        user = service.update(user);

        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
