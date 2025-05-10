package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.modal.PropertyManager;
import com.arborgold.PropertyMngmentSystem.repo.PropertyManagerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddPropertyManagerCommandHandler {

    private final PropertyManagerRepository propertyManagerRepository;

    public PropertyManager handle(AddPropertyManagerCommand command) {
        PropertyManager manager = new PropertyManager(null, command.getName(), command.getPassword());
        return propertyManagerRepository.save(manager);
    }
}
