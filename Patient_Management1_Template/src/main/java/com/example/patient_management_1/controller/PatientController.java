package com.example.patient_management_1.controller;

import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.PatientRepository;
import com.example.patient_management_1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;
    @GetMapping("/{id}")
    public Patient getPatients(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping("/")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/")
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public boolean deletePatient(@PathVariable Long id) {
        return patientService.deletePatient(id);
    }
}

