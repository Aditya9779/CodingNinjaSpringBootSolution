package com.example.patient_management_1.controller;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.repository.DoctorRepository;
import com.example.patient_management_1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return doctorService.getDoctor(id);
    }

    @PostMapping("/")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @PutMapping("/")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public boolean deleteDoctor(@PathVariable Long id) {
        return doctorService.deleteDoctor(id);
    }
}

