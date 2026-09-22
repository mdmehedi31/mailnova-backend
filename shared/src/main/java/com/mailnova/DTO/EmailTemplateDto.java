package com.mailnova.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mailnova.exceptionmessage.ApiResponse;

import java.time.LocalDateTime;

public class EmailTemplateDto extends ApiResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer typeId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emailSubject;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emailBody;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer createdBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdOn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isPublic=true;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isAiBuild=true;

    public EmailTemplateDto() {
    }

    public EmailTemplateDto(String message) {
        super(message);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Boolean getAiBuild() {
        return isAiBuild;
    }

    public void setAiBuild(Boolean aiBuild) {
        isAiBuild = aiBuild;
    }
}
