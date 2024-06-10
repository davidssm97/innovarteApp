package com.application.rest.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pagos")
public class Payment {
    private Integer paymentId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentTipe;

    @ManyToOne
    @JoinColumn(name = "Id_estudiante",nullable = false)
    private Student student;
}
