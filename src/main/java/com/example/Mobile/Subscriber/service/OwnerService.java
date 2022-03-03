package com.example.Mobile.Subscriber.service;

import com.example.Mobile.Subscriber.model.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {
    List<Owner> getAllOwners();
}
