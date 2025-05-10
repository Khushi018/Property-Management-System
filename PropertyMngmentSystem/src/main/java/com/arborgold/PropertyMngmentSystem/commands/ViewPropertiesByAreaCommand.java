package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class ViewPropertiesByAreaCommand implements Command {
    private final PropertyManagementService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Area Name: ");
        String area = scanner.nextLine();
        List<Property> properties = service.findPropertiesByArea(area);
        properties.forEach(System.out::println);
    }
}
