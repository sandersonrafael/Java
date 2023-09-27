package com.cursojava.cursospring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.cursospring.entities.User;
import com.cursojava.cursospring.repositories.UserRepository;

@Configuration
@Profile("test")  // para que essa classe execute junto com o spring, basta implementar CommandLineRunner
public class TestConfig implements CommandLineRunner {

    @Autowired // o próprio spring associa automaticamente o valor de um UserRepository
    private UserRepository userRepository;

    @Override // tudo que estiver dentro desse método é executado quando a aplicação rodar
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Marciliano Pedrosa", "marped@gmail.com", "84999999133", "Senha12345");
        User user2 = new User(null, "Ozidete Matilde", "ozitild@gmail.com", "84999999122", "Senha12345");

        // trata-se de povoar o bando de dados
        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
