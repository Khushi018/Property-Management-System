package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class ViewPropertyManagerSalaryCommand implements Command {
    private final PropertyManagementService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Property Manager ID: ");
        Long managerId = scanner.nextLong();
        double salary = service.calculatePropertyManagerSalary(managerId);
        System.out.println("Property Manager's Salary: ₹" + salary);
    }
}
