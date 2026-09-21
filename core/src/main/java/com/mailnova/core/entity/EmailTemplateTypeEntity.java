package com.mailnova.core.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_email_template_type")
public class EmailTemplateTypeEntity extends AbstractIdEntity {

    private String name;

    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @OneToMany(mappedBy = "emailTemplateType")
    private List<EmailTemplateSubTypeEntity> subTypes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<EmailTemplateSubTypeEntity> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<EmailTemplateSubTypeEntity> subTypes) {
        this.subTypes = subTypes;
    }
}