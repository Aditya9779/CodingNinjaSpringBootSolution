package EdTech.User.repository;

import EdTech.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    Optional<User> findByEmail(String email);

    User findByUsername(String username);
}
