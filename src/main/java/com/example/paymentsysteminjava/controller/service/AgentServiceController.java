package com.example.paymentsysteminjava.controller.service;

import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.dto.crud.register.AgentServiceDto;
import com.example.paymentsysteminjava.service.agent_service.AgentServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agent/service/")
@RequiredArgsConstructor
public class AgentServiceController {
    private final AgentServiceService agentServiceService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @RequestMapping("/add")
    public ResponseEntity<?> add(AgentServiceDto agentServiceDto){
        return ResponseEntity.ok(agentServiceService.add(agentServiceDto));
    }
}
