package com.baseline.wais.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.baseline.wais.common.entity.LoginEntity;

@Repository
public interface LoginRepository extends MongoRepository<LoginEntity, Integer>{
	
	LoginEntity findByUsername(String username);
}
