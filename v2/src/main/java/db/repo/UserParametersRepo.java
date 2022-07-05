package db.repo;

import db.User;
import db.UserParameters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserParametersRepo extends JpaRepository<UserParameters, Long> {
    Optional<UserParameters> findById(Long id);

    UserParameters findByUser(User user);
}
