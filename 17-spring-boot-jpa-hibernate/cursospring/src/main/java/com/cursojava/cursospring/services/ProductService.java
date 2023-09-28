package com.cursojava.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.cursospring.entities.Product;
import com.cursojava.cursospring.repositories.ProductRepository;

@Service // define que a classe vai poder ser injetada com o @Autowired e que é um serviço
// poderia ser usado também o @Component, mas esse seria para casos mais genéricos, o service já é mais semântico
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = repository.findById(id); // retorna um Optional de Product, onde pode ou não existir nulos
        return optionalProduct.get(); // obtém o objeto do tipo Product do optionalProduct, se existir
    }
}
