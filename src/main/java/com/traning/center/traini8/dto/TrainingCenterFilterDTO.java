package com.traning.center.traini8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenterFilterDTO {

    private String centerName;
    private String centerCode;
    private String city;
    private String state;
    private Integer studentCapacity;
    private String contactEmail;
    private String contactPhone;
}
