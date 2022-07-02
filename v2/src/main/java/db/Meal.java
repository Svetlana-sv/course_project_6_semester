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
public class Meal {
    @Id
    @Column(name = "meal_id")
    @GenericGenerator(name="kaygen" , strategy="increment")
    @GeneratedValue(generator="kaygen")
    private Long id;

    private String meal_name;
}
