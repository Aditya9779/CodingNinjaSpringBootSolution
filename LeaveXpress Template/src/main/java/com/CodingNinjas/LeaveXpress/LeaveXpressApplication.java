package com.CodingNinjas.LeaveXpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Author(name = "Aditya Srivastava",date = "13-10-2024")
public class LeaveXpressApplication  {

	public static void main(String[] args) {
		SpringApplication.run(LeaveXpressApplication.class, args);
	}

}
