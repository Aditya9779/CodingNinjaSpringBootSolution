package com.example.patient_management_1.controller;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {


    @Autowired
    private AddressService addressService;
    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Long id) {
        return addressService.getAddress(id);
    }

    @PostMapping("/")
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @PutMapping("/")
    public Address updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAddress(@PathVariable Long id) {
         return addressService.deleteAddress(id);
    }

}
