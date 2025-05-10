package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class AssignPropertyManagerCommand implements Command {
    private final PropertyManagementService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Property ID to assign: ");
        Long propertyId = scanner.nextLong();
        System.out.print("Enter Property Manager ID to assign: ");
        Long managerId = scanner.nextLong();

        Property assignedProperty = service.assignPropertyManager(propertyId, managerId);
        System.out.println("Manager assigned to property: " + assignedProperty);
    }
}
