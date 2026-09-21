package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailTemplateTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateTypeRepository extends JpaRepository<EmailTemplateTypeEntity, Integer> {
}
