package com.arborgold.PropertyMngmentSystem.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPropertyManagerCommand {
    private String name;
    private String password;
}
