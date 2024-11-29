package com.cn.homeControlSystem.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

    private String name;
    private String type;
    private String status;
    private Integer roomId;

}
