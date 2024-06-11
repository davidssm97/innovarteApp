package com.application.rest.entities;


import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer paymentId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentTipe;

    @ManyToOne
    @JoinColumn(name = "Id_estudiante",nullable = false)
    private Student student;
}
