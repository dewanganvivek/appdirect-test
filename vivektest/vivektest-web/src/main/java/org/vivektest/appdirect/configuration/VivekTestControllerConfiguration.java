package org.vivektest.appdirect.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackages = "org.vivektest.hibernate.model")
@EnableJpaRepositories(basePackages = "org.vivektest.repositories")
@EnableTransactionManagement
@ComponentScan(basePackages = "org.vivektest.*")
public class VivekTestControllerConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(VivekTestControllerConfiguration.class, args);
	}

}
