package com.cursojava.cursospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.cursospring.entities.Order;
import com.cursojava.cursospring.entities.User;
import com.cursojava.cursospring.entities.enums.OrderStatus;
import com.cursojava.cursospring.repositories.OrderRepository;
import com.cursojava.cursospring.repositories.UserRepository;

@Configuration
@Profile("test")  // para que essa classe execute junto com o spring, basta implementar CommandLineRunner
public class TestConfig implements CommandLineRunner {

    @Autowired // o próprio spring associa automaticamente o valor de um UserRepository
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override // tudo que estiver dentro desse método é executado quando a aplicação rodar
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Marciliano Pedrosa", "marped@gmail.com", "84999999133", "Senha12345");
        User user2 = new User(null, "Ozidete Matilde", "ozitild@gmail.com", "84999999122", "Senha12345");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        // trata-se de povoar o banco de dados
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
