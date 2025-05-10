package com.arborgold.PropertyMngmentSystem.repo;

import com.arborgold.PropertyMngmentSystem.modal.PropertyManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PropertyManagerRepository extends JpaRepository<PropertyManager, Long> {
    List<PropertyManager> findAll();
    Optional<PropertyManager> findById(Long id);
    Optional<PropertyManager> findByNameAndPassword(String name, String password);
    PropertyManager save(PropertyManager propertyManager);
//    void delete(Long id);
}
