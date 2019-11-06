package inc.sp.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import inc.sp.security.config.auth.UserDetailServiceImpl;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailServiceImpl userDetails;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/**")
			.authenticated()
			.antMatchers("/").permitAll()
			.and()
			.formLogin();
			
	}
	
	@Bean
	public PasswordEncoder getPassWordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
