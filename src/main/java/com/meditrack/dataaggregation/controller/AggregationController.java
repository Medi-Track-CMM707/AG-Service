package com.dataaggregation.controller;

import com.dataaggregation.model.DoctorAggregation;
import com.dataaggregation.model.SymptomReport;
import com.dataaggregation.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class AggregationController {

    @Autowired
    private AggregationService service;

    @GetMapping("/appointments-per-doctor")
    public List<DoctorAggregation> getAppointmentsPerDoctor() {
        return service.getAppointmentsPerDoctor();
    }

    @GetMapping("/common-conditions")
    public List<SymptomReport> getCommonConditionsBySpecialty() {
        return service.getCommonConditionsBySpecialty();
    }
}
