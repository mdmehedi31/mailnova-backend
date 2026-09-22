package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplateEntity, Integer> {

    @Query("SELECT t FROM EmailTemplateEntity  t where t.id=:id and (t.isDeleted is null  or t.isDeleted=false) ")
    EmailTemplateEntity findByIdAndIsDeletedIsNullOrIsDeleted(Integer id);


    @Query("SELECT t FROM EmailTemplateEntity  t where t.createdBy=:createdBy and (t.isDeleted is null OR t.isDeleted=false)")
    List<EmailTemplateEntity> findAllByCreatedBy(Integer createdBy);

    EmailTemplateEntity findByName(String name);

    EmailTemplateEntity findByNameAndCreatedBy(String name, Integer createdBy);
}
