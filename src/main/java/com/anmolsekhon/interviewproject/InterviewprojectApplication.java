package com.anmolsekhon.interviewproject;

import com.anmolsekhon.interviewproject.domain.Asset;
import com.anmolsekhon.interviewproject.services.AssetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@SpringBootApplication
public class InterviewprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewprojectApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AssetService assetService) {
		return args->{
//			Inserting Sample Data
			assetService.saveAsset(
					new Asset(1L, "Dell Optiplex", "A Desktop PC",
							220.00, LocalDate.of(2020, Month.AUGUST, 24), 1L)
			);

		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
