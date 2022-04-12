package com.example.paymentsysteminjava.servise.agent;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.UserEntity;
import com.example.paymentsysteminjava.exception.LoginValidationException;
import com.example.paymentsysteminjava.repository.AgentRepository;
import com.example.paymentsysteminjava.servise.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Primary
@Service("a")
@RequiredArgsConstructor
public class AgentServiceImp implements UserService {

    private final AgentRepository agentRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Boolean add(UserRegisterDto userRegisterDto) {
        Optional<AgentEntity> optionalAgent = agentRepository.findByUsername(userRegisterDto.getUsername());
        if (optionalAgent.isPresent())
            throw new LoginValidationException("username is already exists");

        AgentEntity agentEntity = new AgentEntity();
        agentEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        agentEntity.setPermission(userRegisterDto.getPermission().get(0));
        agentEntity.setName(userRegisterDto.getName());
        agentEntity.setUsername(userRegisterDto.getUsername());
        agentRepository.save(agentEntity);
        return true;
    }

    @Override
    public Optional<UserEntity> getUser(Long id) {
        return Optional.empty();
    }


}
