package db.repo;

import db.Meal;
import db.UserProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProductsRepo extends JpaRepository<UserProducts, Long> {
    Optional<UserProducts> findById(Long id);
}
