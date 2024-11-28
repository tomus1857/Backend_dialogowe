package com.backend.dialogowe;
import com.backend.dialogowe.UserRepository.UserRepository;
import com.backend.dialogowe.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class DialogoweApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DialogoweApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(3L, "Pawel", "john.doe@example.com"));
	}

}
