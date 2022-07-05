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

    private String gender;

}
