package com.meditrack.dataaggregation.repository;

import com.meditrack.dataaggregation.model.entity.DoctorAggregation;
import com.meditrack.dataaggregation.model.entity.SymptomReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomQueryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DoctorAggregation> getAppointmentsPerDoctor() {
        String sql = "SELECT d.DoctorID AS doctorId, d.Name AS doctorName, COUNT(a.AppointmentID) AS totalAppointments " +
                     "FROM Doctor d JOIN Appointment a ON d.DoctorID = a.DoctorID " +
                     "GROUP BY d.DoctorID, d.Name";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            DoctorAggregation aggregation = new DoctorAggregation();
            aggregation.setDoctorId(rs.getLong("doctorId"));
            aggregation.setDoctorName(rs.getString("doctorName"));
            aggregation.setTotalAppointments(rs.getLong("totalAppointments"));
            return aggregation;
        });
    }

    public List<SymptomReport> getCommonConditionsBySpecialty() {
        String sql = "SELECT d.Specialization AS specialty, mh.Condition AS condition, COUNT(mh.Condition) AS count " +
                     "FROM MedicalHistory mh " +
                     "JOIN Doctor d ON d.DoctorID = mh.PatientID " +
                     "GROUP BY d.Specialization, mh.Condition";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            SymptomReport report = new SymptomReport();
            report.setSpecialty(rs.getString("specialty"));
            report.setCondition(rs.getString("condition"));
            report.setCount(rs.getLong("count"));
            return report;
        });
    }
}
