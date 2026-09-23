package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailFilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailFilterRepository extends JpaRepository<EmailFilterEntity, Integer> {
}
