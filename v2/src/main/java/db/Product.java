package db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id")
    @GenericGenerator(name="kaygen" , strategy="increment")
    @GeneratedValue(generator="kaygen")
    private Long id;

    private String name;
    private String description;

    private String measure_unit;

    private Integer calories;
    private Integer carbohydrates;
    private Integer proteins;
    private Integer fats;

    private String product_image;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private Integer count;
}
