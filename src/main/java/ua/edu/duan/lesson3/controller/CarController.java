package ua.edu.duan.lesson3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.edu.duan.lesson3.dto.CarDto;
import ua.edu.duan.lesson3.service.CarService;

import java.util.List;

@Controller
@Tag(name ="Car controller", description = "This controller contain CRUD operations for cars ")
public class CarController {


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/car")
    @Operation(summary = "return car", description = "Return car by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @ResponseBody
    public CarDto getCar(@RequestParam(required = true) String code) {
        return carService.getCar(code);
    }

    @GetMapping(path = "/car-by_brand")
    @ResponseBody
    public List<CarDto> getCarByBrand(@RequestParam String brand) {
        return carService.getCarByBrand(brand);
    }


    @PatchMapping(path = "/update-description")
    @ResponseBody
    public void getCarByBrand(@RequestParam String brand, @RequestParam String description) {
         carService.changeDescription(brand, description);
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
