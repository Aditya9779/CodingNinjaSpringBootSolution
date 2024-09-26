package com.example.patient_management_1.repository;

import com.example.patient_management_1.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}
