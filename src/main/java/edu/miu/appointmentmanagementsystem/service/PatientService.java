package edu.miu.appointmentmanagementsystem.service;

import edu.miu.appointmentmanagementsystem.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllElderlyPatients();

    Patient addPatient(Patient patient);
}
