package com.example.paymentsysteminjava.repository;

import com.example.paymentsysteminjava.entity.AgentServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgentServiceRepository extends JpaRepository<AgentServiceEntity, Long> {

    AgentServiceEntity findByAgentId(long id);
    @Query("select a from AgentServiceEntity a where a.agentId = ?1 and a.serviceId = ?2")
    AgentServiceEntity findByAgentIdAAndServiceId(long agentId, long serviceId);
}
