package com.example.Mobile.Subscriber.service;

import com.example.Mobile.Subscriber.model.Subscriber;
import com.example.Mobile.Subscriber.model.User;
import com.example.Mobile.Subscriber.repository.SubscriberRepository;
import com.example.Mobile.Subscriber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}

