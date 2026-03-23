package com.example.carmanagementapp.mapper;

import com.example.carmanagementapp.entity.CarEntity;
import com.example.carmanagementapp.dto.CreateCarDTO;
import com.example.carmanagementapp.dto.UpdateCarDTO;
import com.example.carmanagementapp.dto.CarDTO;

public class CarMapper {

    // Convert CreateCarDTO → CarEntity
    public static CarEntity toEntity(CreateCarDTO dto) {
        CarEntity car = new CarEntity();
        car.setName(dto.getName());
        car.setBrand(dto.getBrand());
        car.setHorsepower(dto.getHorsepower());
        car.setManufactureDate(dto.getManufactureDate());
        car.setDescription(dto.getDescription());
        return car;
    }

    // Update an existing CarEntity from UpdateCarDTO
    public static void updateEntityFromDTO(CarEntity car, UpdateCarDTO dto) {
        car.setName(dto.getName());
        car.setBrand(dto.getBrand());
        car.setHorsepower(dto.getHorsepower());
        car.setManufactureDate(dto.getManufactureDate());
        car.setDescription(dto.getDescription());
    }

    // Convert CarEntity → CarDTO (for display)
    public static CarDTO toDTO(CarEntity car) {
        CarDTO dto = new CarDTO();
        dto.setId(car.getId());
        dto.setName(car.getName());
        dto.setBrand(car.getBrand());
        dto.setHorsepower(car.getHorsepower());
        return dto;
    }
}