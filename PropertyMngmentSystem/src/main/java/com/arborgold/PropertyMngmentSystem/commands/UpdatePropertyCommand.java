package com.arborgold.PropertyMngmentSystem.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePropertyCommand {
    private Long propertyId;
    private String propertyName;
    private String area;
    private double rentalPrice;
    private double currentValue;
    private boolean occupied;
    private Long propertyManagerId;
}