package com.example.carmanagementapp.service;

import com.example.carmanagementapp.dto.CarDTO;
import com.example.carmanagementapp.dto.CreateCarDTO;
import com.example.carmanagementapp.entity.CarEntity;
import com.example.carmanagementapp.repository.CarRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarServiceTest {

    private final CarRepository carRepository = mock(CarRepository.class);
    private final CarService carService = new CarService(carRepository);

    @Test
    void shouldCreateCar() {
        CreateCarDTO dto = new CreateCarDTO();
        dto.setName("Test Car");
        dto.setBrand("Volvo");
        dto.setHorsepower(150);

        CarEntity savedEntity = new CarEntity();
        savedEntity.setName("Test Car");
        savedEntity.setBrand("Volvo");
        savedEntity.setHorsepower(150);

        when(carRepository.save(any(CarEntity.class))).thenReturn(savedEntity);

        CarDTO result = carService.createCar(dto);

        assertEquals("Test Car", result.getName());
        assertEquals("Volvo", result.getBrand());
    }

    @Test
    void shouldReturnAllCars() {
        CarEntity car = new CarEntity();
        car.setName("BMW");

        when(carRepository.findAll()).thenReturn(List.of(car));

        List<CarDTO> result = carService.getAllCars();

        assertEquals(1, result.size());
    }
}