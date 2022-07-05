package db.repo;

import db.Meal;
import db.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealRepo extends JpaRepository<Meal, Long> {
    Optional<Meal> findById(Long id);
}
