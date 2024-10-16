package com.CN.FitFusion.dto;

import com.CN.FitFusion.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDto {

    private String name;
    private String description;
    private int sets;
    private int reps;

}
