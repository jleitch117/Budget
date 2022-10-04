package com.webapp.budget.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(BudgetRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Budget( "John" , 1000, 10)));
      log.info("Preloading " + repository.save(new Budget( "Smith" , 1300, 100)));
    };
  }
}