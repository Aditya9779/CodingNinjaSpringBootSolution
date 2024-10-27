package com.CN.StoreFinder.dto;

import lombok.Data;

import java.util.List;

@Data
public class MedicalStoreDto {
    private String name;
    private Long contact;
    private String area;
    private Long xCoordinate;
    private Long yCoordinate;
    private List<String> medicines;
}
