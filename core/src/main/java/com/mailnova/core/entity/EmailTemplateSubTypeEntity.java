package com.mailnova.core.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_email_template_sub_type")
public class EmailTemplateSubTypeEntity extends AbstractIdEntity {

    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_on")
    private LocalDateTime createdOn;


    @JoinColumn(name = "email_template_type_id")
    private Integer emailTemplateTypeId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getEmailTemplateTypeId() {
        return emailTemplateTypeId;
    }

    public void setEmailTemplateTypeId(Integer emailTemplateTypeId) {
        this.emailTemplateTypeId = emailTemplateTypeId;
    }
}