package com.example.paymentsysteminjava.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class AgentServiceEntity extends BaseEntity{

    private double commission;
    private long agentId;
    private long serviceId;

}
