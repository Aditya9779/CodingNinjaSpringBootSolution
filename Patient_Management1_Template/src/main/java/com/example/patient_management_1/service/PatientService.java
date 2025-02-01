package com.example.patient_management_1.service;

import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public boolean deletePatient(Long id) {
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
