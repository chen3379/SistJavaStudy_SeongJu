package boot.react.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.data.*","boot.react.shop"})
@MapperScan("boot.data.mapper")
public class SpringBootReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactApplication.class, args);
	}

}