package com.example.demo;

import java.time.ZonedDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Action;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserRepository personRepo = this.context.getBean(UserRepository.class);
		AddressRepository addressRepo = context.getBean(AddressRepository.class);

		Address address = new Address();
		address.setCity("221b Baker Street");
		address.setState("London NW1");
		address.setAddress("London");
		address.setZipcode(12345l);
		addressRepo.save(address);
		
		Action action = new Action();
		action.setDescription("des");
		action.setTime(ZonedDateTime.now());

		User personAchilles = new User();
		personAchilles.setName("Achilles");
		personAchilles.setAddress(address);
		personAchilles.setActions(Stream.of(action).collect(Collectors.toSet()));
		personRepo.save(personAchilles);

		User personHektor = new User();
		personHektor.setName("Hektor");
		personHektor.setActions(Stream.of(action).collect(Collectors.toSet()));
		personRepo.save(personHektor);

	}

}