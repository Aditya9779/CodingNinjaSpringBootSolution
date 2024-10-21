package com.CodingNinjas.TaxEase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxRecordDto {

    private String userName;
    private String taxYear;
    private int Income;
    private int deductions;

}
