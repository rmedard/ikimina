package be.rebero.ikimina.repository;

import be.rebero.ikimina.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
