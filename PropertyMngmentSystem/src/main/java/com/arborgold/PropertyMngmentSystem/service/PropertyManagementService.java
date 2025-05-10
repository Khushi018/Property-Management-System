package com.arborgold.PropertyMngmentSystem.service;

import com.arborgold.PropertyMngmentSystem.commands.*;
import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.modal.PropertyManager;
import com.arborgold.PropertyMngmentSystem.handlers.CommandHandlerRegistry;
import com.arborgold.PropertyMngmentSystem.handlers.QueryHandlerRegistry;
import com.arborgold.PropertyMngmentSystem.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyManagementService {

    private final CommandHandlerRegistry commandHandlerRegistry;
    private final QueryHandlerRegistry queryHandlerRegistry;

    @Autowired
    public PropertyManagementService(CommandHandlerRegistry commandHandlerRegistry, QueryHandlerRegistry queryHandlerRegistry) {
        this.commandHandlerRegistry = commandHandlerRegistry;
        this.queryHandlerRegistry = queryHandlerRegistry;
    }

    // Property-related operations
    public Property addProperty(AddPropertyCommand command) {
        return (Property) commandHandlerRegistry.execute(AddPropertyCommand.class, command);
    }
    // Property-related operations
    public PropertyManager addManager(AddPropertyManagerCommand command) {
        return (PropertyManager) commandHandlerRegistry.execute(AddPropertyManagerCommand.class, command);
    }




    public Property updateProperty(UpdatePropertyCommand command) {
        return (Property) commandHandlerRegistry.execute(UpdatePropertyCommand.class, command);
    }

    public List<Property> getAllProperties() {
        return (List<Property>) queryHandlerRegistry.execute(GetAllPropertiesQuery.class, new GetAllPropertiesQuery());
    }

    public Optional<Property> getPropertyById(Long propertyId) {
        return (Optional<Property>) queryHandlerRegistry.execute(GetPropertyByIdQuery.class, new GetPropertyByIdQuery(propertyId));
    }

    public List<Property> getOccupiedProperties() {
        return (List<Property>) queryHandlerRegistry.execute(GetOccupiedPropertiesQuery.class, new GetOccupiedPropertiesQuery());
    }

    // Property Manager-related operations
    public PropertyManager addPropertyManager(AddPropertyManagerCommand command) {
        return (PropertyManager) commandHandlerRegistry.execute(AddPropertyManagerCommand.class, command);
    }

    public PropertyManager updatePropertyManager(UpdatePropertyManagerCommand command) {
        return (PropertyManager) commandHandlerRegistry.execute(UpdatePropertyManagerCommand.class, command);
    }

    public List<PropertyManager> getAllPropertyManagers() {
        return (List<PropertyManager>) queryHandlerRegistry.execute(GetAllPropertyManagersQuery.class, new GetAllPropertyManagersQuery());
    }
//    public Property assignPropertyManager(Long propertyId, Long managerId) {
//        AssignPropertyManagerCommand command = new AssignPropertyManagerCommand(propertyId, managerId);
//        return (Property) commandHandlerRegistry.execute(AssignPropertyManagerCommand.class, command);
//    }

    public Optional<PropertyManager> getPropertyManagerById(Long propertyManagerId) {
        return (Optional<PropertyManager>) queryHandlerRegistry.execute(GetPropertyManagerByIdQuery.class, new GetPropertyManagerByIdQuery(propertyManagerId));
    }



    // Calculate Property Manager's Salary
    public double calculatePropertyManagerSalary(Long propertyManagerId) {
        return (double) queryHandlerRegistry.execute(CalculateSalaryQuery.class, new CalculateSalaryQuery(propertyManagerId));
    }

    // Find Properties by Area
    public List<Property> findPropertiesByArea(String area) {
        return (List<Property>) queryHandlerRegistry.execute(FindPropertiesByAreaQuery.class, new FindPropertiesByAreaQuery(area));
    }
}
