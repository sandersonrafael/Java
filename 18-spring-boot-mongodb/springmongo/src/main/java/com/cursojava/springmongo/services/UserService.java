package com.cursojava.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.springmongo.domain.User;
import com.cursojava.springmongo.dto.UserDTO;
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

    public User insert(User user) {
        return repository.insert(user);
    }

    public Void delete(String id) {
        try {
            repository.findById(id).get();
            repository.deleteById(id);
        } catch (RuntimeException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
        return null;
    }

    public User update(User data) {
        try {
            User newUser = repository.findById(data.getId()).get();
            updateData(newUser, data);
            return repository.save(newUser);
        } catch (RuntimeException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    private void updateData(User newUser, User data) {
        newUser.setName(data.getName());
        newUser.setEmail(data.getEmail());
    }
}
