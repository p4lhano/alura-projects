package dev.palhano.spring.data.jpa;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.palhano.spring.data.jpa.controller.CargoController;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
	private final CargoController cargoController;
	public SpringDataJpaApplication(CargoController cargoController) {
		this.cargoController = cargoController;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc =  new Scanner(System.in);
		Boolean isContinue = true;
		
		do {
			
			System.out.println("Escolha uma opção");
			System.out.println("0 - exit");
			System.out.println("1 - Salvar produto");
			
			
			
			switch (sc.nextInt()) {
			case 0:
				isContinue = false;
				break;
			case 1:
				cargoController.salvar(sc);
				break;

			default:
				System.out.println("Invalide op\nTry out");
				break;
			}
		} while (isContinue);
		
		sc.close();
	}

}
