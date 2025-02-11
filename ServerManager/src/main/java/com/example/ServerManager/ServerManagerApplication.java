package com.example.ServerManager;

import com.example.ServerManager.enumaration.Status;
import com.example.ServerManager.model.Server;
import com.example.ServerManager.repository.ServerRepo;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class ServerManagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServerManagerApplication.class, args);
	}
    @Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null,
					"192.168.1.160",
					"Ubuntu linux",
					"16 GB",
					"Personal PC",
					"http://localhost:8080/server/image/server1.png",
					Status.SERVER_UP));
			serverRepo.save(new Server(null,
					"192.168.1.161",
					"Fedora linux",
					"16 GB",
					"Personal PC",
					"http://localhost:8080/server/image/server2.png",
					Status.SERVER_UP));
			serverRepo.save(new Server(null,
					"192.168.1.162",
					"MS 2008",
					"32 GB",
					"HP",
					"http://localhost:8080/server/image/server3.png",
					Status.SERVER_UP));
			serverRepo.save(new Server(null,
					"192.168.1.163",
					"Red Hat Enterprise linux",
					"16 GB",
					"Lenovo",
					"http://localhost:8080/server/image/server4.png",
					Status.SERVER_DOWN));
		};
	}
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
