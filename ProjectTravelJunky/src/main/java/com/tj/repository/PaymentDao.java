package com.tj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tj.model.PaymentDetails;

public interface PaymentDao extends JpaRepository<PaymentDetails, Integer> {

}
