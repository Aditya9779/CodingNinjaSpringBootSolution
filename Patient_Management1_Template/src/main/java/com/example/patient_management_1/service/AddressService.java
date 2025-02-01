package com.example.patient_management_1.service;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }


    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }


    public boolean deleteAddress(Long id) {
        if(addressRepository.existsById(id)){
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
