package hello.boot;

import hello.boot.config.MyDataSourceEnvConfig;
import hello.boot.config.MyDataSourceValueConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

// @Import(MyDataSourceEnvConfig.class)
@Import(MyDataSourceValueConfig.class)
@SpringBootApplication(scanBasePackages = "hello.boot.datasource")
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}
