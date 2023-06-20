package edu.miu.appointmentmanagementsystem.controller;


import edu.miu.appointmentmanagementsystem.model.Appointment;
import edu.miu.appointmentmanagementsystem.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amsweb/api/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllAppointments(){
        return new ResponseEntity<>(appointmentService.getAllAppointments(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(appointmentService.getAppointmentById(id), HttpStatus.OK
            );
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.addAppointment(appointment), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        try {
            appointment.setAppointmentId(id);
            return new ResponseEntity<>(appointmentService.updateAppointment(appointment),
                    HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/vip/list")
    public ResponseEntity<?> getVIPAppointments(){
        return new ResponseEntity<>(appointmentService.getVIPAppointments(), HttpStatus.OK
        );
    }
    @GetMapping("/upcoming/list")
    public ResponseEntity<?> getUpcomingAppointments(){
        return new ResponseEntity<>(appointmentService.getUpcomingAppointments(), HttpStatus.OK);
    }



}

