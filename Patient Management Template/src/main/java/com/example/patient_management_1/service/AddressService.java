package com.example.patient_management_1.service;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.AddressRepository;
import com.example.patient_management_1.repository.PatientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PatientRespository patientRepository;

    // Find address by its ID
    public Address findAddressById(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.orElse(null);
    }

    // Save a new address for the given patient
    public Address saveAddressForPatient(Long patientId, Address address) {
        Patient patient = patientRepository.findById(patientId).get();
        Address savedAddress = addressRepository.save(address);
        patient.setAddress(address);
        patientRepository.save(patient);
        return savedAddress;
    }

    // Update the address
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    // Delete an address by its ID
    public void deleteAddress(Long id) {
        for(Patient patient : patientRepository.findAll()) {
            if (patient.getAddress()!=null && patient.getAddress().getId().equals(id)) {
                patient.setAddress(null);
                patientRepository.save(patient);
                addressRepository.deleteById(id);
            }
        }
    }
}
