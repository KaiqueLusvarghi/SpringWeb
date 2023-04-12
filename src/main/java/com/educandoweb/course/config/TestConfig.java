package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  // essa classe vai ser usada para fazer o database seeding

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public void run(String... args) throws Exception {
    // tudo que voce colocar aqui dentro desse metodo, vai ser executado quando a
    // aplicação for iniciada

    // instnaciando objetos do tipo usuario
    User u1 = new User(null, "Kaikon", "kaikon@gmail.com", "1334945135", "123456");
    User u2 = new User(null, "Mariana", "mariana@gmail.com", "1334345135", "123456");

    Order o1 = new Order(null, Instant.parse("2023-01-20T19:53:07Z"), OrderStatus.PAID, u1);
    Order o2 = new Order(null, Instant.parse("2023-01-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
    Order o3 = new Order(null, Instant.parse("2023-01-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");
    // salavando os usuarios no banco de dados
    userRepository.saveAll(Arrays.asList(u1, u2));

    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    
    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

  }

}
