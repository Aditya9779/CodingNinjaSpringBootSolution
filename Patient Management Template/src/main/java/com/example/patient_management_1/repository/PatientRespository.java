package com.example.patient_management_1.repository;

import com.example.patient_management_1.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRespository extends CrudRepository<Patient,Long> {
}
