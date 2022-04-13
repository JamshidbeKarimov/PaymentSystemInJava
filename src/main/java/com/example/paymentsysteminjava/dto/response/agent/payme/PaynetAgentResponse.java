package com.example.paymentsysteminjava.dto.response.agent.payme;

import com.example.paymentsysteminjava.dto.response.agent.BaseAgentResponse;
import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class PaynetAgentResponse implements BaseAgentResponse {
    private long transactionId;
    private int status;
    private String serviceName;
    private BigDecimal amountToAccount;
    private String response;

    @JsonIgnore
    @Override
    public BaseAgentResponse success(AgentEntity agent, MerchantEntity merchantEntity, MerchantServiceEntity merchantServiceEntity, TransactionEntity transaction) {
        return new PaynetAgentResponse(
                transaction.getId(),
                transaction.getTransactionState(),
                merchantServiceEntity.getName(),
                transaction.getTransactionAmountToMerchant(),
                "transaction is ready"
        );
    }

    @JsonIgnore
    @Override
    public BaseAgentResponse error(AgentEntity agent, MerchantEntity merchantEntity, MerchantServiceEntity merchantServiceEntity, TransactionEntity transaction) {
        return new PaynetAgentResponse(
                transaction.getId(),
                transaction.getTransactionState(),
                merchantServiceEntity.getName(),
                transaction.getTransactionAmountToMerchant(),
                "transaction is fain in check process"
        );
    }
}
