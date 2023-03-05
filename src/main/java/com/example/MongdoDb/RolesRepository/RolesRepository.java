package com.example.MongdoDb.RolesRepository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.MongdoDb.Enums.ERoles;
import com.example.MongdoDb.RolesModel.Roles;

@Repository
public interface RolesRepository extends MongoRepository<Roles, String> {
//	Optional<Roles> findByName(ERoles name);
}
