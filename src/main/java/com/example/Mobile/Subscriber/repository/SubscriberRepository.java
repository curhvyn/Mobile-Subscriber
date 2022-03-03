package com.example.Mobile.Subscriber.repository;

import com.example.Mobile.Subscriber.enums.ServiceType;
import com.example.Mobile.Subscriber.model.Subscriber;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    long countByServiceType(ServiceType serviceType);


    @Query(value = "select s from Subscriber s where " +
            "concat(s.msisdn, s.startDate, s.serviceType, s.owner, s.user, s.id) like %?1%")
    List<Subscriber> findByKeyword(String keyword);
}
