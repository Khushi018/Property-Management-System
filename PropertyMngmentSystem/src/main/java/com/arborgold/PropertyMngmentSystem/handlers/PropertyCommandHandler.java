package com.arborgold.PropertyMngmentSystem.handlers;

import com.arborgold.PropertyMngmentSystem.commands.AddPropertyCommand;
import com.arborgold.PropertyMngmentSystem.commands.AssignPropertyManagerCommand;
import com.arborgold.PropertyMngmentSystem.commands.UpdatePropertyCommand;
import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.repo.PropertyManagerRepository;
import com.arborgold.PropertyMngmentSystem.repo.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyCommandHandler {

    private final PropertyRepository propertyRepository;
    private final PropertyManagerRepository propertyManagerRepository;

    public Property handle(AddPropertyCommand command) {
        Property property = new Property(null, command.getPropertyName(), command.getArea(),
                                         command.getRentalPrice(), command.getCurrentValue(),
                                         command.isOccupied(), null);
        return propertyRepository.save(property);
    }

    public Property handle(UpdatePropertyCommand command) {
        return propertyRepository.findById(command.getPropertyId()).map(existingProperty -> {
            existingProperty.setPropertyName(command.getPropertyName());
            existingProperty.setArea(command.getArea());
            existingProperty.setRentalPrice(command.getRentalPrice());
            existingProperty.setCurrentValue(command.getCurrentValue());
            existingProperty.setOccupied(command.isOccupied());
            existingProperty.setPropertyManagerId(command.getPropertyManagerId());
            return propertyRepository.save(existingProperty);
        }).orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public Property handle(AssignPropertyManagerCommand command) {
        return propertyRepository.findById(command.getPropertyId()).map(property -> {
            // Check if Property Manager Exists
            propertyManagerRepository.findById(command.getPropertyManagerId())
                    .orElseThrow(() -> new RuntimeException("Property Manager not found"));

            // Assign the manager to the property
            property.setPropertyManagerId(command.getPropertyManagerId());
            return propertyRepository.save(property);
        }).orElseThrow(() -> new RuntimeException("Property not found"));
    }
}
