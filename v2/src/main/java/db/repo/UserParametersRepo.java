package db.repo;

import db.UserParameters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserParametersRepo extends JpaRepository<UserParameters, Long> {
    Optional<UserParameters> findById(Long id);
}
