package com.example.paymentsysteminjava.service.agent_service;

import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.dto.crud.register.AgentServiceDto;

public interface AgentServiceService {
    AddResponseDto add(AgentServiceDto agentServiceDto);
}
