package com.meditrack.dataaggregation.service;

import com.meditrack.dataaggregation.model.entity.DoctorAggregation;
import com.meditrack.dataaggregation.model.entity.SymptomReport;
import com.meditrack.dataaggregation.repository.CustomQueryRepository;
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
