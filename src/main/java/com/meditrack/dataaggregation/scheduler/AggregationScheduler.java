package com.dataaggregation.scheduler;

import com.dataaggregation.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AggregationScheduler {

    @Autowired
    private AggregationService service;

    @Scheduled(cron = "0 0 * * * *") // Runs every hour
    public void runAggregationTasks() {
        System.out.println("Running scheduled aggregation tasks...");

        service.getAppointmentsPerDoctor().forEach(System.out::println);
        service.getCommonConditionsBySpecialty().forEach(System.out::println);
    }
}
