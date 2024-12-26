package com.meditrack.dataaggregation.controller;

import com.meditrack.dataaggregation.model.entity.DoctorAggregation;
import com.meditrack.dataaggregation.model.entity.CommonConditionBySpecialty;
import com.meditrack.dataaggregation.model.entity.AppointmentFrequency;
import com.meditrack.dataaggregation.service.AggregationService;
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

    @GetMapping("/appointments-frequency")
    public List<AppointmentFrequency> getAppointmentFrequencyOverTime() {
        return service.getAppointmentFrequencyOverTime();
    }

    @GetMapping("/common_conditions")
    public List<CommonConditionBySpecialty> getCommonConditionsBySpecialty() {
        return service.getCommonConditionsBySpecialty();
    }
}
