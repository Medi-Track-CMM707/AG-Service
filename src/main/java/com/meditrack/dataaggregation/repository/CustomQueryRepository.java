package com.meditrack.dataaggregation.repository;

import com.meditrack.dataaggregation.model.entity.DoctorAggregation;
import com.meditrack.dataaggregation.model.entity.CommonConditionBySpecialty;
import com.meditrack.dataaggregation.model.entity.AppointmentFrequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Date;

import java.util.List;

@Repository
public class CustomQueryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DoctorAggregation> getAppointmentsPerDoctor() {
        String sql = "SELECT d.id AS doctorId, d.\"name\" AS doctorName, COUNT(a.id) AS totalAppointments " +
                     "FROM reservation.doctor d " +
                     "LEFT JOIN reservation.appointment a ON d.id = a.doctor_id " +
                     "GROUP BY d.id, d.\"name\"";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            DoctorAggregation aggregation = new DoctorAggregation();
            aggregation.setDoctorId(rs.getLong("doctorId"));
            aggregation.setDoctorName(rs.getString("doctorName"));
            aggregation.setTotalAppointments(rs.getLong("totalAppointments"));
            return aggregation;
        });
    }
    public List<AppointmentFrequency> getAppointmentFrequencyOverTime() {
        String sql = "SELECT appointment_date, COUNT(*) AS totalAppointments " +
                    "FROM reservation.appointment " +
                    "GROUP BY appointment_date " +
                    "ORDER BY appointment_date";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AppointmentFrequency frequency = new AppointmentFrequency();
            frequency.setAppointmentDate(rs.getDate("appointment_date"));
            frequency.setTotalAppointments(rs.getLong("totalAppointments"));
            return frequency;
        });
    }

    public List<CommonConditionBySpecialty> getCommonConditionsBySpecialty() {
        String sql = "SELECT d.specialization AS specialty, mh.diagnosis AS condition, COUNT(mh.diagnosis) AS count " +
                    "FROM patient_record.medical_history mh " +
                    "JOIN reservation.doctor d ON mh.patient_id = d.id " +
                    "GROUP BY d.specialization, mh.diagnosis " +
                    "ORDER BY d.specialization, count DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CommonConditionBySpecialty report = new CommonConditionBySpecialty();
            report.setSpecialty(rs.getString("specialty"));
            report.setCondition(rs.getString("condition"));
            report.setCount(rs.getLong("count"));
            return report;
        });
    }


    public List<CommonConditionBySpecialty> getCommonConditionsBySpecialtyCardiology() {
        String sql = "SELECT d.specialization AS specialty, mh.diagnosis AS condition, COUNT(mh.diagnosis) AS count " +
                    "FROM patient_record.medical_history mh " +
                    "JOIN reservation.doctor d ON mh.patient_id = d.id " +
                    "WHERE d.specialization = 'Cardiology' " +
                    "GROUP BY d.specialization, mh.diagnosis " +
                    "ORDER BY d.specialization, count DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CommonConditionBySpecialty report = new CommonConditionBySpecialtyCardiology();
            report.setSpecialty(rs.getString("specialty"));
            report.setCondition(rs.getString("condition"));
            report.setCount(rs.getLong("count"));
            return report;
        });
    }



}
