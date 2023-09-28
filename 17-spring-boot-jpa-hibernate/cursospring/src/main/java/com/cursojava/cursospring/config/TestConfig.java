package com.cursojava.cursospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.cursospring.entities.Category;
import com.cursojava.cursospring.entities.Order;
import com.cursojava.cursospring.entities.Product;
import com.cursojava.cursospring.entities.User;
import com.cursojava.cursospring.entities.enums.OrderStatus;
import com.cursojava.cursospring.repositories.CategoryRepository;
import com.cursojava.cursospring.repositories.OrderRepository;
import com.cursojava.cursospring.repositories.ProductRepository;
import com.cursojava.cursospring.repositories.UserRepository;

@Configuration
@Profile("test") // para que essa classe execute junto com o spring, basta implementar
                 // CommandLineRunner
public class TestConfig implements CommandLineRunner {

    @Autowired // o próprio spring associa automaticamente o valor de um UserRepository
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override // tudo que estiver dentro desse método é executado quando a aplicação rodar
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Marciliano Pedrosa", "marped@gmail.com", "84999999133", "Senha12345");
        User user2 = new User(null, "Ozidete Matilde", "ozitild@gmail.com", "84999999122", "Senha12345");

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        // trata-se de povoar o banco de dados H2
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
    }
}
