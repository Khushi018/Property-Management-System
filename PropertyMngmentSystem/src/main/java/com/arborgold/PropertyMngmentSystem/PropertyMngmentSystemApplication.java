package com.arborgold.PropertyMngmentSystem;

import com.arborgold.PropertyMngmentSystem.commands.AddPropertyCommand;
import com.arborgold.PropertyMngmentSystem.commands.AddPropertyManagerCommand;
import com.arborgold.PropertyMngmentSystem.commands.UpdatePropertyCommand;
import com.arborgold.PropertyMngmentSystem.commands.UpdatePropertyManagerCommand;
import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.modal.PropertyManager;
import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PropertyMngmentSystemApplication implements CommandLineRunner {

	@Autowired
	private PropertyManagementService propertyManagementService;

	public static void main(String[] args) {
		SpringApplication.run(PropertyMngmentSystemApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("\n=== Property Management System ===");
			System.out.println("1. View All Properties");
			System.out.println("2. Add Property");
			System.out.println("3. Update Property");
			System.out.println("4. View Properties by Area");
			System.out.println("5. View Property Manager's Salary");
			System.out.println("6. Add Property Manager");
			System.out.println("7. Update Property Manager");
			System.out.println("8. Assign Property to Manager");
			System.out.println("9. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1 -> {
					List<Property> properties = propertyManagementService.getAllProperties();
					properties.forEach(System.out::println);
				}
				case 2 -> {
					System.out.print("Property Name: ");
					String name = scanner.nextLine();
					System.out.print("Area: ");
					String area = scanner.nextLine();
					System.out.print("Rental Price: ");
					double rentalPrice = scanner.nextDouble();
					System.out.print("Current Value: ");
					double currentValue = scanner.nextDouble();
					scanner.nextLine(); // Consume newline
					System.out.print("Occupied (true/false): ");
					boolean occupied = scanner.nextBoolean();
					scanner.nextLine();
					System.out.print("Property Manager Name: ");
					String managerName = scanner.nextLine();

					AddPropertyCommand command = new AddPropertyCommand(name, area, rentalPrice, currentValue, occupied, managerName);
					Property property = propertyManagementService.addProperty(command);
					System.out.println("Property added: " + property);
				}
				case 3 -> {
					System.out.print("Property ID: ");
					Long id = scanner.nextLong();
					scanner.nextLine();
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

					UpdatePropertyCommand updateCommand = new UpdatePropertyCommand(id, name, area, rentalPrice, currentValue, occupied, managerId);
					Property updatedProperty = propertyManagementService.updateProperty(updateCommand);
					System.out.println("Property updated: " + updatedProperty);
				}
				case 4 -> {
					System.out.print("Enter Area Name: ");
					String area = scanner.nextLine();
					List<Property> properties = propertyManagementService.findPropertiesByArea(area);
					properties.forEach(System.out::println);
				}
				case 5 -> {
					System.out.print("Enter Property Manager ID: ");
					Long managerId = scanner.nextLong();
					double salary = propertyManagementService.calculatePropertyManagerSalary(managerId);
					System.out.println("Property Manager's Salary: ₹" + salary);
				}
				case 6 -> {
					System.out.print("Property Manager Name: ");
					String name = scanner.nextLine();
					System.out.print("Password: ");
					String password = scanner.nextLine();

					AddPropertyManagerCommand addCommand = new AddPropertyManagerCommand(name, password);
					PropertyManager manager = propertyManagementService.addPropertyManager(addCommand);
					System.out.println("Property Manager added: " + manager);
				}
				case 7 -> {
					System.out.print("Property Manager ID: ");
					Long id = scanner.nextLong();
					scanner.nextLine();
					System.out.print("New Name: ");
					String name = scanner.nextLine();
					System.out.print("New Password: ");
					String password = scanner.nextLine();

					UpdatePropertyManagerCommand updateCommand = new UpdatePropertyManagerCommand(id, name, password);
					PropertyManager updatedManager = propertyManagementService.updatePropertyManager(updateCommand);
					System.out.println("Property Manager updated: " + updatedManager);
				}

				case 8 -> {
					System.out.print("Enter Property ID to assign: ");
					Long propertyId = scanner.nextLong();
					System.out.print("Enter Property Manager ID to assign: ");
					Long managerId = scanner.nextLong();

					Property assignedProperty = propertyManagementService.assignPropertyManager(propertyId, managerId);
					System.out.println("Manager assigned to property: " + assignedProperty);
				}

				case 9 -> {
					running = false;
					System.out.println("Exiting...");
				}

				default -> System.out.println("Invalid option. Please try again.");
			}
		}
		scanner.close();
	}
}
