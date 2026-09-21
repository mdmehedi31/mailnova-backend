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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_template_type_id")
    private EmailTemplateTypeEntity emailTemplateType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public EmailTemplateTypeEntity getEmailTemplateType() {
        return emailTemplateType;
    }

    public void setEmailTemplateType(EmailTemplateTypeEntity emailTemplateType) {
        this.emailTemplateType = emailTemplateType;
    }
}