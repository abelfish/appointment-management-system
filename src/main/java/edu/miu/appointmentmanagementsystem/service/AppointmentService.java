package edu.miu.appointmentmanagementsystem.service;

import edu.miu.appointmentmanagementsystem.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id) ;

    Appointment addAppointment(Appointment appointment);

    Appointment updateAppointment(Appointment appointment);

    void deleteAppointmentById(Long id);

    List<Appointment> getVIPAppointments();
    List<Appointment> getUpcomingAppointments();
}
