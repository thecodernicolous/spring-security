package inc.sp.security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/")
	private String home() {
		return "hello";
	}
	

	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	@GetMapping("/user")
	private String user() {
		return "hello user";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	private String admin() {
		return "hello admin";
	}
}
