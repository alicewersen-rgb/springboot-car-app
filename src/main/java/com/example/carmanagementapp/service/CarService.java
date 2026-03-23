package com.example.carmanagementapp.service;

import com.example.carmanagementapp.dto.CarDTO;
import com.example.carmanagementapp.dto.CreateCarDTO;
import com.example.carmanagementapp.dto.UpdateCarDTO;
import com.example.carmanagementapp.entity.CarEntity;
import com.example.carmanagementapp.mapper.CarMapper;
import com.example.carmanagementapp.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    // Constructor
    public final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Create a new car
    public CarDTO createCar(CreateCarDTO createDTO) {
        CarEntity car = CarMapper.toEntity(createDTO);
        CarEntity saved = carRepository.save(car);
        return CarMapper.toDTO(saved);
    }

    // Get a list of all cars
    public List<CarDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get a car by its ID
    public CarDTO getCarById(Long id) {
        CarEntity car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return CarMapper.toDTO(car);
    }

    // Update an existing car
    public CarDTO updateCar(Long id, UpdateCarDTO updateDTO) {
        CarEntity car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        CarMapper.updateEntityFromDTO(car, updateDTO);
        CarEntity updated = carRepository.save(car);
        return CarMapper.toDTO(updated);
    }

    // Delete a car
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}