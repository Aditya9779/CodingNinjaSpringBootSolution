package com.CN.Gym.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String workoutName;
    private String description;
    private String difficultyLevel;
    private int duration;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
