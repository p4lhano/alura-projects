package dev.palhano.mudi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.palhano.mudi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
