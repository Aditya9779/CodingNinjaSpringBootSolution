package com.example.patient_management_1.service;

import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.PatientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRespository patientRepository;

    // Find patient by ID
    public Patient findPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.orElse(null); // Return patient if found, else null
    }

    // Save a new patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient); // Save and return the saved patient
    }

    // Update an existing patient
    public Patient updatePatient(Patient patient) {
        if (patientRepository.existsById(patient.getId())) {
            return patientRepository.save(patient); // Update if patient exists
        } else {
            return null; // Return null if patient doesn't exist
        }
    }

    // Delete a patient by ID
    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id); // Delete if patient exists
        }
    }
}
