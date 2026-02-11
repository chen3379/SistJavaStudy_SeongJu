package boot.day0210.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("boot.*")
@SpringBootApplication
public class SpringbootQuiz0210Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuiz0210Application.class, args);
	}

}
