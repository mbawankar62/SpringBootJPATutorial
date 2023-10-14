package com.zensar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.entity.Laptop;
import com.zensar.entity.User;
import com.zensar.repository.UserRepository;

@SpringBootApplication
public class EntityRelationshipApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EntityRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//1-1
		/*
		User user=new User("Ram");
		Laptop laptop1=new Laptop("DELL");
		user.setLaptop(laptop1);
		laptop1.setUser(user);
		userRepository.save(user);*/
		
		
		User user=new User("Ram");
		Laptop laptop1=new Laptop("DELL");
		Laptop laptop2=new Laptop("HP");
		
		List<Laptop> laptops=new ArrayList<>();
		laptops.add(laptop1);
		laptops.add(laptop2);
		
		laptop1.setUser(user);
		laptop2.setUser(user);
		user.setLaptop(laptops);
		
		userRepository.save(user);
		
		User user1 = userRepository.findById(1).get();
		System.out.println(user1.getUserName());
		System.out.println(user1.getLaptop());
	}

}
