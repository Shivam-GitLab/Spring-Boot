package com.spring.journal.service;

import com.spring.journal.entity.User;
import com.spring.journal.repository.UserRepository;
import com.spring.journal.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void saveEntry(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }
    // Remove
    public User findByUserNames(String username){
        return userRepository.findByUserName(username);
    }
}
//
// This service class acts as a bridge between the controller and the repository.
// It contains business logic and interacts with the UserRepository to perform CRUD operations.

// controller ---> service --->  repository

