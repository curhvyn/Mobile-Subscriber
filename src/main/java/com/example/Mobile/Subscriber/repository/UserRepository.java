package com.example.Mobile.Subscriber.repository;

import com.example.Mobile.Subscriber.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
