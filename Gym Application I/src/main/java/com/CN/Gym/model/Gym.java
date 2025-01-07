package com.CN.Gym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gym")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Long contactNo;
    private String membershipPlans;
    private String facilities;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<User> members = new ArrayList<>();

}
