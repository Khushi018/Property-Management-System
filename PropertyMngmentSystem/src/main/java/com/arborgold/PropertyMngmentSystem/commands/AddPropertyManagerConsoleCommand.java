package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.modal.PropertyManager;
import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class AddPropertyManagerConsoleCommand implements Command {
    private final PropertyManagementService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Manager Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Manager Password: ");
        String password = scanner.nextLine();

        PropertyManager propertyManager = service.addPropertyManager(
                new AddPropertyManagerCommand(name, password)
        );
        System.out.println("Property Manager added: " + propertyManager);
    }
}
