package com.example.paymentsysteminjava.service.merchant_service;

import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.dto.crud.register.MerchantServiceDto;
import org.springframework.stereotype.Service;

@Service
public interface MerchantServiceService {
    AddResponseDto add(MerchantServiceDto merchantServiceDto);


}
