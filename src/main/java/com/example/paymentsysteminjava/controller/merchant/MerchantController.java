package com.example.paymentsysteminjava.controller.merchant;

import com.example.paymentsysteminjava.dto.UserRegisterDto;
import com.example.paymentsysteminjava.dto.crud.register.MerchantRegisterDto;
import com.example.paymentsysteminjava.service.merchant.MerchantService;
import com.example.paymentsysteminjava.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merchant/")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody MerchantRegisterDto merchantRegisterDto) {

        return ResponseEntity.ok().body(merchantService.add(merchantRegisterDto));
//        return ResponseEntity.status(HttpStatus.CONFLICT).body("Something is wrong");
    }

}
