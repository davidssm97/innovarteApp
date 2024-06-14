package com.application.rest.service;

import com.application.rest.entities.Payment;

import java.util.List;
import java.util.Optional;

public interface IPaymentService {
    List<Payment> findAll();

    Optional<Payment> findByid(Integer paymentId);

    void save(Payment payment);

    void deleteById(Integer paymentId);
}
