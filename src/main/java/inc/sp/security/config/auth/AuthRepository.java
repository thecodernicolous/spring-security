package inc.sp.security.config.auth;

import java.security.Principal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import inc.sp.security.entities.User;

public interface AuthRepository extends JpaRepository<User,Long>{
	Optional<User> findByUserName(String username);
}
