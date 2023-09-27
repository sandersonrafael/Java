package com.cursojava.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.cursospring.entities.Order;
import com.cursojava.cursospring.repositories.OrderRepository;

@Service // define que a classe vai poder ser injetada com o @Autowired e que é um serviço
// poderia ser usado também o @Component, mas esse seria para casos mais genéricos, o service já é mais semântico
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> optionalOrder = repository.findById(id); // retorna um Optional de Order, onde pode ou não existir nulos
        return optionalOrder.get(); // obtém o objeto do tipo Order do optionalOrder, se existir
    }
}
