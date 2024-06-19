package com.application.rest.controllers.dto;

import com.application.rest.entities.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {

    private Integer paymentId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentTipe;
    private Student student1;

}
