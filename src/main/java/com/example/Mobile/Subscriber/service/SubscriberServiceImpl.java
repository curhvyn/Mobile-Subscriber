package com.example.Mobile.Subscriber.service;

import com.example.Mobile.Subscriber.DTO.SubscriberDTO;
import com.example.Mobile.Subscriber.model.Owner;
import com.example.Mobile.Subscriber.model.Subscriber;
import com.example.Mobile.Subscriber.model.User;
import com.example.Mobile.Subscriber.repository.SubscriberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubscriberServiceImpl implements SubscriberService{

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }

    @Override
    public void saveSubscriber(SubscriberDTO subscriberDTO) {

        Subscriber subscriber = new Subscriber();
        Owner owner = new Owner();
        User user = new User();

        /*Owner Details*/
        owner.setOwnerName(subscriberDTO.getOwnerName());

        /*USer Details*/
        user.setUserName(subscriberDTO.getUserName());


        /*Subscriber Details*/
        subscriber.setMsisdn(subscriberDTO.getMsisdn());
        subscriber.setStartDate(subscriberDTO.getStartDate());
        subscriber.setServiceType(subscriberDTO.getServiceType());
        subscriber.setUser(user);
        subscriber.setOwner(owner);

        log.info("[SUBSCRIBER DETAILS] ==> {}",subscriber);
        this.subscriberRepository.save(subscriber);
    }

    @Override
    public Subscriber getSubscriberById(Long id) {
        Optional<Subscriber> optional = subscriberRepository.findById(id);
        Subscriber subscriber;
        if (optional.isPresent()){
            subscriber = optional.get();
        }else {
            throw new RuntimeException("Subscriber not found for id : " + id);
        }
        return subscriber;
    }

    @Override
    public void deleteSubscriberById(long id) {
        this.subscriberRepository.deleteAllById(Collections.singleton(id));
    }


    @Override
    public List<Subscriber> findAllWithSort(String field){
        return subscriberRepository.findAll(Sort.by(field));
    }

    @Override
    public List<Subscriber> findByKeyword(String keyword){
        return subscriberRepository.findByKeyword(keyword);
    }
}
