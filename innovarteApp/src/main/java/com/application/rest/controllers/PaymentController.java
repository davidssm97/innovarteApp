package com.application.rest.controllers;

import com.application.rest.controllers.dto.PaymentDto;
import com.application.rest.entities.Payment;
import com.application.rest.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/find/{paymentId}")
    public ResponseEntity<?> findById(@PathVariable Integer paymentId) {
        Optional<Payment> paymentOptional = paymentService.findByid(paymentId);

        if (paymentOptional.isPresent()) {
            Payment payment = paymentOptional.get();

            PaymentDto paymentDto = PaymentDto.builder()
                    .paymentId(payment.getPaymentId())
                    .amount(payment.getAmount())
                    .paymentDate(payment.getPaymentDate())
                    .paymentTipe(payment.getPaymentTipe())
                    .student1(payment.getStudent1())
                    .build();

            return ResponseEntity.ok(paymentDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PaymentDto> paymentList = paymentService.findAll()
                .stream()
                .map(payment -> PaymentDto.builder()
                        .paymentId(payment.getPaymentId())
                        .amount(payment.getAmount())
                        .paymentDate(payment.getPaymentDate())
                        .paymentTipe(payment.getPaymentTipe())
                        .student1(payment.getStudent1())
                        .build())
                .toList();
        return ResponseEntity.ok(paymentList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PaymentDto paymentDto) throws URISyntaxException {

        if (paymentDto.getAmount() == null || paymentDto.getPaymentDate() == null || paymentDto.getPaymentTipe() == null || paymentDto.getStudent1() == null) {
            return ResponseEntity.badRequest().build();
        }

        paymentService.save(Payment.builder()
                .amount(paymentDto.getAmount())
                .paymentDate(paymentDto.getPaymentDate())
                .paymentTipe(paymentDto.getPaymentTipe())
                .student1(paymentDto.getStudent1())
                .build());

        return ResponseEntity.created(new URI("/api/payment/save")).build();
    }

    @PutMapping("/update/{paymentId}")
    public ResponseEntity<?> updatePayment(@PathVariable Integer paymentId, @RequestBody PaymentDto paymentDto) {
        Optional<Payment> paymentOptional = paymentService.findByid(paymentId);

        if (paymentOptional.isPresent()) {
            Payment payment = paymentOptional.get();
            payment.setAmount(paymentDto.getAmount());
            payment.setPaymentDate(paymentDto.getPaymentDate());
            payment.setPaymentTipe(paymentDto.getPaymentTipe());
            payment.setStudent1(paymentDto.getStudent1());
            paymentService.save(payment);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity<?> deleteById(@PathVariable Integer paymentId) {
        if (paymentId != null) {
            paymentService.deleteById(paymentId);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}

