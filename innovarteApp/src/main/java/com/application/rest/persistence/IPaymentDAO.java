package com.application.rest.persistence;

import com.application.rest.entities.Payment;
import com.application.rest.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IPaymentDAO {
    List<Payment> findAll();

    Optional<Payment> findByid(Integer paymentId);

    void save(Payment payment);

    void deleteById(Integer paymentId);
}
