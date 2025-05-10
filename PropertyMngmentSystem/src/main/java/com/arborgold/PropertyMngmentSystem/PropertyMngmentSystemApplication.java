package com.arborgold.PropertyMngmentSystem;

import com.arborgold.PropertyMngmentSystem.commands.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PropertyMngmentSystemApplication implements CommandLineRunner {

	@Autowired
	private CommandDispatcher dispatcher;

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
			System.out.println("6. Assign Property Manager to Property");
			System.out.println("7. Add Property Manager");  // <-- New Option
			System.out.println("8. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			if (choice == 7) {
				running = false;
			} else {
				dispatcher.dispatch(choice);
			}
		}
		scanner.close();
	}
}
