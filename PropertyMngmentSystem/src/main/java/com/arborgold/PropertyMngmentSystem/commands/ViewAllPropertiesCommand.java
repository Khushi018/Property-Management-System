package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ViewAllPropertiesCommand implements Command {
    private final PropertyManagementService service;

    @Override
    public void execute() {
        System.out.println("\n=== List of All Properties ===");
        List<Property> properties = service.getAllProperties();

        if (properties.isEmpty()) {
            System.out.println("No properties found.");
        } else {
            properties.forEach(property -> {
                System.out.println("--------------------------------------------------");
                System.out.println("Property ID       : " + property.getId());
                System.out.println("Property Name     : " + property.getPropertyName());
                System.out.println("Area              : " + property.getArea());
                System.out.println("Rental Price      : ₹" + property.getRentalPrice());
                System.out.println("Current Value     : ₹" + property.getCurrentValue());
                System.out.println("Occupied          : " + (property.isOccupied() ? "Yes" : "No"));
                System.out.println("Property Manager  : " + (property.getPropertyManagerId() != null ? property.getPropertyManagerId() : "Not Assigned"));
            });
        }
        System.out.println("--------------------------------------------------");
    }
}
