package com.CodingNinjas.LeaveXpress.dto;

import lombok.Data;

@Data
public class LeaveDto {
    private String type;
    private String startDate;
    private String endDate;
    private String description;
}
