package com.mailnova.core.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "email_campaign")
public class EmailCampaignEntity extends AbstractIdEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "description")
    private String description;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "scheduled_at_utc")
    private Instant sendScheduleDate;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "status")
    private String status;

    @Column(name = "started_on")
    private Instant startedOn;

    @Column(name = "completed_on")
    private Instant completedOn;

    @Column(name = "cancelled_on")
    private Instant cancelledOn;

    @Column(name = "failure_reason")
    private String failureReason;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "company_id")
    private Integer companyId;


    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(Instant startedOn) {
        this.startedOn = startedOn;
    }

    public Instant getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(Instant completedOn) {
        this.completedOn = completedOn;
    }

    public Instant getCancelledOn() {
        return cancelledOn;
    }

    public void setCancelledOn(Instant cancelledOn) {
        this.cancelledOn = cancelledOn;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

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

    public Instant getSendScheduleDate() {
        return sendScheduleDate;
    }

    public void setSendScheduleDate(Instant sendScheduleDate) {
        this.sendScheduleDate = sendScheduleDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
