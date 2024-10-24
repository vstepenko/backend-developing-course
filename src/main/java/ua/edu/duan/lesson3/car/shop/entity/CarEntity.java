package ua.edu.duan.lesson3.car.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "car_name")
    private String name;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;


    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private MainAdverticement mainAdvertisement;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cur_customer",
            joinColumns = @JoinColumn(name = "id_car"),
            inverseJoinColumns = @JoinColumn(name = "id_customer")
    )
    private Set<CustomerEntity> castomers = new HashSet<>();

    public Set<CustomerEntity> getCastomers() {
        return castomers;
    }

    public void setCastomers(Set<CustomerEntity> cstomers) {
        this.castomers = cstomers;
    }

    public MainAdverticement getMainAdvertisement() {
        return mainAdvertisement;
    }

    public void setMainAdvertisement(MainAdverticement mainAdvertisement) {
        this.mainAdvertisement = mainAdvertisement;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
