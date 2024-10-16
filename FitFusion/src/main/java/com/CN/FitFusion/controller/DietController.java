package com.CN.FitFusion.controller;

import com.CN.FitFusion.dto.DietDto;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diet")
public class DietController {

    @Autowired
    private DietService dietService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TRAINER')")
    public List<Diet> getAllDiets() {
        return dietService.getAllDiets();
    }

    @PostMapping("/create/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('TRAINER')")
    public void createDiet(@RequestBody DietDto dietDto, @PathVariable Long userId) {
        dietService.createDiet(dietDto, userId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TRAINER')")
    public Diet getDietById(@PathVariable Long id){
        return dietService.getDietById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TRAINER')")
    public void updateDiet(@RequestBody DietDto dietDto, @PathVariable Long id){
        dietService.updateDiet(dietDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TRAINER')")
    public void deleteDiet(@PathVariable Long id){
        dietService.deleteDiet(id);
    }

}
