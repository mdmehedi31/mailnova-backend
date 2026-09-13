package com.mailnova.DTO;

import java.time.LocalDateTime;

public class EmailCampaignDto extends AbstractId{

    private String name;
    private LocalDateTime createdOn;
    private String description;
    private Integer createdBy;
    private LocalDateTime sendScheduleDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getSendScheduleDate() {
        return sendScheduleDate;
    }

    public void setSendScheduleDate(LocalDateTime sendScheduleDate) {
        this.sendScheduleDate = sendScheduleDate;
    }
}
