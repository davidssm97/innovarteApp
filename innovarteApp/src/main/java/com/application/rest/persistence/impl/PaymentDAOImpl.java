package com.application.rest.persistence.impl;

import com.application.rest.entities.Payment;
import com.application.rest.persistence.IPaymentDAO;
import com.application.rest.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PaymentDAOImpl implements IPaymentDAO {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> findAll() {
        return (List<Payment>) paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findByid(Integer paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void deleteById(Integer paymentId) {
        paymentRepository.deleteById(paymentId);

    }
}
