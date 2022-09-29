package dev.palhano.spring.data.jpa.service;

import org.springframework.stereotype.Service;

import dev.palhano.spring.data.jpa.models.Cargo;
import dev.palhano.spring.data.jpa.repository.CargoRepository;

@Service
public class CargoService {
	
	private final CargoRepository repository;
	
	public CargoService(CargoRepository repository) {
		this.repository = repository;
	}
	
	public void save(Cargo cargo) {
		if(cargo == null)
			throw new IllegalArgumentException();
		if(cargo.getNome() == null || cargo.getNome().trim().isEmpty())
			throw new IllegalArgumentException("Campos nome preenchido de maneira incorreta");
		repository.save(cargo);
	}
	
}
