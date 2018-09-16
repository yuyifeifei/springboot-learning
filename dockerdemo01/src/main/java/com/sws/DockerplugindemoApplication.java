package com.sws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@MapperScan("com.sws.mapper")
public class DockerplugindemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerplugindemoApplication.class, args);
	}
}
