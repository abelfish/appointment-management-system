package edu.miu.appointmentmanagementsystem.repository;

import edu.miu.appointmentmanagementsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {


    List<Patient>  findAllByDateOfBirthBefore(LocalDate date);
}
