package com.example.paymentsysteminjava.service.agent_service;

import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.dto.crud.register.AgentServiceDto;
import com.example.paymentsysteminjava.entity.AgentServiceEntity;
import com.example.paymentsysteminjava.repository.AgentServiceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AgentServiceServiceImp implements AgentServiceService{
    private final AgentServiceRepository agentServiceRepository;
    private final ModelMapper modelMapper;


    @Override
    public AddResponseDto add(AgentServiceDto agentServiceDto) {
        if(agentServiceRepository.findByAgentIdAAndServiceId(
                agentServiceDto.getAgentId(),
                agentServiceDto.getServiceId()
        ) != null)
            return new AddResponseDto(11, "Service Already exist");

        AgentServiceEntity agentServiceEntity = modelMapper.map(agentServiceDto, AgentServiceEntity.class);
        agentServiceRepository.save(agentServiceEntity);
        return new AddResponseDto(1, "Service added");
    }
}
