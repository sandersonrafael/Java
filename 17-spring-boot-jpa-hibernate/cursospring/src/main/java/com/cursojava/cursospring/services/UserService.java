package com.cursojava.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.cursospring.entities.User;
import com.cursojava.cursospring.repositories.UserRepository;

@Service // define que a classe vai poder ser injetada com o @Autowired e que é um serviço
// poderia ser usado também o @Component, mas esse seria para casos mais genéricos, o service já é mais semântico
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = repository.findById(id); // retorna um Optional de User, onde pode ou não existir nulos
        return optionalUser.get(); // obtém o objeto do tipo User do optionalUser, se existir
    }
}
