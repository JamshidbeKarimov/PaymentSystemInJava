package com.example.paymentsysteminjava.dto.crud.register;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantRegisterDto {
    private Long id;
    private String username;
    private String password;
    private String secretKey;
}
