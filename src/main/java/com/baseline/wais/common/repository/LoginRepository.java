package com.baseline.wais.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baseline.wais.common.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer>{
	
	LoginEntity findByUsername(String username);
}
