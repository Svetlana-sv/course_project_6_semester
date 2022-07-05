package db.repo;

import db.UserProducts;
import db.UserRecipes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRecipesRepo extends JpaRepository<UserRecipes, Long> {
    Optional<UserRecipes> findById(Long id);
}
