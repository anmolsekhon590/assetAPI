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
        return args -> {
//			Inserting Sample Data
            assetService.saveAsset(
                    new Asset(1L, "Dell Optiplex", "A Desktop PC",
                            220.00, LocalDate.of(2020, Month.AUGUST, 24), 1L)
            );

            assetService.saveAsset(
                    new Asset(2L, "Windows 10 - Home", "An Operating System",
                            80.0, LocalDate.of(2021, Month.FEBRUARY, 19), 0L)
            );

            assetService.saveAsset(new Asset(3L, "HP Server", "Server Hardware",
                    500.50, LocalDate.of(2018, Month.JULY, 2), 1L)

            );

        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
