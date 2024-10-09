package ua.edu.duan.lesson3.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ua.edu.duan.lesson3.dto.CarDto;
import ua.edu.duan.lesson3.entity.Car;
import ua.edu.duan.lesson3.repository.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    private final EngineService engineService;

    public CarService(CarRepository carRepository, EngineService engineService) {
        this.carRepository = carRepository;
        this.engineService = engineService;
    }

    public CarDto getCar(String code) {
        Optional<Car> carOptional = carRepository.findById(code);
        return carOptional.map(this::convert).orElse(null);
    }

    public  List<CarDto> getCarByBrand(String brand) {
        List<Car> cars= carRepository.findUsingNativeQuery(brand);
        return cars.stream().map(this::convert).toList();
    }

    @Transactional
    public void changeDescription(String brand, String description) {
        carRepository.changeDescription(brand, description);
    }

    public List<CarDto> getCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(this::convert).collect(Collectors.toList());
    }

    public String addCar(CarDto carDto) {
        Car car = convert(carDto);
        carRepository.save(car);
        return "Car added";
    }

    @Transactional
    public String editCar(String carCode, CarDto carDto) {
        carRepository.findById(carCode).ifPresent(
                car -> {
                    car.setName(carDto.getName());
                    car.setCode(carDto.getCode());
                    car.setDescription(carDto.getDescription());
                }
        );
        return "Car have been edited";
    }

    private Car convert(CarDto carDto) {
        Car car = new Car();
        car.setName(carDto.getName());
        car.setCode(carDto.getCode());
        car.setDescription(carDto.getDescription());
        return car;
    }


    private CarDto convert(Car car){
        CarDto carDto = new CarDto();
        carDto.setName(car.getName());
        carDto.setCode(car.getCode());
        carDto.setDescription(car.getDescription());
        return carDto;
    }

    public String drive(String name) {

        return engineService.startEngine() + "\n"+ "Car "+ name +" is driving";
    }

}