package com.enp.codecrush.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Pasar variables como propiedades del sistema (opcional)
        System.setProperty("sandbox.api-url", dotenv.get("SANDBOX_API_URL"));
        System.setProperty("sandbox.client-id", dotenv.get("SANDBOX_CLIENT_ID"));
        System.setProperty("sandbox.client-secret", dotenv.get("SANDBOX_CLIENT_SECRET"));
        System.setProperty("sandbox.timeout", dotenv.get("SANDBOX_TIMEOUT"));
        
		SpringApplication.run(Application.class, args);
	}

}
