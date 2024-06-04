package com.projetonelio.springcourse.config;

import com.projetonelio.springcourse.entities.User;
import com.projetonelio.springcourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/**
 * A interface CommandLineRunner força a implementação do método run.
 * Esse método será executado sempre que a aplicação rodar, como se fosse um método main.
 * Dessa forma, podemos instanciar os objetos sem necessariamente poluir o nosso método main
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Guilherme Taliberti", "guilhermetaliberti@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Maluzinha", "maluzinha@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
