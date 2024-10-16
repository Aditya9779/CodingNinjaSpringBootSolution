package com.CN.FitFusion.service;

import com.CN.FitFusion.dto.ExerciseDto;
import com.CN.FitFusion.exception.ExerciseNotFoundException;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.repository.ExerciseRepository;
import com.CN.FitFusion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public void createExercise(ExerciseDto exerciseDto, Long userId) {
        Exercise exercise = Exercise.builder()
                .name(exerciseDto.getName())
                .description(exerciseDto.getDescription())
                .sets(exerciseDto.getSets())
                .reps(exerciseDto.getReps())
                .build();
        User user = userService.getUserById(userId);
        user.getExerciseList().add(exercise);
        exerciseRepository.save(exercise);
    }

    public Exercise getExerciseById(Long id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise not found with id: " + id));
    }

    public void updateExercise(ExerciseDto exerciseDto, Long id) {
        Exercise existingExercise = getExerciseById(id);
        existingExercise.setName(exerciseDto.getName());
        existingExercise.setDescription(exerciseDto.getDescription());
        existingExercise.setSets(exerciseDto.getSets());
        existingExercise.setReps(exerciseDto.getReps());
        exerciseRepository.save(existingExercise);
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

}
