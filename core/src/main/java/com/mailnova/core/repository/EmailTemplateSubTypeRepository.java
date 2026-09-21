package com.mailnova.core.repository;

import com.mailnova.core.entity.EmailTemplateSubTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmailTemplateSubTypeRepository extends JpaRepository<EmailTemplateSubTypeEntity,Integer> {

    @Query("SELECT t from EmailTemplateSubTypeEntity t where t.isActive is null or t.isActive=true ")
    List<EmailTemplateSubTypeEntity> findByEmailTemplateTypeId(Integer emailTemplateTypeId);

    EmailTemplateSubTypeEntity findByEmailTemplateTypeIdAndName(Integer emailTemplateTypeId, String name);

    @Query("select st from EmailTemplateSubTypeEntity  st where st.id=:id and (st.isActive is null or st.isActive=true )")
    Optional<EmailTemplateSubTypeEntity> findByIdAndIsActive(Integer id);

    @Query("select es from EmailTemplateSubTypeEntity es where es.isActive is null or es.isActive=true")
    List<EmailTemplateSubTypeEntity> findAllAndIsActive();
}
