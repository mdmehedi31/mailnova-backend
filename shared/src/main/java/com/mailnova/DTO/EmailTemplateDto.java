package com.mailnova.DTO;

import java.time.LocalDateTime;

public class EmailTemplateDto extends AbstractId{

    private Integer typeId;
    private String name;
    private String emailSubject;
    private String emailBody;
    private Integer createdBy;
    private LocalDateTime createdOn;
    private Boolean isPublic;
    private Boolean isAiBuild;


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
