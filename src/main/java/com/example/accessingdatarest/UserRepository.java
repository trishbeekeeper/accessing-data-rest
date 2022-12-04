package com.example.accessingdatarest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	//note that simple methods like insert/create, select/find/read, update/put, 
	//and delete are provided by JPA when the appropriate methods are used
	//to call the Repository
}
