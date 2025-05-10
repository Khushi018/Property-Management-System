package com.arborgold.PropertyMngmentSystem.handlers;

import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.modal.PropertyManager;
import com.arborgold.PropertyMngmentSystem.query.CalculateSalaryQuery;
import com.arborgold.PropertyMngmentSystem.query.GetAllPropertyManagersQuery;
import com.arborgold.PropertyMngmentSystem.query.GetPropertyManagerByIdQuery;
import com.arborgold.PropertyMngmentSystem.repo.PropertyManagerRepository;
import com.arborgold.PropertyMngmentSystem.repo.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyManagerQueryHandler {

    private final PropertyManagerRepository propertyManagerRepository;

    private final PropertyRepository propertyRepository;
    public List<PropertyManager> handle(GetAllPropertyManagersQuery query) {
        return propertyManagerRepository.findAll();
    }

    public Optional<PropertyManager> handle(GetPropertyManagerByIdQuery query) {
        return propertyManagerRepository.findById(query.getPropertyManagerId());
    }
    public double handle(CalculateSalaryQuery query) {
        List<Property> properties = propertyRepository.findAll();
        double totalRentalIncome = properties.stream()
                .filter(property -> property.getPropertyManagerId() != null
                        && property.getPropertyManagerId().equals(query.getPropertyManagerId()))
                .mapToDouble(Property::getRentalPrice)
                .sum();

        return totalRentalIncome * 0.1; // 10% of total rental income
    }
}
