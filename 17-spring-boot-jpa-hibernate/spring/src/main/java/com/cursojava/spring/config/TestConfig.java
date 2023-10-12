package com.cursojava.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.spring.entities.Category;
import com.cursojava.spring.entities.Order;
import com.cursojava.spring.entities.OrderItem;
import com.cursojava.spring.entities.Payment;
import com.cursojava.spring.entities.Product;
import com.cursojava.spring.entities.User;
import com.cursojava.spring.entities.enums.OrderStatus;
import com.cursojava.spring.repositories.UserRepository;
import com.cursojava.spring.repositories.CategoryRepository;
import com.cursojava.spring.repositories.OrderItemRepository;
import com.cursojava.spring.repositories.OrderRepository;
import com.cursojava.spring.repositories.ProductRepository;

@Configuration // define que trata-se de uma classe de configuração
@Profile("test") // define que trata-se de uma configuração de teste, conforme arquivo:
                 // application-test.properties
public class TestConfig implements CommandLineRunner { // essa implementação faz com que o código seja executado quando
                                                       // o programa iniciar a execução, dentro do método "run"

    // injeção de dependência
    @Autowired // o próprio Spring resolve essa dependência e associar uma dep de serRepository dentro desta classe
    private UserRepository userRepository; // o userRepository quem será usado para manipular os objetos no DB

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        // id é nulo porque o DB quem define
        User user1 = new User(null, "Maria Joaquina", "marijo@email.com", "21999999999", "senha1234");
        User user2 = new User(null, "Dede Soares", "dedeso@email.com", "11999999999", "senha4321");

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


        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);

        OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice());
        OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice());
        OrderItem orderItem4 = new OrderItem(order3, product5, 2, product5.getPrice());

        // poderia ter sido salvo só no final, mas foi duplicado para mostrar que é possível salvar e atualizar
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        order1.getOrderItems().add(orderItem1);
        order1.getOrderItems().add(orderItem2);
        order2.getOrderItems().add(orderItem3);
        order3.getOrderItems().add(orderItem4);

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));

        // nesse caso, no relacionamento 1 para 1, não salvaremos através do payment, pois ele é
        // uma dependência de Order. Salvaremos através do próprio order
        Payment payment1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
        order1.setPayment(payment1);

        orderRepository.save(order1);
    }
}
