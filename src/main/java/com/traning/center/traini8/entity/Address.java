package com.traning.center.traini8.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull(message = "Cannot be NULL")
    String detailedAddress;

    @NotNull(message = "city Cannot be NULL")
    String city;

    @NotNull(message = "State Cannot be NULL")
    String state;

    @NotNull(message = "pincode Cannot be NULL")
    Integer pincode;

}
