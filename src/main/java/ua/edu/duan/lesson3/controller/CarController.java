package ua.edu.duan.lesson3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.edu.duan.lesson3.dto.CarDto;
import ua.edu.duan.lesson3.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/cars")
    @ResponseBody
    public CarDto getCar(@RequestParam(required = true) String code) {
        return carService.getCar(code);
    }

    @GetMapping(path = "/cars")
    @ResponseBody
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @PostMapping(path = "/cars")
    @ResponseBody
    public String addCar(@RequestBody CarDto carDto) {
        return carService.addCar(carDto);
    }

    @PutMapping(path = "/cars")
    @ResponseBody
    public String editCar(@RequestParam String code, @RequestBody CarDto carDto) {
        return carService.editCar(code, carDto);
    }

    @DeleteMapping(path = "/cars")
    @ResponseBody
    public void deleteCar() {

    }

}
