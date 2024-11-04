package com.victoandrad.mongodb.config;

import com.victoandrad.mongodb.domain.Post;
import com.victoandrad.mongodb.domain.User;
import com.victoandrad.mongodb.dto.AuthorDTO;
import com.victoandrad.mongodb.dto.CommentDTO;
import com.victoandrad.mongodb.repositories.PostRepository;
import com.victoandrad.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User user1 = new User(null, "Victor Andrade", "victor@gmail.com");
        User user2 = new User(null, "Luiza Aurora", "luiza@gmail.com");
        User user3 = new User(null, "Livia Aurora", "livia@gmail.com");

        userRepository.saveAll(List.of(user1, user2, user3));

        Post post1 = new Post(null, sdf.parse("03/11/2024"), "Partiu Enem!", "Hoje vou fazer o meu primeiro Enem!", new AuthorDTO(user2));
        Post post2 = new Post(null, sdf.parse("10/11/2024"), "Partiu Enem Novamente!", "Vamos terminar logo com isso!", new AuthorDTO(user2));

        CommentDTO comment1 = new CommentDTO("Boa sorte, Luiza!", sdf.parse("03/11/2024"), new AuthorDTO(user1));
        CommentDTO comment2 = new CommentDTO("Arrasa, Luiza!", sdf.parse("10/11/2024"), new AuthorDTO(user1));

        post1.getComments().add(comment1);
        post2.getComments().add(comment2);

        postRepository.saveAll(List.of(post1, post2));

        user1.getPosts().addAll(List.of(post1, post2));
        userRepository.save(user1);

    }
}
