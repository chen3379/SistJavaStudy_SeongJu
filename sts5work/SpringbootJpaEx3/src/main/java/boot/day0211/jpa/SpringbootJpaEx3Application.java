package boot.day0211.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("boot.*")
@EntityScan("boot.*") //dto 인식
@EnableJpaRepositories("boot.*") //dao 인식 CRUD 메서드 처리하는 곳
public class SpringbootJpaEx3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaEx3Application.class, args);
	}

}
