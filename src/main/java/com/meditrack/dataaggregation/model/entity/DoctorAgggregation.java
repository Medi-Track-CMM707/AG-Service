package com.dataaggregation.model.entity;

import lombok.Data;

@Data
public class DoctorAggregation {
    private Long doctorId;
    private String doctorName;
    private Long totalAppointments;
}
