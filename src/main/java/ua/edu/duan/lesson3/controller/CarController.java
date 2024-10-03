package ua.edu.duan.lesson3.controller;

import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.edu.duan.lesson3.service.CarService;
import ua.edu.duanapi.api.CarControllerService;
import ua.edu.duanapi.api.dto.CarDto;

import java.util.List;

@Controller
@Tag(name ="Car controller", description = "This controller contain CRUD operations for cars ")
public class CarController implements CarControllerService {


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

    @Override
    public void addCar(ServerRequest serverRequest, ServerResponse serverResponse, CarDto carDto) {

    }

    @Override
    public void deleteCar(ServerRequest serverRequest, ServerResponse serverResponse) {

    }

    @Override
    public void editCar(ServerRequest serverRequest, ServerResponse serverResponse, CarDto carDto) {

    }

    @Override
    public void getCar(ServerRequest serverRequest, ServerResponse serverResponse) {

    }

    @Override
    public void getCars(ServerRequest serverRequest, ServerResponse serverResponse) {

    }
}
