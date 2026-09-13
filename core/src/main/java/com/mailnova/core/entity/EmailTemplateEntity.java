package com.mailnova.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_template")
public class EmailTemplateEntity extends AbstractIdEntity{

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_subject")
    private String emailSubject;

    @Column(name = "email_body")
    private String emailBody;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "is_public")
    private Boolean isPublic = false;

    @Column(name = "is_ai_build")
    private Boolean isAiBuild = true;


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
