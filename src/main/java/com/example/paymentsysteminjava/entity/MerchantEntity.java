package com.example.paymentsysteminjava.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
public class MerchantEntity extends BaseEntity{

    private String secretKey;
    private String username;
    private String password;



    @Transient
    private Boolean isUcell  = (super.id == 30);
    @Transient
    private Boolean isYandex = (super.id == 20);
    @Transient
    private Boolean isPayme  = (super.id == 10);
}
