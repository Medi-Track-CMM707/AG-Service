package com.meditrack.dataaggregation.model.entity;
import java.sql.Date;
import lombok.Data;

@Data
public class AppointmentFrequency {
    private Date appointmentDate;
    private Long totalAppointments;

    // Getters and Setters
}
