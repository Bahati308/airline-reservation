package com.insidercloud.airlinereservation;

import com.insidercloud.airlinereservation.models.User;
import com.insidercloud.airlinereservation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineReservationApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	@Autowired
	public AirlineReservationApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.findAll().isEmpty()){
			userRepository.save(new User("John","Doe","doe@air.com"));
		}
		for (User user:userRepository.findAll()){
			System.out.println(user.toString());
		}

	}
}
