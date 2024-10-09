package ua.edu.duan.lesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.edu.duan.lesson3.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {

    List<Car> findByBrand(String brand);

    List<Car> findByDescription(String description);

    Optional<Car> findById(String id);

    @Query("SELECT c FROM Car c where c.name = :name")
    List<Car> findUsingQuery(String name);


    @Query(value = "SELECT * FROM cars where name = ?", nativeQuery = true)
    List<Car> findUsingNativeQuery(String name);

    @Modifying
    @Query("UPDATE Car c SET c.description =:description WHERE c.brand = :br")
    void changeDescription(@Param(value = "br") String brand, String description);
}

