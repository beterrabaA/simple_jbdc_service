package com.beterraba.service.config;

import com.beterraba.service.entities.Category;
import com.beterraba.service.entities.Order;
import com.beterraba.service.entities.User;
import com.beterraba.service.entities.enums.OrderStatus;
import com.beterraba.service.repositories.CategoryRepository;
import com.beterraba.service.repositories.OrderRepository;
import com.beterraba.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(1, "Electronics");
        Category cat2 = new Category(2, "Books");
        Category cat3 = new Category(3, "Computers");

        User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(1, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(2, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(3, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.SHIPPED, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
    }
}
