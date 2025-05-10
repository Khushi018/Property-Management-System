package com.arborgold.PropertyMngmentSystem.handlers;


import com.arborgold.PropertyMngmentSystem.commands.AddPropertyManagerCommand;
import com.arborgold.PropertyMngmentSystem.commands.UpdatePropertyManagerCommand;
import com.arborgold.PropertyMngmentSystem.modal.PropertyManager;
import com.arborgold.PropertyMngmentSystem.repo.PropertyManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyManagerCommandHandler {

    private final PropertyManagerRepository propertyManagerRepository;

    public PropertyManager handle(AddPropertyManagerCommand command) {
        PropertyManager propertyManager = new PropertyManager(null, command.getName(), command.getPassword());
        return propertyManagerRepository.save(propertyManager);
    }

    public PropertyManager handle(UpdatePropertyManagerCommand command) {
        return propertyManagerRepository.findById(command.getPropertyManagerId()).map(existingManager -> {
            existingManager.setName(command.getName());
            existingManager.setPassword(command.getPassword());
            return propertyManagerRepository.save(existingManager);
        }).orElseThrow(() -> new RuntimeException("Property Manager not found"));
    }
}
