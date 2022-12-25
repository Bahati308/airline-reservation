package com.insidercloud.airlinereservation;

import com.insidercloud.airlinereservation.models.Plane;
import com.insidercloud.airlinereservation.models.User;
import com.insidercloud.airlinereservation.repositories.PlaneRepository;
import com.insidercloud.airlinereservation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class AirlineReservationApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PlaneRepository planeRepository;
	@Autowired
	public AirlineReservationApplication(UserRepository userRepository, PlaneRepository planeRepository) {
		this.userRepository = userRepository;
		this.planeRepository = planeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationApplication.class, args);
	}
	private final Logger log = LoggerFactory.getLogger(AirlineReservationApplication.class.getName());

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.findAll().isEmpty()){
			userRepository.save(new User("John","Doe","doe@air.com"));
		}
		if (planeRepository.findAll().isEmpty()){
			planeRepository.save(new Plane("Airbus A220-300","A220","Airbus", 30, 120, 1000));
			planeRepository.save(new Plane("Airbus A320neo","A320","Airbus", 30, 150, 1100));
			planeRepository.save(new Plane("Airbus A330-300","A330","Airbus", 40, 250, 1600));
			planeRepository.save(new Plane("Airbus A350-900","A350","Airbus", 50, 300, 1800));
			planeRepository.save(new Plane("Airbus A380-800","A380","Airbus", 60, 400, 2000));
			planeRepository.save(new Plane("Boeing 737-800","737","Boeing",30, 150, 1100));
			planeRepository.save(new Plane("Boeing 747-8","747","Boeing", 40, 250, 1600));
			planeRepository.save(new Plane("Boeing 777-300ER","777","Boeing", 50, 300, 1800));
			planeRepository.save(new Plane("Boeing 787-9","787","Boeing", 60, 400, 2000));
			planeRepository.save(new Plane("Boeing 737 MAX 8","737 MAX","Boeing", 30, 150, 1100));
			planeRepository.save(new Plane("Boeing 737 MAX 9","737 MAX","Boeing", 30, 150, 1100));
			planeRepository.save(new Plane("Boeing 737 MAX 10","737 MAX","Boeing", 30, 150, 1100));
			planeRepository.save(new Plane("Boeing 777X","777X","Boeing", 50, 300, 1800));
		}
		for (User user:userRepository.findAll()){
			log.info(user.toString());
		}
		for(Plane plane:planeRepository.findAll()){
			log.info(plane.toString());
		}

	}
}
