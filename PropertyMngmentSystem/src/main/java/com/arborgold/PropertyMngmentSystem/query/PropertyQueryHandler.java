package com.arborgold.PropertyMngmentSystem.query;

import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.repo.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyQueryHandler {

    private final PropertyRepository propertyRepository;

    public List<Property> handle(GetAllPropertiesQuery query) {
        return propertyRepository.findAll();
    }

    public Optional<Property> handle(GetPropertyByIdQuery query) {
        return propertyRepository.findById(query.getPropertyId());
    }

    public List<Property> handle(FindPropertiesByAreaQuery query) {
        return propertyRepository.findByArea(query.getArea());
    }
    public List<Property> handle(GetOccupiedPropertiesQuery query) {
        return propertyRepository.findByOccupied(true);
    }
}