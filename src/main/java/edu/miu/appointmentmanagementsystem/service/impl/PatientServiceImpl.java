package edu.miu.appointmentmanagementsystem.service.impl;

import edu.miu.appointmentmanagementsystem.model.Patient;
import edu.miu.appointmentmanagementsystem.repository.PatientRepository;
import edu.miu.appointmentmanagementsystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;
    @Override
    public List<Patient> getAllElderlyPatients() {
        var date65YearsFromNow = LocalDate.now().minusYears(65);
        return patientRepository.findAllByDateOfBirthBefore(date65YearsFromNow);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
