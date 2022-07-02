package db.repo;

import db.Product;
import db.User;
import db.UserParameters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepo extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
