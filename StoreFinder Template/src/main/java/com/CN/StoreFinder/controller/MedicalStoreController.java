package com.CN.StoreFinder.controller;

import com.CN.StoreFinder.dto.MedicalStoreDto;
import com.CN.StoreFinder.model.MedicalStore;
import com.CN.StoreFinder.service.MedicalStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class MedicalStoreController {

    @Autowired
    private MedicalStoreService medicalStoreService;

    @PostMapping("/create")
    public MedicalStore createMedicalStore(@RequestBody MedicalStoreDto medicalStoreDto) {
        return medicalStoreService.createMedicalStore(medicalStoreDto);
    }

    @GetMapping("/{id}")
    public MedicalStore getMedicalStoreById(@PathVariable Long id) {
        return medicalStoreService.getMedicalStoreById(id);
    }

    @GetMapping("/all")
    public List<MedicalStore> getAllMedicalStores() {
        return medicalStoreService.getAllMedicalStores();

    }

    @GetMapping("getNearestStores/{userId}/{distance}")
    public List<MedicalStore> getNearestMedicalStores(@PathVariable Long userId, @PathVariable Long distance){
        return medicalStoreService.getNearestMedicalStores(userId, distance);
    }

    @GetMapping("getStoresWithMedicine/{medicine}")
    public List<MedicalStore> getMedicalStoresHavingMedicine(@PathVariable String medicine){
        return medicalStoreService.getMedicalStoresHavingMedicine(medicine);
    }

    @PutMapping("/update/{id}")
    public MedicalStore updateMedicalStore(@PathVariable Long id, @RequestBody MedicalStoreDto medicalStoreDto) {
        return medicalStoreService.updateMedicalStore(id, medicalStoreDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicalStore(@PathVariable Long id) {
        medicalStoreService.deleteMedicalStore(id);
    }

}
