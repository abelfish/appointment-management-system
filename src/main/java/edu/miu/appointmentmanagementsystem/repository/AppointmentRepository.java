package edu.miu.appointmentmanagementsystem.repository;

import edu.miu.appointmentmanagementsystem.model.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    List<Appointment> findAllByAppointmentDateGreaterThanEqual(LocalDate date, Sort sort);
}
