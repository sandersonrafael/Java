package com.cursojava.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursojava.springmongo.domain.Post;
import com.cursojava.springmongo.domain.User;
import com.cursojava.springmongo.repositories.PostRepository;
import com.cursojava.springmongo.repositories.UserRepository;

// utilizada para fazer testes com o DB. No caso, ela é executada quando a aplicação inicia
// dando uma carga de documentos iniciais para a DB para testes
@Configuration // para declarar para o spring que trata-se somente de uma configuração
public class Instantiation implements CommandLineRunner {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll(); // limpa tudo que tem previamente no DB
        postRepository.deleteAll();

        User dede = new User(null, "Eduardo André", "edude@hotmail.com");
        User fabio = new User(null, "Fabrício Almeida", "fabmeida@hotmail.com");
        User felipe = new User(null, "Felipe Cácio", "felico@hotmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", dede);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", dede);

        userRepository.saveAll(Arrays.asList(dede, fabio, felipe)); // injeta novos objetos no DB
        postRepository.saveAll(Arrays.asList(post1, post2));
    }

}
