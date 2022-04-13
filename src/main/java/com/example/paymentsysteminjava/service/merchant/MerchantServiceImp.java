package com.example.paymentsysteminjava.service.merchant;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.dto.crud.AddResponseDto;
import com.example.paymentsysteminjava.dto.crud.register.MerchantRegisterDto;
import com.example.paymentsysteminjava.entity.MerchantEntity;
import com.example.paymentsysteminjava.entity.UserEntity;
import com.example.paymentsysteminjava.exception.LoginValidationException;
import com.example.paymentsysteminjava.repository.MerchantRepository;
import com.example.paymentsysteminjava.repository.UserRepository;
import com.example.paymentsysteminjava.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantServiceImp implements MerchantService {

    private final MerchantRepository merchantRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    @Override
    public AddResponseDto add(MerchantRegisterDto merchantRegisterDto) {

        Optional<MerchantEntity> optionalUser = merchantRepository.findByUsername(merchantRegisterDto.getUsername());
        if (optionalUser.isPresent())
            return new AddResponseDto(11, "username is already exists");

        MerchantEntity merchantEntity = modelMapper.map(merchantRegisterDto, MerchantEntity.class);
        merchantRepository.save(merchantEntity);

        return new AddResponseDto(1, "added");
    }




}
