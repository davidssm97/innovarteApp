package com.application.rest.controllers.dto;

import com.application.rest.entities.Enrollments;
import com.application.rest.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private Integer studentId;
    private String name;
    private LocalDate birthDate;
    private String email;
    private List<Enrollments> enrollmentsList = new ArrayList<>();
    private List<Payment>paymentList = new ArrayList<>();
}
