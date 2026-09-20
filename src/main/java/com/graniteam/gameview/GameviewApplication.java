package com.graniteam.gameview;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.graniteam.gameview.data.*;
import com.graniteam.gameview.services.*;

@SpringBootApplication
public class GameviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameviewApplication.class, args);
	}
}
