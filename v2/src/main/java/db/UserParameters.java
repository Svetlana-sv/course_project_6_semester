package db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserParameters {
    @Id
    @Column(name = "parameter_id")
    @GenericGenerator(name="kaygen" , strategy="increment")
    @GeneratedValue(generator="kaygen")
    private Long id;

    private Integer height;
    private Float weight;
    private Integer age;

    private Integer calorie_norm;
    private Integer water_norm;
    private Integer carbohydrate_norm;
    private Integer protein_norm;
    private Integer fat_norm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCalorie_norm() {
        return calorie_norm;
    }

    public void setCalorie_norm(Integer calorie_norm) {
        this.calorie_norm = calorie_norm;
    }

    public Integer getWater_norm() {
        return water_norm;
    }

    public void setWater_norm(Integer water_norm) {
        this.water_norm = water_norm;
    }

    public Integer getCarbohydrate_norm() {
        return carbohydrate_norm;
    }

    public void setCarbohydrate_norm(Integer carbohydrate_norm) {
        this.carbohydrate_norm = carbohydrate_norm;
    }

    public Integer getProtein_norm() {
        return protein_norm;
    }

    public void setProtein_norm(Integer protein_norm) {
        this.protein_norm = protein_norm;
    }

    public Integer getFat_norm() {
        return fat_norm;
    }

    public void setFat_norm(Integer fat_norm) {
        this.fat_norm = fat_norm;
    }
}
