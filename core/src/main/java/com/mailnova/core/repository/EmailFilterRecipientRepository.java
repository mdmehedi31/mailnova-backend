package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailFilterRecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailFilterRecipientRepository extends JpaRepository<EmailFilterRecipientEntity,Integer> {
}
