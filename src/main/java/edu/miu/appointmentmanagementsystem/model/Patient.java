package edu.miu.appointmentmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @NotBlank(message = "Patient Number can't be empty or null")
    private String patientNumber;
    @NotBlank(message = "First Name can't be empty or null")
    private String firstName;
    @NotBlank(message = "Last Name can't be empty or null")
    private String lastName;
    @NotNull(message = "Date of birth can not be empty")
    private LocalDate dateOfBirth;

    @JsonIgnoreProperties("patient")
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();



}
