package com.example.paymentsysteminjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "agent_entity")
public class AgentEntity extends UserEntity{
    @Transient
    private Boolean isPaynet = (super.id == 10);
    @Transient
    private Boolean isClick = (super.id == 20);
    @Transient
    private Boolean isApelsin = (super.id == 30);
    @Transient
    private Boolean isPayme = (super.id == 40);



    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_AGENT"));
        return authorities;
    }

}
