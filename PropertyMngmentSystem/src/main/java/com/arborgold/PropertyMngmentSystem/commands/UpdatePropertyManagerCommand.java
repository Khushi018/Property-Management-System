package com.arborgold.PropertyMngmentSystem.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePropertyManagerCommand {
    private Long propertyManagerId;
    private String name;
    private String password;
}
