package com.victoandrad.mongodb.config;

import com.victoandrad.mongodb.domain.User;
import com.victoandrad.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Victor Andrade", "victor@gmail.com");
        User user2 = new User(null, "Luiza Aurora", "luiza@gmail.com");
        User user3 = new User(null, "Livia Aurora", "livia@gmail.com");

        userRepository.deleteAll();
        userRepository.saveAll(List.of(user1, user2, user3));
    }
}
