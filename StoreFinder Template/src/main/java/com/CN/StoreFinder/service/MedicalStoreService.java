package com.CN.StoreFinder.service;

import com.CN.StoreFinder.dto.MedicalStoreDto;
import com.CN.StoreFinder.model.MedicalStore;
import com.CN.StoreFinder.model.User;
import com.CN.StoreFinder.repository.MedicalStoreRepository;
import com.CN.StoreFinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalStoreService {

    @Autowired
    private MedicalStoreRepository repository;

    @Autowired
    private UserRepository userRepository;

    public MedicalStore createMedicalStore(MedicalStoreDto medicalStoreDto) {
        MedicalStore store = new MedicalStore();
        store.setArea(medicalStoreDto.getArea());
        store.setName(medicalStoreDto.getName());
        store.setContact(medicalStoreDto.getContact());
        store.setMedicines(medicalStoreDto.getMedicines());
        store.setXCoordinate(medicalStoreDto.getXCoordinate());
        store.setYCoordinate(medicalStoreDto.getYCoordinate());
        return repository.save(store);
    }

    public MedicalStore getMedicalStoreById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Medical Store not found with id: " + id));
    }

    public List<MedicalStore> getAllMedicalStores() {
        return repository.findAll();
    }

    public MedicalStore updateMedicalStore(Long id, MedicalStoreDto medicalStoreDto) {
        MedicalStore existingStore = getMedicalStoreById(id);
        existingStore.setArea(medicalStoreDto.getArea());
        existingStore.setName(medicalStoreDto.getName());
        existingStore.setContact(medicalStoreDto.getContact());
        existingStore.setMedicines(medicalStoreDto.getMedicines());
        existingStore.setXCoordinate(medicalStoreDto.getXCoordinate());
        existingStore.setYCoordinate(medicalStoreDto.getYCoordinate());
        return repository.save(existingStore);
    }

    public void deleteMedicalStore(Long id) {
        repository.deleteById(id);
    }

    public long calculateDistance(Long userId, MedicalStore store){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println(user.getXCoordinate() + " " +user.getYCoordinate() + " " + store.getYCoordinate() + " " + store.getXCoordinate());

        return (long) Math.sqrt((Math.abs(user.getXCoordinate() - store.getXCoordinate()) *
                Math.abs(user.getXCoordinate() - store.getXCoordinate())) +
                (Math.abs(user.getYCoordinate() - store.getYCoordinate()) *
                        Math.abs(user.getYCoordinate() - store.getYCoordinate())));
    }

    public List<MedicalStore> getNearestMedicalStores(Long userId, Long distance) {
        return getAllMedicalStores().stream().filter(store -> calculateDistance(userId, store) <= distance).collect(Collectors.toList());
    }

    public List<MedicalStore> getMedicalStoresHavingMedicine(String medicine) {
        return getAllMedicalStores().stream().filter(store -> store.getMedicines().contains(medicine)).collect(Collectors.toList());
    }
}
