package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailFilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailFilterRepository extends JpaRepository<EmailFilterEntity, Integer> {
    EmailFilterEntity findByNameAndCreatedBy(String name, Integer createdBy);

    List<EmailFilterEntity> findAllByCreatedBy(Integer createdBy);
}
