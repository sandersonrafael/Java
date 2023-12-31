package com.cursojava.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursojava.spring.entities.User;

// o repositório deve extender JpaRepository<Entidade, TipoDoId>
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // não precisa fazer nada aqui, pois só de extender o JpaRepository passando User e Long, o Spring já faz tudo
}
