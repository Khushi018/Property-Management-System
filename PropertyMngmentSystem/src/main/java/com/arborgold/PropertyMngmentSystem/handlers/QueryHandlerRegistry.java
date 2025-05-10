package com.arborgold.PropertyMngmentSystem.handlers;

import com.arborgold.PropertyMngmentSystem.query.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QueryHandlerRegistry {

    private final Map<Class<?>, Object> handlerMap = new HashMap<>();

    public QueryHandlerRegistry(PropertyQueryHandler propertyQueryHandler) {
        // Register property handlers
        handlerMap.put(GetAllPropertiesQuery.class, propertyQueryHandler);
        handlerMap.put(GetPropertyByIdQuery.class, propertyQueryHandler);
        handlerMap.put(GetOccupiedPropertiesQuery.class, propertyQueryHandler);
        handlerMap.put(FindPropertiesByAreaQuery.class, propertyQueryHandler);

    }

    public <T> Object execute(Class<T> queryClass, T query) {
        Object handler = handlerMap.get(queryClass);
        if (handler != null) {
            try {
                return handler.getClass().getMethod("handle", queryClass).invoke(handler, query);
            } catch (Exception e) {
                throw new RuntimeException("Handler execution failed", e);
            }
        }
        throw new IllegalArgumentException("No handler found for query " + queryClass);
    }
}
