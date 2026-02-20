package boot.thyme.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"data.*"})
@EntityScan({"data.dto"}) // DTO 인식
@EnableJpaRepositories("data.dao") // DAO 인식
@SpringBootApplication
public class SpringbootThymeLeafJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeLeafJpaApplication.class, args);
	}

}
