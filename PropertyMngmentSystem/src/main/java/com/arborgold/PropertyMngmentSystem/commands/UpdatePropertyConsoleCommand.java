package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class UpdatePropertyConsoleCommand implements Command {

    private final PropertyManagementService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== Update Property ===");
        System.out.print("Enter Property ID to Update: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // consume newline
        
        System.out.print("New Property Name: ");
        String name = scanner.nextLine();
        
        System.out.print("New Area: ");
        String area = scanner.nextLine();
        
        System.out.print("New Rental Price: ");
        double rentalPrice = scanner.nextDouble();
        
        System.out.print("New Current Value: ");
        double currentValue = scanner.nextDouble();
        
        System.out.print("Occupied (true/false): ");
        boolean occupied = scanner.nextBoolean();
        
        System.out.print("New Property Manager ID: ");
        Long managerId = scanner.nextLong();

        // Prepare the command DTO
        UpdatePropertyCommand command = new UpdatePropertyCommand(id, name, area, rentalPrice, currentValue, occupied, managerId);

        // Execute the update through the service
        Property updatedProperty = service.updateProperty(command);

        if (updatedProperty != null) {
            System.out.println("✅ Property Updated Successfully: " + updatedProperty);
        } else {
            System.out.println("❌ Property not found with ID: " + id);
        }
    }
}
