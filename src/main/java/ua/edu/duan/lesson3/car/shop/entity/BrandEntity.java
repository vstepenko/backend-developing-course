package ua.edu.duan.lesson3.car.shop.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;


    @Column(name = "brand_name")
    private String name;


    @OneToMany(mappedBy = "brand")
    private Set<CarEntity> cars = new HashSet<>();


    public long getId() {
        return id;
    }
    public void setId(long id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CarEntity> getCars() {
        return cars;
    }

    public void setCars(Set<CarEntity> cars) {
        this.cars = cars;
    }
}
