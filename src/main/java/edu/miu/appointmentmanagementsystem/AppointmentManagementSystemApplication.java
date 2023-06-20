package edu.miu.appointmentmanagementsystem;

import edu.miu.appointmentmanagementsystem.model.Appointment;
import edu.miu.appointmentmanagementsystem.model.Patient;
import edu.miu.appointmentmanagementsystem.service.AppointmentService;
import edu.miu.appointmentmanagementsystem.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Transactional
@RequiredArgsConstructor
@SpringBootApplication
public class AppointmentManagementSystemApplication implements ApplicationRunner {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    public static void main(String[] args) {
        SpringApplication.run(AppointmentManagementSystemApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        var patient1 = new Patient(null, "P101", "Bob", "Jones", LocalDate.of(1997, 12, 18), new ArrayList<>());
        var patient2 = new Patient(null, "EP117", "Anna", "Smith", LocalDate.of(1958, 03, 27),
                new ArrayList<>());

        var appointment1 = new Appointment(null, LocalDate.of(2023, 11, 15), LocalTime.of(18, 0, 0),
                "Dr Robin Plevin", null, patient2);
        var appointment2 = new Appointment(null,LocalDate.of(2023,4,30), LocalTime.of(14,30,0),
                null,"D4 Med Plaza",patient1);
        var appointment3 = new Appointment(null,LocalDate.of(2023,9,1), LocalTime.of(10,0,0),
                "Dr Tony Elliot","D4 Med Plaza",patient2);

        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);
        appointmentService.addAppointment(appointment3);

        patientService.addPatient(patient1);
        patientService.addPatient(patient2);





    }
}
