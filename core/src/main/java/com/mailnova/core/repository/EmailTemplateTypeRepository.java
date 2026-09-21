package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailTemplateTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmailTemplateTypeRepository extends JpaRepository<EmailTemplateTypeEntity, Integer> {
    EmailTemplateTypeEntity findByName(String name);

    Optional<EmailTemplateTypeEntity> findByIdAndIsActive(Integer id, Boolean isActive);

    @Query("select t from EmailTemplateTypeEntity  t where t.id=:id and (t.isActive is null or t.isActive=true)")
    Optional<EmailTemplateTypeEntity> findByIdAndIsActiveIsNullOrIsActive(Integer id);

    List<EmailTemplateTypeEntity> findAllByIsActiveIsNullOrIsActive(Boolean isActive);
}
