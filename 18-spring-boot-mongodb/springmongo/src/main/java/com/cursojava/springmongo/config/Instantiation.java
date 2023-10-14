package com.cursojava.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursojava.springmongo.domain.Post;
import com.cursojava.springmongo.domain.User;
import com.cursojava.springmongo.dto.AuthorDTO;
import com.cursojava.springmongo.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(dede, fabio, felipe)); // injeta novos objetos no DB

        // necessário salvar primeiro os usuários com o repository para que eles tenham id gerado pelo mongo e não fiquem nulos
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(dede));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(dede));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(fabio));
        CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(felipe));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(fabio));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        // adicionando posts ao usuário
        dede.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(dede);
    }

}
