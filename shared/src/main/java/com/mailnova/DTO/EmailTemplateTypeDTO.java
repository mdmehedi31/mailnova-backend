package com.mailnova.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class EmailTemplateTypeDTO extends AbstractId {

    private String name;
    private String description;
    private Boolean isActive;
    private LocalDateTime createdOn;
    private List<EmailTemplateSubTypeDTO> subTypes;

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

    public List<EmailTemplateSubTypeDTO> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<EmailTemplateSubTypeDTO> subTypes) {
        this.subTypes = subTypes;
    }
}
