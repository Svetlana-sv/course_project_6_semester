package db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GenericGenerator(name="kaygen" , strategy="increment")
    @GeneratedValue(generator="kaygen")
    private Long id;

    private String login;
    private String email;
    private String password;

    private String first_name;
    private String patronymic;
    private String last_name;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Product> products;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Recipe> recipes;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserParameters parameters;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserRecipes> userRecipes;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserProducts> userProducts;
}
