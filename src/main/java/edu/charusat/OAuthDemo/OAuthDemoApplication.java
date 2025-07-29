package edu.charusat.OAuthDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "edu.charusat.OAuthDemo")
@ComponentScan("edu.charusat.OAuthDemo")
public class OAuthDemoApplication {

	public static void main(String[] args) {
		System.out.println("🚀 Starting Spring Boot OAuthDemo...");
		SpringApplication.run(OAuthDemoApplication.class, args);
	}

	// @Bean
	// CommandLineRunner test(UserRepository repo) {
	// return args -> {
	// User u = new User();
	// u.setName("Mansi");
	// u.setEmail("test@charusat.edu.in");
	// u.setCreatedAt(LocalDateTime.now());
	// repo.save(u);
	// System.out.println("Inserted dummy user");
	// };
	// }
}
