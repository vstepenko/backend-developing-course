package ua.edu.duan.lesson3.car.shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.duan.lesson3.car.shop.entity.BrandEntity;
import ua.edu.duan.lesson3.car.shop.repository.BrandRepository;

import java.util.List;

@RestController
@RequestMapping(value = "car-shop")
public class CarShopController {



    @Autowired
    private BrandRepository brandRepository;

    @GetMapping(value = "/brands")
    public List<BrandEntity> getBrands() {
        return brandRepository.getAllBrandsInSingleQuery();
    }

}
