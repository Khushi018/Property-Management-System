package com.arborgold.PropertyMngmentSystem.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPropertyByIdQuery {
    private Long propertyId;
}