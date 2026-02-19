package boot.mybatis.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("boot.data.*")
@MapperScan("boot.data.mapper")
@SpringBootApplication
public class SpringbootMybatisTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisTestApplication.class, args);
	}

}
