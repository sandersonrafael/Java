package com.cursojava.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.springmongo.domain.User;
import com.cursojava.springmongo.repositories.UserRepository;
import com.cursojava.springmongo.services.exceptions.ObjectNotFoundException;

@Service // declara que é um service para o spring, abstraindo
public class UserService {

    @Autowired // instanciar automaticamente dentro dessa variável
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        try {
            User user = repository.findById(id).get();
            return user;
        } catch (RuntimeException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
    }
}
