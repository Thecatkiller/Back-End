package com.opso.cheapshop.domain.service;

import com.opso.cheapshop.domain.model.UserPaymentMethod;

import org.springframework.http.ResponseEntity;

public interface UserPaymentMethodService {


    UserPaymentMethod getUserPaymentMethodById(Long userPaymentMethodId);

    UserPaymentMethod createUserPaymentMethod(UserPaymentMethod userPaymentMethod);

    UserPaymentMethod updateUserPaymentMethod(Long userPaymentMethodId, UserPaymentMethod userPaymentMethodDetails);

    ResponseEntity<?> deleteUserPaymentMethod(Long userPaymentMethodId);
}
