package com.arborgold.PropertyMngmentSystem.handlers;

import com.arborgold.PropertyMngmentSystem.commands.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class CommandHandlerRegistry {

    private final Map<Class<?>, Object> handlerMap = new HashMap<>();

    public CommandHandlerRegistry(PropertyCommandHandler propertyCommandHandler, PropertyManagerCommandHandler propertyManagerCommandHandler) {
        // Registering property-related handlers
        handlerMap.put(AddPropertyCommand.class, propertyCommandHandler);
        handlerMap.put(UpdatePropertyCommand.class, propertyCommandHandler);
        handlerMap.put(AssignPropertyManagerCommand.class, propertyCommandHandler);

        // Registering property manager handlers
        handlerMap.put(AddPropertyManagerCommand.class, propertyManagerCommandHandler);
        handlerMap.put(UpdatePropertyManagerCommand.class, propertyManagerCommandHandler);
    }

    public <T> Object execute(Class<T> commandClass, T command) {
        Object handler = handlerMap.get(commandClass);
        if (handler != null) {
            try {
                return handler.getClass().getMethod("handle", commandClass).invoke(handler, command);
            } catch (Exception e) {
                throw new RuntimeException("Handler execution failed", e);
            }
        }
        throw new IllegalArgumentException("No handler found for command " + commandClass);
    }
}
