package org.example.enocatask1;

import org.example.enocatask1.entities.User;
import org.example.enocatask1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EnocaTask1Application implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(EnocaTask1Application.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User admin = userRepo.findByRole("ROLE_ADMIN");
		if (admin == null) {
			User user = new User();
			user.setName("admin");
			user.setSurname("admin");
			user.setEmail("admin@mail.com");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user.setRole("ROLE_ADMIN");
			userRepo.save(user);
		}
	}
}
