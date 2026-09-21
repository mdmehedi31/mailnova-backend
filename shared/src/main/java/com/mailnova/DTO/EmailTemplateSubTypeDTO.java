package com.mailnova.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mailnova.exceptionmessage.ApiResponse;

import java.time.LocalDateTime;

public class EmailTemplateSubTypeDTO  extends ApiResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer emailTemplateTypeId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isActive;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdOn;

    public EmailTemplateSubTypeDTO() {
    }

    public EmailTemplateSubTypeDTO(String message) {
        super(message);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
