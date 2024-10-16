package com.CN.FitFusion.controller;

import com.CN.FitFusion.dto.ExerciseDto;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TRAINER')")
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @PostMapping("/create/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('TRAINER')")
    public void createExercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Long userId) {
        exerciseService.createExercise(exerciseDto, userId);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('TRAINER')")
    @ResponseStatus(HttpStatus.OK)
    public Exercise getExerciseById(@PathVariable Long id){
        return exerciseService.getExerciseById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TRAINER')")
    public void updateExercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Long id){
        exerciseService.updateExercise(exerciseDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TRAINER')")
    public void deleteExercise(@PathVariable Long id){
        exerciseService.deleteExercise(id);
    }

}
