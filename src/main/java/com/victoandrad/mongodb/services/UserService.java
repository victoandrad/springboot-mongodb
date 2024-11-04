package com.victoandrad.mongodb.services;

import com.victoandrad.mongodb.domain.User;
import com.victoandrad.mongodb.repositories.UserRepository;
import com.victoandrad.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Invalid User"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }
}
