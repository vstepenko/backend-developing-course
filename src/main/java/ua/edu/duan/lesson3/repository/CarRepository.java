package ua.edu.duan.lesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.lesson3.entity.Car;

public interface CarRepository extends JpaRepository<Car, String> {
}
