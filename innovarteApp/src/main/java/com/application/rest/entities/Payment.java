package com.application.rest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "monto")
    private BigDecimal amount;
    @Column (name = "fecha_pago")
    private LocalDate paymentDate;
    @Column (name = "tipo_pago")
    private String paymentTipe;

    @ManyToOne
    @JoinColumn(name = "Id_estudiante",nullable = false)
    @JsonIgnore
    private Student student1;
}
