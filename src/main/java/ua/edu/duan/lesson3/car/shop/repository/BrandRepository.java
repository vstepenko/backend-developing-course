package ua.edu.duan.lesson3.car.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.edu.duan.lesson3.car.shop.entity.BrandEntity;

import java.util.List;

public interface BrandRepository extends JpaRepository<BrandEntity,Long> {

    @Query("SELECT DISTINCT be from BrandEntity be LEFT JOIN FETCH be.cars c LEFT JOIN FETCH  c.castomers LEFT JOIN FETCH c.mainAdvertisement")
    List<BrandEntity> getAllBrandsInSingleQuery();

}
