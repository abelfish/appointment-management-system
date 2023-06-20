package edu.miu.appointmentmanagementsystem.controller;


import edu.miu.appointmentmanagementsystem.model.Patient;
import edu.miu.appointmentmanagementsystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/amsweb/api/patient")
public class PatientController {


    private final PatientService patientService;
    @GetMapping("/elderly/list")
    public ResponseEntity<?> getElderlyPatients(){
        return new ResponseEntity<>(patientService.getAllElderlyPatients(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addNewPatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }
}
