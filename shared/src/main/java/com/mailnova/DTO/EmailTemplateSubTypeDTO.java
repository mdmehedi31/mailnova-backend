package com.mailnova.DTO;

import java.time.LocalDateTime;

public class EmailTemplateSubTypeDTO extends AbstractId{

    private Integer emailTemplateTypeId;
    private String name;
    private Boolean isActive;
    private LocalDateTime createdOn;


    public Integer getEmailTemplateTypeId() {
        return emailTemplateTypeId;
    }

    public void setEmailTemplateTypeId(Integer emailTemplateTypeId) {
        this.emailTemplateTypeId = emailTemplateTypeId;
    }

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
}
