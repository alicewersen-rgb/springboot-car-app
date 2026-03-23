package com.example.carmanagementapp.repository;

import com.example.carmanagementapp.entity.CarEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends ListCrudRepository<CarEntity, Long> {
}