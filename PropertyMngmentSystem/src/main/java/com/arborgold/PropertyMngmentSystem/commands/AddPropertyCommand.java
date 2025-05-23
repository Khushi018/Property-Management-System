package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPropertyCommand {
    private String propertyName;
    private String area;
    private double rentalPrice;
    private double currentValue;
    private boolean occupied;
    private String propertyManagerName;

}
