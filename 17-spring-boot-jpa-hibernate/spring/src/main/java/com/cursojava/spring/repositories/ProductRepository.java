package com.cursojava.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursojava.spring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
