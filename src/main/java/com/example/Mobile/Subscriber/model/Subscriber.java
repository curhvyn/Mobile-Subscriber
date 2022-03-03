package com.example.Mobile.Subscriber.model;

import com.example.Mobile.Subscriber.enums.ServiceType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "subscribers")
@Getter
@Setter
@NoArgsConstructor
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 15, unique = true)
    private String msisdn;

    @Column
    @NotNull
    private Long startDate;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "owner_id",referencedColumnName = "owner_id")
    private Owner owner;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id" /*foreignKey = @ForeignKey(name = "userId", value = ConstraintMode.NO_CONSTRAINT*/)
    private User user;


    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate() {
        this.startDate = System.currentTimeMillis();
    }

    public Subscriber(Long id, String msisdn, ServiceType serviceType, Owner owner, User user) {
            this.id = id;
            this.msisdn = msisdn;
            this.startDate = System.currentTimeMillis();
            this.serviceType = serviceType;
            this.owner = owner;
            this.user = user;
        }

    public Subscriber(String msisdn, ServiceType serviceType, Owner owner, User user) {
            this.msisdn = msisdn;
            this.startDate = System.currentTimeMillis();
            this.serviceType = serviceType;
            this.owner = owner;
            this.user = user;
        }
    }
