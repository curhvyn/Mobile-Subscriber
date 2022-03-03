package com.example.Mobile.Subscriber.service;

import com.example.Mobile.Subscriber.DTO.SubscriberDTO;
import com.example.Mobile.Subscriber.model.Subscriber;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriberService {
        List<Subscriber> getAllSubscribers();

        void saveSubscriber(SubscriberDTO subscriber);

        Subscriber getSubscriberById(Long id);

        void deleteSubscriberById(long id);

        List<Subscriber> findByKeyword(String keyword);

        List<Subscriber> findAllWithSort(String field);

//        Page<Subscriber> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);



}
