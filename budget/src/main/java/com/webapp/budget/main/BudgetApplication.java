package com.webapp.budget.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.webapp.budget"})
@EntityScan("com.webapp.budget")
@EnableJpaRepositories("com.webapp.budget")
public class BudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetApplication.class, args);
	}

}
