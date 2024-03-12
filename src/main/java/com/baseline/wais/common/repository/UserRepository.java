package com.baseline.wais.common.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.baseline.wais.common.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, ObjectId>{
}
