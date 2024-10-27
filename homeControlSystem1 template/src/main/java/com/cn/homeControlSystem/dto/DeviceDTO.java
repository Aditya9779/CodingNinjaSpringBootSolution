package com.cn.homeControlSystem.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

//Add the lombok annotations a for auto generating constructors, getters and setters.
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

    private String name;
    private String type;
    private String status;
    private Integer roomId;

}
