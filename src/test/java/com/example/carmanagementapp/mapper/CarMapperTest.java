package com.example.carmanagementapp.mapper;

import com.example.carmanagementapp.dto.CreateCarDTO;
import com.example.carmanagementapp.entity.CarEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarMapperTest {

    @Test
    void shouldMapCreateDTOToEntity() {
        CreateCarDTO dto = new CreateCarDTO();
        dto.setName("Audi");
        dto.setBrand("Audi");
        dto.setHorsepower(200);

        CarEntity entity = CarMapper.toEntity(dto);

        assertEquals("Audi", entity.getName());
        assertEquals(200, entity.getHorsepower());
    }
}