package be.rebero.ikimina.repository;

import be.rebero.ikimina.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
}
