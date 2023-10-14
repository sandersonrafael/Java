package com.cursojava.springmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursojava.springmongo.domain.User;
import com.cursojava.springmongo.repositories.UserRepository;

// utilizada para fazer testes com o DB. No caso, ela é executada quando a aplicação inicia
// dando uma carga de documentos iniciais para a DB para testes
@Configuration // para declarar para o spring que trata-se somente de uma configuração
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll(); // limpa tudo que tem previamente no DB

        User dede = new User(null, "Eduardo André", "edude@hotmail.com");
        User fabio = new User(null, "Fabrício Almeida", "fabmeida@hotmail.com");
        User felipe = new User(null, "Felipe Cácio", "felico@hotmail.com");

        repository.saveAll(Arrays.asList(dede, fabio, felipe)); // injeta novos objetos no DB
    }

}
