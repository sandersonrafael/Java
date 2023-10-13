package com.cursojava.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.spring.entities.User;
import com.cursojava.spring.repositories.UserRepository;

// repassa a chamada para o repository
// @Component -> utilizado para que a Classe possa ser injetada como dependência da outra classe com o @Autowired (instanciado)
// @Repository -> similar, mas é semãntico para repositórios
@Service // similar aos outros dois anteriores, porém é específico e semântico para os Services
public class UserService {

    @Autowired // para que o spring pegue os dados e "instancie" o repository
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        // optional é um objeto disponível desde o Java 8
        // para obter seu valor (User, nesse caso), é necessário usar o método .get();
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User newUserData) {
        // utilizado para obter a referência através do ID sem fazer a operação no DB; O objeto criado é apenas monitorado pelo Jpa
        User entity = repository.getReferenceById(id);
        updateData(entity, newUserData);
        return repository.save(entity);
    }

    private void updateData(User entity, User newUserData) {
        entity.setName(newUserData.getName());
        entity.setEmail(newUserData.getEmail());
        entity.setPhone(newUserData.getPhone());
    }
}
