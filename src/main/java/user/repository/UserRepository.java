package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.domain.Id;
import user.domain.Password;
import user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Id> {

    Optional<User> findByPassword(Password password);
}
