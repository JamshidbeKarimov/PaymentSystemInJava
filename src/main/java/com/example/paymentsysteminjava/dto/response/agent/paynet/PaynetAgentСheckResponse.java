package com.example.paymentsysteminjava.dto.response.agent.paynet;

import com.example.paymentsysteminjava.dto.response.agent.BaseAgentResponse;
import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaynetAgentСheckResponse implements BaseAgentResponse {

    @JsonProperty("transaction_id")
    private long transactionId;
    private int status;

    @JsonProperty("service_name")
    private String serviceName;
    @JsonProperty("amount_to_account")
    private BigDecimal amountToAccount;
    private String response;

    @JsonIgnore
    @Override
    public BaseAgentResponse success(AgentEntity agent, MerchantEntity merchantEntity, MerchantServiceEntity merchantServiceEntity, TransactionEntity transaction) {
        return new PaynetAgentСheckResponse(
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
        return new PaynetAgentСheckResponse(
                transaction.getId(),
                transaction.getTransactionState(),
                merchantServiceEntity.getName(),
                transaction.getTransactionAmountToMerchant(),
                "transaction is fain in check process"
        );
    }
}
