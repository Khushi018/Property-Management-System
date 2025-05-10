package com.arborgold.PropertyMngmentSystem.repo;


import com.arborgold.PropertyMngmentSystem.modal.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository  extends JpaRepository<Property, Long> {
    List<Property> findAll();
    Optional<Property> findById(Long id);
    List<Property> findByArea(String area);
    List<Property> findByOccupied(boolean occupied);
    Property save(Property property);
//    void delete(Long id);
}