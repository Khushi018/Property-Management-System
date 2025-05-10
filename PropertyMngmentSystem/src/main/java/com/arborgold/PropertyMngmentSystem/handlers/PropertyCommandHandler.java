import com.arborgold.PropertyMngmentSystem.commands.AssignPropertyManagerCommand;
import com.arborgold.PropertyMngmentSystem.modal.Property;
import com.arborgold.PropertyMngmentSystem.repo.PropertyManagerRepository;
import com.arborgold.PropertyMngmentSystem.repo.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyCommandHandler {

    private final PropertyRepository propertyRepository;
    private final PropertyManagerRepository propertyManagerRepository;

    public Property handle(AssignPropertyManagerCommand command) {
        // Fetch the Property
        Optional<Property> propertyOptional = propertyRepository.findById(command.getPropertyId());
        if (propertyOptional.isEmpty()) {
            throw new RuntimeException("Property with ID " + command.getPropertyId() + " not found.");
        }

        // Fetch the Property Manager
        boolean managerExists = propertyManagerRepository.existsById(command.getPropertyManagerId());
        if (!managerExists) {
            throw new RuntimeException("Property Manager with ID " + command.getPropertyManagerId() + " not found.");
        }

        // Assign the manager to the property
        Property property = propertyOptional.get();
        property.setPropertyManagerId(command.getPropertyManagerId());

        // Save changes
        Property updatedProperty = propertyRepository.save(property);
        System.out.println("Property Manager " + command.getPropertyManagerId() + " successfully assigned to Property " + command.getPropertyId());

        return updatedProperty;
    }
}
