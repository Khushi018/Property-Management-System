package com.arborgold.PropertyMngmentSystem.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PropertyManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String password;
}