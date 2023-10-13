package com.cursojava.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.springmongo.domain.User;
import com.cursojava.springmongo.repositories.UserRepository;

@Service // declara que é um service para o spring, abstraindo
public class UserService {

    @Autowired // instanciar automaticamente dentro dessa variável
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
