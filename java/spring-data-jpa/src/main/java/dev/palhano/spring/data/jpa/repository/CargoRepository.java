package dev.palhano.spring.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.palhano.spring.data.jpa.models.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {

}
