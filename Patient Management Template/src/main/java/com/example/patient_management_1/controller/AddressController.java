package com.example.patient_management_1.controller;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.findAddressById(id);
    }

    @PostMapping("/add/{patientId}")
    public Address addAddress(@PathVariable Long patientId, @RequestBody Address address) {
        return addressService.saveAddressForPatient(patientId, address);
    }

    @PutMapping("/update")
    public Address updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
