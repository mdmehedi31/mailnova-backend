package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplateEntity, Integer> {
}
