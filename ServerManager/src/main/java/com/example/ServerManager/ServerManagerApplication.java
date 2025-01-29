package com.example.ServerManager;

import com.example.ServerManager.enumaration.Status;
import com.example.ServerManager.model.Server;
import com.example.ServerManager.repository.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

}
