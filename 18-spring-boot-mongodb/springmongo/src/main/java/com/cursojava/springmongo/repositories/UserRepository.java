package com.cursojava.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursojava.springmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>  {

}
