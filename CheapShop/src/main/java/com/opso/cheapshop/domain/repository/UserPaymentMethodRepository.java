package com.opso.cheapshop.domain.repository;

import com.opso.cheapshop.domain.model.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethod, Long>{


}