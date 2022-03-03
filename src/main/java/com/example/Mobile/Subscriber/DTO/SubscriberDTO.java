package com.example.Mobile.Subscriber.DTO;

import com.example.Mobile.Subscriber.enums.ServiceType;
import lombok.Data;

@Data
public class SubscriberDTO {
    private String msisdn;
    private Long startDate;
    private ServiceType serviceType;
    private String userName;
    private String ownerName;
}
