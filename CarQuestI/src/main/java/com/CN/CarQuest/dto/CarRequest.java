package com.CN.CarQuest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {

    @NotBlank(message = "car name cannot be blank")
    private String name;
    private String brand;
    private String color;
    private Long modelYear;
    private Long price;
}
