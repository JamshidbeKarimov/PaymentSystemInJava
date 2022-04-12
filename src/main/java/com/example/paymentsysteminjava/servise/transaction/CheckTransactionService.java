package com.example.paymentsysteminjava.servise.transaction;

import com.example.paymentsysteminjava.dto.request.agent.DefaultAgentRequest;
import com.example.paymentsysteminjava.dto.response.agent.BaseAgentResponse;
import com.example.paymentsysteminjava.dto.response.agent.BaseCheckResponse;
import com.example.paymentsysteminjava.entity.AgentEntity;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.MerchantServiceEntity;
import com.example.paymentsysteminjava.entity.OsonServiceEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionEntity;
import com.example.paymentsysteminjava.entity.transaction.TransactionState;
import com.example.paymentsysteminjava.repository.MerchantRepository;
import com.example.paymentsysteminjava.repository.OsonRepository;
import com.example.paymentsysteminjava.repository.TransactionRepository;
import com.example.paymentsysteminjava.servise.gateway.PaymeTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CheckTransactionService {
    private final OsonRepository osonRepository;
    private final MerchantRepository merchantRepository;
    private final PaymeTransactionService paymeTransactionService;
    private final TransactionRepository transactionRepository;


    public BaseAgentResponse check(DefaultAgentRequest defaultAgentRequest,
                                   AgentEntity agentEntity) {
        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setTransactionState(TransactionState.CREATED.getState());
        transactionEntity.setTransactionAccount(defaultAgentRequest.getAccount());
        transactionEntity.setTransactionAmountFromAgent(defaultAgentRequest.getAmount());
        transactionEntity.setTransactionAmountToMerchant(getMerchantAmount(defaultAgentRequest.getAmount(), agentEntity));
        transactionRepository.save(transactionEntity);

        OsonServiceEntity osonServiceEntity = osonRepository.getById(defaultAgentRequest.getServiceId());
        MerchantServiceEntity merchantServiceEntity = osonServiceEntity.getMerchantServiceEntity();
        MerchantEntity merchantEntity = merchantServiceEntity.getMerchantEntity();


        TransactionEntity transaction = requestToMerchant(
                merchantServiceEntity,
                merchantEntity,
                transactionEntity);

        transactionRepository.save(transaction);

        return BaseCheckResponse.response(
                agentEntity,
                merchantEntity,
                merchantServiceEntity,
                transactionEntity
        );
    }


    private TransactionEntity requestToMerchant(
            MerchantServiceEntity merchantServiceEntity,
            MerchantEntity merchantEntity,
            TransactionEntity transactionEntity) {
//        TransactionEntity transaction = new TransactionEntity();
        if (merchantEntity.getIsPayme()) {
            transactionEntity = paymeTransactionService.createTransaction(
                    transactionEntity,
                    merchantServiceEntity
            );
        } else if (merchantEntity.getIsYandex()) {
            //TODO
        } else if (merchantEntity.getIsUcell()) {
            //TODO
        }

        return transactionEntity;
    }


    private BigDecimal getMerchantAmount(BigDecimal amount, AgentEntity agentEntity) {
//        return amount.subtract(amount.multiply(BigDecimal.valueOf(agentEntity.getCommissionFee())));
        return  null;
    }
}
