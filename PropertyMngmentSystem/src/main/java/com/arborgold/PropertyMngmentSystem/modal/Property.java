package com.arborgold.PropertyMngmentSystem.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull
    private String propertyName;
    @NotNull
    private String area;
    @NotNull
    private double rentalPrice;
    @NotNull
    private double currentValue;
    private boolean occupied;
    private Long propertyManagerId;
}