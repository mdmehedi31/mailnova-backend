package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailTemplateSubTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface EmailTemplateSubTypeRepository extends JpaRepository<EmailTemplateSubTypeEntity,Integer> {
    List<EmailTemplateSubTypeEntity> findByEmailTemplateTypeId(Integer emailTemplateTypeId);
}
