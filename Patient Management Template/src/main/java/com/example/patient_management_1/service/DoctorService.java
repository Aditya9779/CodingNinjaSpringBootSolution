package com.example.patient_management_1.service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.DoctorRepository;
import com.example.patient_management_1.repository.PatientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRespository patientRepository;

    // Find doctor by ID
    public Doctor findDoctorById(Long id) {

        Optional<Doctor> doctor=doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    // Save a doctor for a given patient
    public Doctor saveDoctorForPatient(Long patientId, Doctor doctor) {
        Patient patient = patientRepository.findById(patientId).get();
        Doctor savedDoctor = doctorRepository.save(doctor);
        patient.setDoctor(doctor);
        patientRepository.save(patient);
        return savedDoctor;
    }

    // Update a doctor
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Delete a doctor by ID
    public void deleteDoctor(Long id) {
        for(Patient patient : patientRepository.findAll()) {
            if (patient.getDoctor()!=null && patient.getDoctor().getId().equals(id)) {
                patient.setDoctor(null);
                patientRepository.save(patient);
                doctorRepository.deleteById(id);
            }
        }
    }
}
