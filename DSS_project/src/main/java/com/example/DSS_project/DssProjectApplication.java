package com.example.DSS_project;

import com.example.DSS_project.Repository.SkierRepository;
import com.example.DSS_project.model.Skier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DssProjectApplication implements CommandLineRunner {

	private final SkierRepository skierRepository;

	@Autowired
	public DssProjectApplication(SkierRepository skierRepository) {
		this.skierRepository = skierRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DssProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(skierRepository.findAll().isEmpty()) {

			skierRepository.save(new Skier("1","2","10","2022","1","100"));
			skierRepository.save(new Skier("4","5","6","2022","1","359"));

		}

		for(Skier skier : skierRepository.findAll()){
			System.out.println(skier);
		}
		// TODO Auto-generated method stub

	}

}
