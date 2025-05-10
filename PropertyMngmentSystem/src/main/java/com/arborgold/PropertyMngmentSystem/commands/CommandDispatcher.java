package com.arborgold.PropertyMngmentSystem.commands;

import com.arborgold.PropertyMngmentSystem.service.PropertyManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CommandDispatcher {

    private final Map<Integer, Command> commandMap;

    public CommandDispatcher(PropertyManagementService service) {
        commandMap = Map.of(
                1, new ViewAllPropertiesCommand(service),
                2, new AddPropertyManagerConsoleCommand(service),
                3, new UpdatePropertyConsoleCommand(service),
                4, new ViewPropertiesByAreaCommand(service),
                5, new ViewPropertyManagerSalaryCommand(service),
//                6, new AssignPropertyManagerCommand(service),
                7, new AddPropertyManagerConsoleCommand(service)   // <-- New Command Added
        );
    }

    public void dispatch(int commandKey) {
        Command command = commandMap.get(commandKey);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid Command!");
        }
    }
}
