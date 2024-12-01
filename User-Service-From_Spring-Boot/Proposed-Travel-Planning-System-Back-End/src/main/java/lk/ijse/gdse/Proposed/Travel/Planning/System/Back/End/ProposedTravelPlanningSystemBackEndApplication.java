package lk.ijse.gdse.Proposed.Travel.Planning.System.Back.End;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication

public class ProposedTravelPlanningSystemBackEndApplication {
	@Bean
	public ModelMapper ModelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(ProposedTravelPlanningSystemBackEndApplication.class, args);
	}




}
