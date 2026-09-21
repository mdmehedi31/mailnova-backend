package com.mailnova.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mailnova.exceptionmessage.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

public class EmailTemplateTypeDTO extends ApiResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isActive;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdOn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<EmailTemplateSubTypeDTO> subTypes;


    public EmailTemplateTypeDTO() {
    }

    public EmailTemplateTypeDTO(String message) {
        super(message);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<EmailTemplateSubTypeDTO> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<EmailTemplateSubTypeDTO> subTypes) {
        this.subTypes = subTypes;
    }
}
