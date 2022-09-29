package dev.palhano.spring.data.jpa.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import dev.palhano.spring.data.jpa.models.Cargo;
import dev.palhano.spring.data.jpa.service.CargoService;

@Controller
public class CargoController {
	
	private final CargoService service;
	
	public CargoController(CargoService service) {
		this.service = service;
	}
	
//	public void salvar(Cargo cargo) {
	public void salvar(Scanner sc) {
		Cargo cargo = new Cargo();
		System.out.println("***Novo Cargo***");
		System.out.println("Digite o nome");
		cargo.setNome(sc.next());
		System.out.println("Digite a descrição");
		cargo.setDescricao(sc.next());
		
		
		service.save(cargo);
	};
}
