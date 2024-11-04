package com.victoandrad.mongodb.resources;

import com.victoandrad.mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User user = new User("1", "Victor Andrade", "victor@gmail.com");
        return ResponseEntity.ok().body(List.of(user));
    }
}
