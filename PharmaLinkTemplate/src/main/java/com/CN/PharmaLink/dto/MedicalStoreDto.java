package com.CN.PharmaLink.dto;

import lombok.Data;
import java.util.List;

@Data
public class MedicalStoreDto {

    private Long id;
    private String name;
    private Long contact;
    private String area;
    private Long xCoordinate;
    private Long yCoordinate;
    private List<String> medicines;

}