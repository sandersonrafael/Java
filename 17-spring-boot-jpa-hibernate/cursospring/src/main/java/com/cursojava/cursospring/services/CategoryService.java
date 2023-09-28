package com.cursojava.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.cursospring.entities.Category;
import com.cursojava.cursospring.repositories.CategoryRepository;

@Service // define que a classe vai poder ser injetada com o @Autowired e que é um serviço
// poderia ser usado também o @Component, mas esse seria para casos mais genéricos, o service já é mais semântico
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> optionalCategory = repository.findById(id); // retorna um Optional de Category, onde pode ou não existir nulos
        return optionalCategory.get(); // obtém o objeto do tipo Category do optionalCategory, se existir
    }
}
