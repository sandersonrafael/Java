package com.cursojava.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.cursospring.entities.User;

// nesse caso, apesar de ter criado uma interface, não é necessário fazer implementação, pois
// puxa do próprio JpaRepository<T, U>
public interface UserRepository extends JpaRepository<User, Long> {

}
