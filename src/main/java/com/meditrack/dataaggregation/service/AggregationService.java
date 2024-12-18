package com.dataaggregation.service;

import com.dataaggregation.model.DoctorAggregation;
import com.dataaggregation.model.SymptomReport;
import com.dataaggregation.repository.CustomQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregationService {

    @Autowired
    private CustomQueryRepository repository;

    public List<DoctorAggregation> getAppointmentsPerDoctor() {
        return repository.getAppointmentsPerDoctor();
    }

    public List<SymptomReport> getCommonConditionsBySpecialty() {
        return repository.getCommonConditionsBySpecialty();
    }
}
