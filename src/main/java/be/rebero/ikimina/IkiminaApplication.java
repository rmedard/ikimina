package be.rebero.ikimina;

import be.rebero.ikimina.model.Type.RoleType;
import be.rebero.ikimina.model.auth.Role;
import be.rebero.ikimina.model.auth.User;
import be.rebero.ikimina.repository.RolesRepository;
import be.rebero.ikimina.repository.UsersRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class IkiminaApplication {

	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(IkiminaApplication.class, args);
	}

	@Bean
	InitializingBean createInitData(){
		if (rolesRepository.findAll().isEmpty()){

			/* Default Roles */
			Role adminRole = new Role();
			adminRole.setName(RoleType.ADMIN);
			Role userRole = new Role();
			userRole.setName(RoleType.USER);
			Role accountantRole = new Role();
			accountantRole.setName(RoleType.ACCOUNTANT);

			/* User 1: Admin */
			User user = new User();
			user.setUsername("medard");
			Set<Role> userRoles = new HashSet<>();
			userRoles.add(adminRole);
			user.setRoles(userRoles);
			return () -> {
				rolesRepository.save(userRole);
				rolesRepository.save(accountantRole);
				usersRepository.save(user);
			};
		}
		return null;
	}
}
