package com.cursojava.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.spring.entities.User;
import com.cursojava.spring.repositories.UserRepository;

@Configuration // define que trata-se de uma classe de configuração
@Profile("test") // define que trata-se de uma configuração de teste, conforme arquivo:
                 // application-test.properties
public class TestConfig implements CommandLineRunner { // essa implementação faz com que o código seja executado quando
                                                       // o programa iniciar a execução, dentro do método "run"

    // injeção de dependência
    @Autowired // o próprio Spring resolve essa dependência e associar uma dep de serRepository
               // dentro desta classe
    private UserRepository userRepository; // o userRepository quem será usado para manipular os objetos no DB

    @Override
    public void run(String... args) throws Exception {
        // id é nulo porque o DB quem define
       User usuario1 = new User(null, "Maria Joaquina", "marijo@email.com", "21999999999", "senha1234");
       User usuario2 = new User(null, "Dede Soares", "dedeso@email.com", "11999999999", "senha4321");

       userRepository.saveAll(Arrays.asList(usuario1, usuario2));
    }
}
