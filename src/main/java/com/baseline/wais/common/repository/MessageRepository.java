package com.baseline.wais.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baseline.wais.common.entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, String> {
	
	@Query("SELECT shortMessage FROM message WHERE code = :code")
	public String getShortMessageByCode(@Param("code") String code);
	
	@Query("SELECT longMessage FROM message WHERE code = :code")
	public String getLongMessageByCode(@Param("code") String code);

}
