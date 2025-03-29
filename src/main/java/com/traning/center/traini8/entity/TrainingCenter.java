package com.traning.center.traini8.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trainingCenter")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "CenterName Cannot be NULL")
    String centerName;

    @NotNull(message = "CenterCode Cannot be NULL")
    String centerCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NotNull(message = "Address Cannot be NULL")
    private Address address;

    Integer studentCapacity;

    @ElementCollection
    List<String> coursesOffered;

    Long createdOn;

    String contactEmail;

    @NotNull(message = "Phone Number Cannot be NULL")
    String contactPhone;
}
