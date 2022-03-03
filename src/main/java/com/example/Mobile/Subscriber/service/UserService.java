package com.example.Mobile.Subscriber.service;

import com.example.Mobile.Subscriber.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
}
