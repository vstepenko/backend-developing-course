package ua.edu.duan.lesson3.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class CarDto {

    @JsonInclude(NON_NULL)
    @JsonAlias("car-code")
    @Schema(name="code", title = "Unique code of car")
    private String code;

    @JsonAlias("car-name")
    private String name;

    @JsonAlias("car-description")
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
