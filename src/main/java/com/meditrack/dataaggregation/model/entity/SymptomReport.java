package com.meditrack.dataaggregation.model.entity;

import lombok.Data;

@Data
public class SymptomReport {
    private String specialty;
    private String condition;
    private Long count;
}
