package com.traning.center.traini8.dto;

import com.traning.center.traini8.entity.Address;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenterRequestDTO {

    @NotNull(message = "CenterName Cannot be NULL")
    @Size(max = 40, message = "CenterName must be less than 40 characters")
    private String centerName;

    @NotNull(message = "CenterCode Cannot be NULL")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "CenterCode must be exactly 12 alphanumeric characters")
    private String centerCode;

    @NotNull(message = "Address Cannot be NULL")
    private Address address;

    private Integer studentCapacity;

    private List<String> coursesOffered;

    private Long createdOn; // This should be set by the system, not provided by the user

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotNull(message = "Phone Number Cannot be NULL")
    @Pattern(regexp = "^\\d{10,15}$", message = "Phone number must be between 10 to 15 digits")    private String contactPhone;
}


