package com.application.rest.service.impl;

import com.application.rest.entities.Payment;
import com.application.rest.persistence.IPaymentDAO;
import com.application.rest.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private IPaymentDAO paymentDAO;

    @Override
    public List<Payment> findAll() {
        return paymentDAO.findAll();
    }

    @Override
    public Optional<Payment> findByid(Integer paymentId) {
        return paymentDAO.findByid(paymentId);
    }

    @Override
    public void save(Payment payment) {
        paymentDAO.save(payment);
    }

    @Override
    public void deleteById(Integer paymentId) {
        paymentDAO.deleteById(paymentId);
    }
}
