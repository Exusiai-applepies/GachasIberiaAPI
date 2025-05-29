package com.gachasIberiaAPI.GachasIberiaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GachasIberiaApiApplication {

	public static void main(String[] args) {
		try {
			ApplicationContext context = SpringApplication.run(GachasIberiaApiApplication.class, args);
			System.out.println("✅ Gachas Iberia API iniciada correctamente");
		} catch (Throwable t) {
			t.printStackTrace();
			// Pausa para que puedas ver el error antes de que el proceso termine
			try { Thread.sleep(60000); } catch (InterruptedException ignored) {}
		}
	}

}