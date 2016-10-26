package com.kf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kf.model.DoPerson;
import com.kf.repository.PersonRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new DoPerson("Jack", "Bauer"));
			repository.save(new DoPerson("Chloe", "O'Brian"));
			repository.save(new DoPerson("Kim", "Bauer"));
			repository.save(new DoPerson("David", "Palmer"));
			repository.save(new DoPerson("Michelle", "Dessler"));

			// fetch all customers
			log.info("persons found with findAll():");
			log.info("-------------------------------");
			for (DoPerson person : repository.findAll()) {
				log.info(person.toString());
			}
            log.info("");

			// fetch an individual customer by ID
			DoPerson person = repository.findOne(1L);
			log.info("person found with findOne(1L):");
			log.info("--------------------------------");
			log.info(person.toString());
            log.info("");

			// fetch customers by last name
			log.info("person found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (DoPerson bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
            log.info("");
		};
	}

}
