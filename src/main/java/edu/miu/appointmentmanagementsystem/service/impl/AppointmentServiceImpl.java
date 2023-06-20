package edu.miu.appointmentmanagementsystem.service.impl;

import edu.miu.appointmentmanagementsystem.model.Appointment;
import edu.miu.appointmentmanagementsystem.repository.AppointmentRepository;
import edu.miu.appointmentmanagementsystem.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {

        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Appointment not found"));
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {

        appointmentRepository.findById(appointment.getAppointmentId()).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getVIPAppointments() {
        var allAppointments = appointmentRepository.findAll();
        var dateof65YearsFromNow = LocalDate.now().minusYears(65);


        return allAppointments.stream().filter(appointment -> appointment.getPatient().getDateOfBirth().isBefore(dateof65YearsFromNow)).sorted(Comparator.comparing(Appointment::getAppointmentDate).thenComparing(Appointment::getAppointmentTime)).toList();
    }

    @Override
    public List<Appointment> getUpcomingAppointments() {
        return appointmentRepository.findAllByAppointmentDateGreaterThanEqual(LocalDate.now(),
                Sort.by("appointmentDate", "appointmentTime"));
    }
}
