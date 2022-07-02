package db.repo;

import db.Product;
import db.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipesRepo extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findById(Long id);
}
