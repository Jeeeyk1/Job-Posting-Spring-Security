package com.example.MongdoDb.UsersRepository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MongdoDb.UsersModel.UsersModel;

public interface UsersRepository extends MongoRepository<UsersModel, String> {

	@Query("{'email': ?0}")
	Optional<UsersModel> findByUsername(String email);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
