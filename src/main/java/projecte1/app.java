package projecte1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import project1.repo.AlumnosRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AlumnosRepo.class)
public class app {

	public static void main(String[] args) {
		SpringApplication.run(app.class, args);
	}

}
