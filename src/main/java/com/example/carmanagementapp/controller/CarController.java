package com.example.carmanagementapp.controller;

import com.example.carmanagementapp.dto.CarDTO;
import com.example.carmanagementapp.dto.CreateCarDTO;
import com.example.carmanagementapp.dto.UpdateCarDTO;
import com.example.carmanagementapp.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    // Constructor
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // List all cars
    @GetMapping
    public String listCars(Model model) {
        List<CarDTO> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "cars-list"; // Thymeleaf template name
    }

    // Show form to create a new car
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("createCarDTO", new CreateCarDTO());
        return "cars-create"; // Thymeleaf template name
    }

    // Handle form submission for creating a car
    @PostMapping
    public String createCar(@Valid @ModelAttribute("createCarDTO") CreateCarDTO createCarDTO,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars-create"; // Show form again if validation fails
        }
        carService.createCar(createCarDTO);
        return "redirect:/cars"; // Redirect to list after successful creation
    }

    // Show form to edit a car
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        CarDTO carDTO = carService.getCarById(id);
        UpdateCarDTO updateCarDTO = new UpdateCarDTO();
        updateCarDTO.setName(carDTO.getName());
        updateCarDTO.setBrand(carDTO.getBrand());
        updateCarDTO.setHorsepower(carDTO.getHorsepower());
        updateCarDTO.setManufactureDate(carDTO.getManufactureDate());
        updateCarDTO.setDescription(carDTO.getDescription());

        model.addAttribute("updateCarDTO", updateCarDTO);
        model.addAttribute("carId", id);
        return "cars-update"; // Thymeleaf template name
    }

    // Handle form submission for updating a car
    @PostMapping("/edit/{id}")
    public String updateCar(@PathVariable Long id,
                            @Valid @ModelAttribute("updateCarDTO") UpdateCarDTO updateCarDTO,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("carId", id);
            return "cars-update"; // Show form again if validation fails
        }
        carService.updateCar(id, updateCarDTO);
        return "redirect:/cars"; // Redirect to list after successful update
    }

    // Delete a car
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "redirect:/cars"; // Redirect to list after deletion
    }
}