package com.CN.CarQuest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarResponse {

    private String name;
    private String brand;
    private String color;
    private Long modelYear;
    private Long price;
    private List<String> reviews;

}
