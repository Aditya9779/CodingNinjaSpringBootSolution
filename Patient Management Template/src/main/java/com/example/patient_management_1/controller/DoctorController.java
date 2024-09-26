package com.example.patient_management_1.controller;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.findDoctorById(id);
    }

    @PostMapping("/add/{patientId}")
    public Doctor addDoctor(@PathVariable Long patientId, @RequestBody Doctor doctor) {
        return doctorService.saveDoctorForPatient(patientId, doctor);
    }

    @PutMapping("/update")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
