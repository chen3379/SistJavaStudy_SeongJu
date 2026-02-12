package boot.jpa.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("boot.*")
@EntityScan("boot.board.data")
@EnableJpaRepositories("boot.*")
@SpringBootApplication
public class SpringbootJpaUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaUploadApplication.class, args);
	}

}
