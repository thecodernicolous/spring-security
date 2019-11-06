package inc.sp.security.config.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import inc.sp.security.entities.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	AuthRepository auth;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = auth.findByUserName(username);
		user.orElseThrow(()-> new UsernameNotFoundException("User name  "+username+"  not found"));
		return user.map(AppUserDetails::new).get();
	}

}
