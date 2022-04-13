package com.example.paymentsysteminjava.service.merchant;

import com.example.paymentsysteminjava.dto.crud.AddResponseDto;

import com.example.paymentsysteminjava.dto.crud.register.MerchantRegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface MerchantService {
    AddResponseDto add(MerchantRegisterDto merchantDto);
}
