package com.cursojava.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.cursospring.entities.Order;

// nesse caso, apesar de ter criado uma interface, não é necessário fazer implementação, pois
// puxa do próprio JpaRepository<T, U>

// é opcional aqui usar o @Repository, pois a interface já é uma extensão de JpaRepository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
