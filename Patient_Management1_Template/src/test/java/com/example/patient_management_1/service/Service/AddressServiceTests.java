package com.example.patient_management_1.service.Service;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.repository.AddressRepository;
import com.example.patient_management_1.service.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class AddressServiceTests {

    @MockBean
    AddressRepository addressRepository;
    @Autowired
    AddressService addressService;

    @Test
    @DisplayName("Testing getAddress() method")
    public void shouldTestGetAddress() {
        Long id = 1L;
        Address address = new Address(id, "Tuss", "Qula", "Sansui", "211016");
        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(address));
        Address result = addressService.getAddress(id);
        Assertions.assertEquals(address, result);
        Assertions.assertEquals(address.getCity(), result.getCity());
    }
    @Test
    @DisplayName("Testing for the creatingAddress")
    public void shouldTestCreatingAddress(){
        Long id = 1L;
        Address address = new Address(id, "Tuss", "Qula", "Sansui", "211016");
        Mockito.when(addressRepository.save(address)).thenReturn(address);
        Address result=addressService.createAddress(address);
        Assertions.assertEquals(result.getState(),address.getState());
    }

}
