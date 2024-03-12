package com.baseline.wais.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.baseline.wais.common.entity.SubMenuEntity;

@Repository
public interface SubMenuRepository extends MongoRepository<SubMenuEntity, Integer>{

}
