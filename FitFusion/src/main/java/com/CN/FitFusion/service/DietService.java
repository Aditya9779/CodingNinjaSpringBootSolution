package com.CN.FitFusion.service;

import com.CN.FitFusion.dto.DietDto;
import com.CN.FitFusion.exception.DietNotFoundException;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.repository.DietRepository;
import com.CN.FitFusion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietService {

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public void deleteDiet(Long id) {
        dietRepository.deleteById(id);
    }

    public List<Diet> getAllDiets() {
        return dietRepository.findAll();
    }

    public void createDiet(DietDto dietDto, Long userId) {
        Diet diet = Diet.builder().name(dietDto.getName()).description(dietDto.getDescription())
                .build();
        User user = userService.getUserById(userId);
        user.getDiets().add(diet);
        userRepository.save(user);
    }

    public Diet getDietById(Long id) {
        return dietRepository.findById(id).orElseThrow(() -> new DietNotFoundException("Diet not found with id: " + id));
    }

    public void updateDiet(DietDto dietDto, Long id) {
        Diet existingDiet = getDietById(id);
        existingDiet.setName(dietDto.getName());
        existingDiet.setDescription(dietDto.getDescription());
        dietRepository.save(existingDiet);
    }
}
