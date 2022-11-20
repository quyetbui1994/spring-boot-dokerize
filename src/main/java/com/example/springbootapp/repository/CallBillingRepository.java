package com.example.springbootapp.repository;

import com.example.springbootapp.entity.CallBilling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CallBillingRepository extends JpaRepository<CallBilling, String> {
    Optional<CallBilling> findByUserName(String userName);
}
