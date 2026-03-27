package com.example.carmanagementapp.controller;

import com.example.carmanagementapp.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    void shouldReturnCarListView() throws Exception {
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(view().name("cars-list"))
                .andExpect(model().attributeExists("cars"));
    }

    @Test
    void shouldReturnCreateCarForm() throws Exception {
        mockMvc.perform(get("/cars/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("cars-create"))
                .andExpect(model().attributeExists("createCarDTO"));
    }
}